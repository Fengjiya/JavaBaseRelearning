package LanTalk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
// ��¼�õĶԻ���
public class LoginFrame extends JDialog
{
	public JLabel tip;
	public JTextField userField = new JTextField("���" , 20);
	public JComboBox<Integer> iconList = new JComboBox<>(
		new Integer[]{1, 2, 3, 4, 5 , 6, 7, 8 ,9 ,10});
	private JButton loginBn = new JButton("��¼");
	// �����������
	private LanTalk chatFrame;	
	// ����ͨ�ŵĹ���ʵ��
	public static ComUtil comUtil;
	// �����������ڳ�ʼ���ĵ�¼�Ի���
	public LoginFrame(LanTalk parent , String msg)
	{
		super(parent , "�������ֺ��¼" , true);
		this.chatFrame = parent;
		setLayout(new GridLayout(5, 1));
		JPanel jp = new JPanel();
		tip = new JLabel(msg);
		tip.setFont(new Font("Serif" , Font.BOLD , 16));
		jp.add(tip); 
		add(jp);
		add(getPanel("�û���" , userField));
		iconList.setPreferredSize(new Dimension(224, 20));
		add(getPanel("ͼ    ��" , iconList));
		JPanel bp = new JPanel();
		loginBn.addActionListener(new MyActionListener(this));
		bp.add(loginBn); 
		add(bp);
		pack();
		setVisible(true);
	}
	// ���߷������÷�����һ���ַ����������ϳ�JPanel����
	private JPanel getPanel(String name , JComponent jf)
	{
		JPanel jp = new JPanel();
		jp.add(new JLabel(name + "��"));
		jp.add(jf);
		return jp;
	}
	// �÷������ڸı��¼�������������ʾ��Ϣ
	public void setTipMsg(String tip)
	{
		this.tip.setText(tip);
	}
	// ����һ���¼�������
	class MyActionListener implements ActionListener
	{
		private LoginFrame loginFrame;
		public MyActionListener(LoginFrame loginFrame)
		{
			this.loginFrame = loginFrame;
		}
		// ����굥���¼�����ʱ
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				// ��ʼ������ͨ����
				comUtil = new ComUtil(chatFrame);
				final String loginMsg = YeekuProtocol.PRESENCE + userField.getText() 
					+ YeekuProtocol.SPLITTER + iconList.getSelectedObjects()[0]
					+ YeekuProtocol.PRESENCE;
				comUtil.broadCast(loginMsg);
				// ������ʱ��ÿ20��㲥һ��������Ϣ
				javax.swing.Timer timer = new javax.swing.Timer(1000 * 10, 
					new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						comUtil.broadCast(loginMsg);
					}
				});
				timer.start();
				loginFrame.setVisible(false);
				chatFrame.setVisible(true);
			}
			catch (Exception ex)
			{
				loginFrame.setTipMsg("ȷ��30001�˿ڿ��У�������������");
			}
		}
	}
}