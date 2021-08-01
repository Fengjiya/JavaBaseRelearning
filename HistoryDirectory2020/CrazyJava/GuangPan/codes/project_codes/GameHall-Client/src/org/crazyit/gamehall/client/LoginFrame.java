package org.crazyit.gamehall.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.crazyit.gamehall.client.exception.ClientException;
import org.crazyit.gamehall.client.util.ImageUtil;
import org.crazyit.gamehall.commons.Game;
import org.crazyit.gamehall.commons.User;

/**
 * ��¼����
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class LoginFrame extends JFrame {

	//�û���
	private JLabel nameTextLabel = new JLabel("�û�����");
	private JTextField nameField = new JTextField(20);
	
	//�Ա�ѡ��
	private JLabel sexTextLabel = new JLabel("�Ա�");
	private JComboBox sexSelect = new JComboBox();
	
	//ͷ��
	private JLabel headTextLabel = new JLabel("ͷ��");
	private JComboBox headSelect;
	
	//��Ϸѡ��
	private JLabel gameTextLabel = new JLabel("ѡ����Ϸ��");
	private JComboBox gameSelect = new JComboBox();
	
	//���ӵ�ַ
	private JLabel connectionLabel = new JLabel("���ӵ�ַ��");
	private JTextField connectionField = new JTextField("127.0.0.1");
	
	//��ť
	private JButton confirmButton = new JButton("ȷ��");
	private JButton cancelButton = new JButton("ȡ��");
	
	//ͷ��ͼƬ
	private Map<String, ImageIcon> heads;
	
	private User user;
	
	public LoginFrame() {
		this.sexSelect.addItem("��");
		this.sexSelect.addItem("Ů");
		this.heads = ImageUtil.getHeads();
		//����ͷ��ѡ��������
		buildHeadSelect();
		//������Ϸѡ��������
		buildGameSelect();
		
		Box nameBox = Box.createHorizontalBox();
		nameBox.add(Box.createHorizontalStrut(30));
		nameBox.add(this.nameTextLabel);
		nameBox.add(Box.createHorizontalStrut(20));
		nameBox.add(this.nameField);
		nameBox.add(Box.createHorizontalStrut(30));
		
		Box sexBox = Box.createHorizontalBox();
		sexBox.add(Box.createHorizontalStrut(30));
		sexBox.add(this.sexTextLabel);
		sexBox.add(Box.createHorizontalStrut(33));
		sexBox.add(this.sexSelect);
		sexBox.add(Box.createHorizontalStrut(170));
		
		Box headBox = Box.createHorizontalBox();
		headBox.add(Box.createHorizontalStrut(30));
		headBox.add(this.headTextLabel);
		headBox.add(Box.createHorizontalStrut(33));
		headBox.add(this.headSelect);
		headBox.add(Box.createHorizontalStrut(170));
		
		
		Box gameBox = Box.createHorizontalBox();
		gameBox.add(Box.createHorizontalStrut(30));
		gameBox.add(this.gameTextLabel);
		gameBox.add(Box.createHorizontalStrut(7));
		gameBox.add(this.gameSelect);
		gameBox.add(Box.createHorizontalStrut(30));
		
		Box connectionBox = Box.createHorizontalBox();
		connectionBox.add(Box.createHorizontalStrut(30));
		connectionBox.add(this.connectionLabel);
		connectionBox.add(Box.createHorizontalStrut(7));
		connectionBox.add(this.connectionField);
		connectionBox.add(Box.createHorizontalStrut(30));
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(this.confirmButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(this.cancelButton);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(nameBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(sexBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(headBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(connectionBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(gameBox);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(buttonBox);
		mainBox.add(Box.createVerticalStrut(20));
		
		
		this.add(mainBox);
		this.setLocation(300, 200);
		this.setTitle("��Ϸ��¼");
		this.pack();
		this.setVisible(true);
		initListeners();
		this.user = new User();
	}
	
	//��ʼ����ť������
	private void initListeners() {
		this.confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		this.cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void login() {
		if (this.nameField.getText().equals("")) {
			JOptionPane.showConfirmDialog(null, "����������", "��ʾ", 
					JOptionPane.OK_CANCEL_OPTION);
			return;
		}
		//����User�ĸ�������
		setUser();
		this.user.setSocket(createSocket(this.connectionField.getText(), 12000));
		//�õ��û���ѡ�����Ϸ
		Game game = (Game)this.gameSelect.getSelectedItem();
		game.start(this.user);
		//�����߳�
		ClientThread thread = new ClientThread(this.user);
		thread.start();
		this.setVisible(false);
	}
	
	private Socket createSocket(String address, int port) {
		try {
			//����Socket
			return new Socket(address, port);
		} catch (Exception e) {
			throw new ClientException(e.getMessage());
		}
	}
	
	private void setUser() {
		//�����û�
		int sex = getSex();
		String name = this.nameField.getText();
		String id = UUID.randomUUID().toString();
		this.user.setId(id);
		this.user.setHeadImage((String)this.headSelect.getSelectedItem());
		this.user.setName(name);
		this.user.setSex(sex);
	}
	
	private int getSex() {
		String sex = (String)this.sexSelect.getSelectedItem();
		if (sex.equals("��")) return 0;
		else return 1;
	}
	
	private void buildGameSelect() {
		readDeployGame();
	}
	
	//��ȡgameĿ¼�µİ���MANIFEST.MF�ļ�, �ٶ�ȡ���ļ��е�Game-Class����(�еĻ��ͼ�������)
	private void readDeployGame() {
		try {
			File folder = new File("game");
			for (File file : folder.listFiles()) {
				if (isJar(file.getName())) {
					//�õ�jar�ļ�
					JarFile jar = new JarFile(file);
					//�õ�Ԫ�����ļ�
					Manifest mf = jar.getManifest();
					//��ø�������
					Attributes gameClassAttrs = mf.getMainAttributes();
					//����Game-Class����
					String gameClass = gameClassAttrs.getValue("Game-Class");
					if (gameClass != null) {
						Game game = (Game)Class.forName(gameClass).newInstance();
						this.gameSelect.addItem(game);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ж��ļ�����Ϊһ��jar��������
	 * @param fileName
	 * @return
	 */
	private boolean isJar(String fileName) {
		int pointIndex = fileName.lastIndexOf(".");
		if (pointIndex != -1) {
			String subfix = fileName.substring(pointIndex + 1, fileName.length());
			if ("jar".equals(subfix)) {
				return true;
			}
		}
		return false;
	}
	
	
	//����ͷ��ѡ������
	private void buildHeadSelect() {
		this.headSelect = new JComboBox(this.heads.keySet().toArray());
		this.headSelect.setMaximumRowCount(5);
		this.headSelect.setRenderer(new HeadComboBoxRenderer(this.heads));
	}

}
