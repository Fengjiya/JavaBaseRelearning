package org.crazyit.mysql.ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.crazyit.mysql.object.GlobalContext;
import org.crazyit.mysql.object.tree.ServerConnection;

/**
 * �½����ӵĽ���
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
@SuppressWarnings("serial")
public class ConnectionFrame extends JFrame {

	private Box mainBox = Box.createVerticalBox();
	private Box connectionNameBox = Box.createHorizontalBox();
	private Box ipBox = Box.createHorizontalBox();
	private Box portBox = Box.createHorizontalBox();
	private Box usernameBox = Box.createHorizontalBox();
	private Box passwordBox = Box.createHorizontalBox();
	private Box buttonBox = Box.createHorizontalBox();
	//��������
	private JLabel connectionNameLabel = new JLabel("�������ƣ�");
	private JTextField connectionNameField = new JTextField(20);
	//ip
	private JLabel ipLabel = new JLabel("����IP��");
	private JTextField ipField = new JTextField(20);
	//�˿�
	private JLabel portLabel = new JLabel("�˿ڣ�"); 
	private JTextField portField = new JTextField("3306", 20);
	//�û���
	private JLabel usernameLabel = new JLabel("�û�����");
	private JTextField userNameField = new JTextField(20);
	//����
	private JLabel passwordLabel = new JLabel("���룺");
	private JPasswordField passwordField = new JPasswordField();
	//��ť
	private JButton confirmButton = new JButton("ȷ��");
	private JButton cancelButton = new JButton("ȡ��");
	private JButton testButton = new JButton("��������");
	
	//ȫ�������Ķ���
	private GlobalContext ctx;
	//���������
	private MainFrame mainFrame;
	
	public ConnectionFrame(GlobalContext ctx, MainFrame mainFrame) {
		this.ctx = ctx;
		this.mainFrame = mainFrame;
		this.connectionNameBox.add(Box.createHorizontalStrut(30));
		this.connectionNameBox.add(connectionNameLabel);
		this.connectionNameBox.add(Box.createHorizontalStrut(10));
		this.connectionNameBox.add(connectionNameField);
		this.connectionNameBox.add(Box.createHorizontalStrut(30));
		this.ipBox.add(Box.createHorizontalStrut(30));
		this.ipBox.add(ipLabel);
		this.ipBox.add(Box.createHorizontalStrut(25));
		this.ipBox.add(ipField);
		this.ipBox.add(Box.createHorizontalStrut(30));
		this.portBox.add(Box.createHorizontalStrut(30));
		this.portBox.add(portLabel);
		this.portBox.add(Box.createHorizontalStrut(36));
		this.portBox.add(portField);
		this.portBox.add(Box.createHorizontalStrut(30));
		this.usernameBox.add(Box.createHorizontalStrut(30));
		this.usernameBox.add(usernameLabel);
		this.usernameBox.add(Box.createHorizontalStrut(23));
		this.usernameBox.add(userNameField);
		this.usernameBox.add(Box.createHorizontalStrut(30));
		this.passwordBox.add(Box.createHorizontalStrut(30));
		this.passwordBox.add(passwordLabel);
		this.passwordBox.add(Box.createHorizontalStrut(36));
		this.passwordBox.add(passwordField);
		this.passwordBox.add(Box.createHorizontalStrut(30));
		this.buttonBox.add(testButton);
		this.buttonBox.add(Box.createHorizontalStrut(40));
		this.buttonBox.add(confirmButton);
		this.buttonBox.add(Box.createHorizontalStrut(36));
		this.buttonBox.add(cancelButton);
		
		
		this.mainBox.add(Box.createVerticalStrut(30));
		this.mainBox.add(connectionNameBox);
		this.mainBox.add(Box.createVerticalStrut(10));
		this.mainBox.add(ipBox);
		this.mainBox.add(Box.createVerticalStrut(10));
		this.mainBox.add(portBox);
		this.mainBox.add(Box.createVerticalStrut(10));
		this.mainBox.add(usernameBox);
		this.mainBox.add(Box.createVerticalStrut(10));
		this.mainBox.add(passwordBox);
		this.mainBox.add(Box.createVerticalStrut(20));
		this.mainBox.add(buttonBox);
		this.mainBox.add(Box.createVerticalStrut(30));
		
		this.add(mainBox);
		this.setLocation(350, 200);
		this.setTitle("�½�����");
		this.setResizable(false);
		this.pack();
		initListeners();
	}
	
	private void hideFrame() {
		this.setVisible(false);
	}
	
	private void initListeners() {
		this.confirmButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				saveConnection();
			}
		});
		this.cancelButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				hideFrame();
			}
		});
		this.testButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				checkConnection();
			}
		});
	}
	
	//��������
	private void checkConnection() {
		//�ӽ����еõ�������Ϣ
		ServerConnection conn = getDataConnectionFromView();
		if (!passValidate(conn)) {
			showMessage("��������������Ϣ", "����");
			return;
		}
		try {
			conn.connect();
			showMessage("�ɹ�����", "�ɹ�");
		} catch (Exception e) {
			showMessage(e.getMessage(), "����");
		}
	}
	
	//��������
	private void saveConnection() {
		//�õ��û��������Ϣ������һ��ServerConnection����
		ServerConnection conn = getDataConnectionFromView();
		if (!passValidate(conn)) {
			showMessage("��������������Ϣ", "����");
			return;
		}
		//�ж����������Ƿ��ظ�
		if (this.ctx.getConnection(conn.getConnectionName()) != null) {
			showMessage("�Ѿ�������ͬ���ֵ�����", "����");
			return;
		}
		//ֱ�ӱ���, ����Ҫ�����κε�����
		this.ctx.addConnection(conn);
		//���浽�����ļ�
		this.ctx.getPropertiesHandler().saveServerConnection(conn);
		this.mainFrame.addConnection(conn);
		this.setVisible(false);
	}
	
	//��֤������Ϣ�Ƿ�����д
	private boolean passValidate(ServerConnection conn) {
		if (conn.getConnectionName().trim().equals("")) return false;
		if (conn.getHost().trim().equals("")) return false;
		if (conn.getPort().trim().equals("")) return false;
		if (conn.getUsername().trim().equals("")) return false;
		if (conn.getPassword().trim().equals("")) return false;
		return true;
	}

	//�ӽ���ȡ����ص���Ϣ
	private ServerConnection getDataConnectionFromView() {
		String connectionName = this.connectionNameField.getText();
		String host = this.ipField.getText();
		String port = this.portField.getText();
		String username = this.userNameField.getText();
		String password = getPassword();
		return new ServerConnection(connectionName, username, password, 
				host, port);
	}
	
	private int showMessage(String s, String title) {
		return JOptionPane.showConfirmDialog(this, s, title,
				JOptionPane.OK_CANCEL_OPTION);
	}
	
	//���������ַ���
	private String getPassword() {
		char[] passes = this.passwordField.getPassword();
		StringBuffer password = new StringBuffer();
		for (char c : passes) {
			password.append(c);
		}
		return password.toString();
	}
}
