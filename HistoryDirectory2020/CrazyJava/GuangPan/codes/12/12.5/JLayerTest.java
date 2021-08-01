import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.geom.Point2D;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class FirstLayerUI extends LayerUI<JComponent>
{
	public void paint(Graphics g, JComponent c)
	{
		super.paint(g, c);
		Graphics2D g2 = (Graphics2D) g.create();
		// ����͸��Ч��
		g2.setComposite(AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, .5f));
		// ʹ�ý��仭�ʻ�ͼ
		g2.setPaint(new GradientPaint(0 , 0 , Color.RED
			, 0 , c.getHeight() , Color.BLUE));
		// ����һ���뱻װ�������ͬ��С�ľ���
		g2.fillRect(0, 0, c.getWidth(), c.getHeight());     //��
		g2.dispose();
	}
}
class BlurLayerUI extends LayerUI<JComponent> 
{
	private BufferedImage screenBlurImage;
	private BufferedImageOp operation;
	public BlurLayerUI() 
	{
		float ninth = 1.0f / 9.0f;
		// ����ģ������
		float[] blurKernel = {
			ninth, ninth, ninth,
			ninth, ninth, ninth,
			ninth, ninth, ninth
		};
		// ConvolveOp����һ��ģ����������ԭͼƬ��ÿһ����������Χ
		// ���ص���ɫ���л�ϣ��Ӷ��������ǰ���ص���ɫֵ��
		operation = new ConvolveOp(
			new Kernel(3, 3, blurKernel),
			ConvolveOp.EDGE_NO_OP, null);
	}
	public void paint(Graphics g, JComponent c)
	{
		int w = c.getWidth();
		int h = c.getHeight();
		// �����װ�δ��ڴ�СΪ0X0,ֱ�ӷ���
		if (w == 0 || h == 0)
			return;
		// ���screenBlurImageû�г�ʼ���������ĳߴ粻�ԡ�
		if (screenBlurImage == null 
			|| screenBlurImage.getWidth() != w 
			|| screenBlurImage.getHeight() != h)
		{
			// ���´����µ�BufferdImage
			screenBlurImage = new BufferedImage(w
				, h , BufferedImage.TYPE_INT_RGB);
		}
		Graphics2D ig2 = screenBlurImage.createGraphics();
		// �ѱ�װ������Ľ�����Ƶ���ǰscreenBlurImage��
		ig2.setClip(g.getClip());
		super.paint(ig2, c);
		ig2.dispose();
		Graphics2D g2 = (Graphics2D)g;
		// ��JLayerװ�ε��������ģ������
		g2.drawImage(screenBlurImage, operation, 0, 0);
	}
}
class SpotlightLayerUI extends LayerUI<JComponent> 
{
	private boolean active;
	private int cx, cy;

	public void installUI(JComponent c)
	{
		super.installUI(c);
		JLayer layer = (JLayer)c;
		// ����JLayer������Ӧ��ꡢ��궯���¼�
		layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK 
			| AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}
	public void uninstallUI(JComponent c) 
	{
		JLayer layer = (JLayer)c;
		// ����JLayer����Ӧ�κ��¼�
		layer.setLayerEventMask(0);
		super.uninstallUI(c);
	}
	public void paint(Graphics g, JComponent c) 
	{
		Graphics2D g2 = (Graphics2D)g.create();
		super.paint (g2, c);
		// ������ڼ���״̬
		if (active) 
		{
			// ����һ��cx��cyλ�õĵ�
			Point2D center = new Point2D.Float(cx, cy);
			float radius = 72;
			float[] dist = {0.0f, 1.0f};
			Color[] colors = {Color.YELLOW , Color.BLACK};
			// ��centerΪ���ġ�colorsΪ��ɫ���鴴�����ν���
			RadialGradientPaint p = new RadialGradientPaint(center
				, radius , dist , colors);
			g2.setPaint(p);
			// ���ý���Ч��
			g2.setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, .6f));
			// ���ƾ���
			g2.fillRect(0, 0, c.getWidth(), c.getHeight());
		}
		g2.dispose();
	}

	// ��������¼��ķ���
	public void processMouseEvent(MouseEvent e, JLayer layer) 
	{
		if (e.getID() == MouseEvent.MOUSE_ENTERED) 
			active = true;
		if (e.getID() == MouseEvent.MOUSE_EXITED)
			active = false;
		layer.repaint();
	}
	// ������궯���¼��ķ���
	public void processMouseMotionEvent(MouseEvent e, JLayer layer) 
	{
		Point p = SwingUtilities.convertPoint(
			e.getComponent(), e.getPoint(), layer);
		// ��ȡ��궯���¼��ķ����������
		cx = p.x;
		cy = p.y;
		layer.repaint();
	}
}
public class JLayerTest
{
	public void init() 
	{
		JFrame f = new JFrame("JLayer����");
		JPanel p = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton radioButton;
		// ����3��RadioButton������������ӳ�һ��
		p.add(radioButton = new JRadioButton("��������", true));
		group.add(radioButton);
		p.add(radioButton = new JRadioButton("��깺��"));
		group.add(radioButton);
		p.add(radioButton = new JRadioButton("ͼ��ݽ���"));
		group.add(radioButton);
		// ���3��JCheckBox
		p.add(new JCheckBox("���Java����"));
		p.add(new JCheckBox("���Android����"));
		p.add(new JCheckBox("���Ajax����"));
		p.add(new JCheckBox("������Java EE��ҵӦ��"));
		JButton orderButton = new JButton("ͶƱ");
		p.add(orderButton);
		// ����LayerUI����
		LayerUI<JComponent> layerUI = new SpotlightLayerUI();      //��
		// ʹ��layerUI��װ��ָ����JPanel���
		JLayer<JComponent> layer = new JLayer<JComponent>(p, layerUI);
		// ��װ�κ��JPanel�����ӵ�������
		f.add(layer);
		f.setSize(300, 170);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		f.setVisible (true);
	}
	public static void main(String[] args) 
	{
		new JLayerTest().init();
	}
}