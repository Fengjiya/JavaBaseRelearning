package org.crazyit.gamehall.fivechess.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.crazyit.gamehall.commons.Request;
import org.crazyit.gamehall.fivechess.commons.ChessUser;
import org.crazyit.gamehall.util.XStreamUtil;

/**
 * �����JPanel, ������
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class ChatPanel extends JPanel {

	//�������ݵ��ı���
	private JTextArea contentArea;
	
	//�������ݵ��ı���
	private JTextField conentField;
	
	//�������
	private JComboBox target;
	
	//���Ͱ�ť
	private JButton sendButton;
	
	private JScrollPane scrollPane;
	
	private List<ChessUser> users;
	
	private ChessUser user;
	
	//����ķ�����������
	private String serverAction;
	
	//����Ŀͻ��˴�����
	private String clientAction;
	
	public ChatPanel(List<ChessUser> users, ChessUser user, String serverAction, 
			String clientAction) {
		this.users = users;
		this.user = user;
		this.serverAction = serverAction;
		this.clientAction = clientAction;
		this.contentArea = new JTextArea(22, 25);
		//���ò��ɱ༭
		this.contentArea.setEditable(false);
		//���û���
		this.contentArea.setLineWrap(true);
		this.conentField = new JTextField();
		this.target = new JComboBox();
		//��������Ԫ��
		addTargets();
		this.sendButton = new JButton("����");
		this.scrollPane = new JScrollPane(this.contentArea);
		
		Box sendBox = Box.createHorizontalBox();
		sendBox.add(this.conentField);
		sendBox.add(this.sendButton);
		Box targetBox = Box.createHorizontalBox();
		targetBox.add(new JLabel("ѡ���������"));
		targetBox.add(this.target);
		Box mainBox = Box.createVerticalBox();
		mainBox.add(this.scrollPane);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(targetBox);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(sendBox);
		this.add(mainBox);
		this.sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
	}
		
	//�����������������ѡ��
	private void addTargets() {
		ChessUser all = new ChessUser();
		all.setName("������");
		this.target.addItem(all);
		for (ChessUser cu : this.users) {
			if (!cu.getId().equals(this.user.getId())) {
				this.target.addItem(cu);
			}
		}
	}
	
	//ˢ������
	public void refreshJComboBox() {
		this.target.removeAllItems();
		addTargets();
	}
	
	public void appendContent(String content) {
		if (this.contentArea.getText().equals("")) this.contentArea.append(content);
		else this.contentArea.append("\n" + content);
	}
	
	//������Ϣ
	public void send() {
		//�õ����͵�����
		String content = this.conentField.getText();
		//�õ��������
		ChessUser receiver = (ChessUser)this.target.getSelectedItem();
		//��������
		Request request = new Request(this.serverAction, this.clientAction);
		//���ò���
		request.setParameter("receiverId", receiver.getId());
		request.setParameter("senderId", this.user.getId());
		request.setParameter("content", content);
		//��������
		this.user.getPrintStream().println(XStreamUtil.toXML(request));
		appendContent("��� " + receiver.getName() + " ˵: " + content);
	}
	
}
