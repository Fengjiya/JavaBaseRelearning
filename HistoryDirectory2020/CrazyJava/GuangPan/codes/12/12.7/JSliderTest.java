
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Dictionary;
import java.util.Hashtable;
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
public class JSliderTest
{
	JFrame mainWin = new JFrame("������ʾ��");
	Box sliderBox = new Box(BoxLayout.Y_AXIS);
	JTextField showVal = new JTextField();
	ChangeListener listener;
	public void init() 
	{
		// ����һ�������������ڼ������л�����
		listener = new ChangeListener()
		{  
			public void stateChanged(ChangeEvent event)
			{  
				// ȡ����������ֵ�������ı�����ʾ����
				JSlider source = (JSlider) event.getSource();
				showVal.setText("��ǰ��������ֵΪ��" 
					+ source.getValue());
			}
		};
		// -----------���һ����ͨ������-----------
		JSlider slider = new JSlider();
		addSlider(slider, "��ͨ������");
		// -----------��ӱ�����Ϊ30�Ļ�����-----------
		slider = new JSlider();
		slider.setExtent(30);
		addSlider(slider, "������Ϊ30");
		// ---��Ӵ������ο̶ȵĻ�����,�����������ֵ����Сֵ---
		slider = new JSlider(30 , 200);
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "�п̶�");
		// -----------��ӻ������ͣ�ڿ̶ȴ�������-----------
		slider = new JSlider();
		// ���û������ͣ�ڿ̶ȴ�
		slider.setSnapToTicks(true);
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "����ͣ�ڿ̶ȴ�");
		// -----------���û�л���Ļ�����-----------
		slider = new JSlider();
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// ���ò����ƻ���
		slider.setPaintTrack(false);
		addSlider(slider, "�޻���");
		// -----------��ӷ���ת�Ļ�����-----------
		slider = new JSlider();
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// ���÷���ת
		slider.setInverted(true);
		addSlider(slider, "����ת");
		// --------��ӻ���Ĭ�Ͽ̶ȱ�ǩ�Ļ�����--------
		slider = new JSlider();
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// ���û��ƿ̶ȱ�ǩ��Ĭ�ϻ�����ֵ�̶ȱ�ǩ
		slider.setPaintLabels(true);
		addSlider(slider, "��ֵ�̶ȱ�ǩ");
		// ------��ӻ���Label���͵Ŀ̶ȱ�ǩ�Ļ�����------
		slider = new JSlider();
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// ���û��ƿ̶ȱ�ǩ
		slider.setPaintLabels(true);
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		// ָ���̶ȱ�ǩ����ǩ��JLabel
		slider.setLabelTable(labelTable);
		addSlider(slider, "JLable��ǩ");
		// ------��ӻ���Label���͵Ŀ̶ȱ�ǩ�Ļ�����------
		slider = new JSlider();
		// ���û��ƿ̶�
		slider.setPaintTicks(true);
		// ���������ο̶ȵļ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// ���û��ƿ̶ȱ�ǩ
		slider.setPaintLabels(true);
		labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel(new ImageIcon("ico/0.GIF")));
		labelTable.put(20, new JLabel(new ImageIcon("ico/2.GIF")));
		labelTable.put(40, new JLabel(new ImageIcon("ico/4.GIF")));
		labelTable.put(60, new JLabel(new ImageIcon("ico/6.GIF")));
		labelTable.put(80, new JLabel(new ImageIcon("ico/8.GIF")));
		// ָ���̶ȱ�ǩ����ǩ��ImageIcon
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon��ǩ");
		mainWin.add(sliderBox, BorderLayout.CENTER);
		mainWin.add(showVal, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	// ����һ�����������ڽ���������ӵ�������
	public void addSlider(JSlider slider, String description)
	{ 
		slider.addChangeListener(listener);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel(description + "��"));
		box.add(slider);
		sliderBox.add(box);
	}
	public static void main(String[] args)
	{
		new JSliderTest().init();
	}
}

