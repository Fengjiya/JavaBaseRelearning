
import java.beans.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
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
class WaitLayerUI extends LayerUI<JComponent> 
{
	private boolean isRunning;
	private boolean isFadingOut;
	private Timer timer;
	// ��¼ת���ĽǶ�
	private int angle;
	private int fadeCount;
	private int FADE_LIMIT = 15;

	public void paint (Graphics g, JComponent c) 
	{
		int w = c.getWidth();
		int h = c.getHeight();
		super.paint (g, c);
		// �Ѿ�ֹͣ����
		if (!isRunning)
			return;
		Graphics2D g2 = (Graphics2D)g.create();
		float fade = (float)fadeCount / FADE_LIMIT;
		Composite urComposite = g2.getComposite();
		g2.setComposite(AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, .5f * fade));
		// ������
		g2.fillRect(0, 0, w, h);
		g2.setComposite(urComposite);
		// -----������뿪ʼ����ת���еġ����֡�----
		// ����õ������н�Сֵ��1/5
		int s = Math.min(w , h) / 5;
		int cx = w / 2;
		int cy = h / 2;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING 
			, RenderingHints.VALUE_ANTIALIAS_ON);
		// ���ñʴ�
		g2.setStroke( new BasicStroke(s / 2
			, BasicStroke.CAP_ROUND , BasicStroke.JOIN_ROUND));
		g2.setPaint(Color.BLUE);
		// �����Ʊ�װ�����������ת��angle��
		g2.rotate(Math.PI * angle / 180, cx, cy);
		// ѭ������12���������γɡ����֡�
		for (int i = 0; i < 12; i++) 
		{
			float scale = (11.0f - (float)i) / 11.0f;
			g2.drawLine(cx + s, cy, cx + s * 2, cy);
			g2.rotate(-Math.PI / 6, cx, cy);
			g2.setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, scale * fade));
		}
		g2.dispose();
	}
	// ���Ƶȴ������ֿ�ʼת�����ķ���
	public void start() 
	{
		// ����Ѿ��������У�ֱ�ӷ���
		if (isRunning) 
			return;
		// ����һ���߳�����ʼ����
		isRunning = true;
		isFadingOut = false;
		fadeCount = 0;
		// ÿ��0.1���ػ�һ��
		timer = new Timer(100, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isRunning) 
				{
					System.out.println(fadeCount);
					// ����applyPropertyChange()��������JLayer�ػ档
					// �����д����У�������������û�����塣
					firePropertyChange("crazyitFlag", 0 , 1);
					// �Ƕȼ�3
					angle += 6;
					// ����360���ٴ�0��ʼ
					if (angle >= 360) 
						angle = 0;
					if (isFadingOut)
					{
						if (--fadeCount == 0) 
						{
							isRunning = false;
							timer.stop();
						}
					}
					else if (fadeCount < FADE_LIMIT)
					{
						fadeCount++;
					}
				}
			}
		});
		timer.start();
	}
	// ����ֹͣ�ȴ�������ֹͣת�����ķ���
	public void stop()
	{
		isFadingOut = true;
	}
	public void applyPropertyChange(PropertyChangeEvent pce
		, JLayer layer) 
	{
		// ����JLayer�ػ�
		if (pce.getPropertyName().equals("crazyitFlag"))
		{
			layer.repaint();
		}
	}
}
public class WaitingJLayerSenior
{
	public void init() 
	{
		JFrame f = new JFrame("ת���ġ����֡�");
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
		final WaitLayerUI layerUI = new WaitLayerUI();
		// ʹ��layerUI��װ��ָ��JPanel���
		JLayer<JComponent> layer = new JLayer<JComponent>(p, layerUI);
		// ����5��֮��ִ��ָ������������layerUI��stop()����
		final Timer stopper = new Timer(5000, new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{
				layerUI.stop();
			}
		});
		// ����stopper��ʱ��ֻ����һ�Ρ�
		stopper.setRepeats(false);
		// ΪorderButton���¼��������������ð�ťʱ:����layerUI��start()����
		orderButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				layerUI.start();
				// ���stopper��ʱ����ֹͣ��������
				if (!stopper.isRunning()) 
				{
					stopper.start();
				}
			}
		});
		// ��װ�κ��JPanel�����ӵ�������
		f.add(layer);
		f.setSize(300, 170);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		f.setVisible (true);
	}
	public static void main(String[] args) 
	{
		new WaitingJLayerSenior().init();
	}
}