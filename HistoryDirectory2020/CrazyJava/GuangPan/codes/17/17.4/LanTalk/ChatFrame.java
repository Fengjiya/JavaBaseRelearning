package LanTalk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.InetSocketAddress;
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
// ���彻̸�ĶԻ���
public class ChatFrame extends JDialog
{
	// ������Ϣ��
	JTextArea msgArea = new JTextArea(12 , 45);
	// ����������
	JTextField chatField = new JTextField(30);
	// ����������Ϣ�İ�ť
	JButton sendBn = new JButton("����");
	// �ý�̸���ڶ�Ӧ���û�
	UserInfo user;
	// �����������ڳ�ʼ����̸�Ի���Ľ���
	public ChatFrame(LanTalk parent , final UserInfo user)
	{
		super(parent , "��" + user.getName() + "������" , false);
		this.user = user;
		msgArea.setEditable(false);
		add(new JScrollPane(msgArea));
		JPanel buttom = new JPanel();
		buttom.add(new JLabel("������Ϣ��"));
		buttom.add(chatField);
		buttom.add(sendBn);
		add(buttom , BorderLayout.SOUTH);
		//������Ϣ��Action,Action��ActionListener���ӽӿ�
		Action sendAction = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				InetSocketAddress dest = (InetSocketAddress)user.getAddress();
				/*�������б��У����������SocketAddress��null*/
				// ��������������˷�����Ϣ
				if (dest == null)
				{
					LoginFrame.comUtil.broadCast(chatField.getText());
					msgArea.setText("���Դ��˵��"
						+ chatField.getText() + "\n" + msgArea.getText());
				}
				// ��˽�˷�����Ϣ
				else
				{
					// ��ȡ������Ϣ��Ŀ��
					dest = new InetSocketAddress(dest.getHostName(),
						dest.getPort() + 1);
					LoginFrame.comUtil.sendSingle(chatField.getText(), dest);
					msgArea.setText("����" + user.getName() +  "˵��"
						+ chatField.getText() + "\n" + msgArea.getText());

				}
				chatField.setText("");
			}
		};
		sendBn.addActionListener(sendAction);
		//��Ctrl+Enter����"send"����
		chatField.getInputMap().put(KeyStroke.getKeyStroke('\n'
			, java.awt.event.InputEvent.CTRL_MASK) , "send");
		//��"send"sendAction����
		chatField.getActionMap().put("send", sendAction);
		pack();
	}
	// �������������������Ϣ�ķ���
	public void addString(String msg)
	{
		msgArea.setText(msg + "\n" + msgArea.getText());
	}
}
