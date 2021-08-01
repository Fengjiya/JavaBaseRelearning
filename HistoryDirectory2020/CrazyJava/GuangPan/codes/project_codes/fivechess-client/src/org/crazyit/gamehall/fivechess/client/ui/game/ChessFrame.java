package org.crazyit.gamehall.fivechess.client.ui.game;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.crazyit.gamehall.commons.Request;
import org.crazyit.gamehall.fivechess.client.ui.ChatPanel;
import org.crazyit.gamehall.fivechess.client.ui.UIContext;
import org.crazyit.gamehall.fivechess.client.ui.UserTable;
import org.crazyit.gamehall.fivechess.commons.ChessUser;
import org.crazyit.gamehall.fivechess.commons.Table;
import org.crazyit.gamehall.util.XStreamUtil;

/**
 * ��������ϷJFrame����
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class ChessFrame extends JFrame {
		
	//����б�
	private UserTable userTable;
	
	//����
	private ChatPanel chatPanel;
	
	//��Ϸ����
	private GamePanel gamePanel;
	
	private Table table;
	
	private ChessUser user;
	
	private List<ChessUser> users;
	
	//���������������
	private final static String CHAT_SERVER_ACTION = "org.crazyit.gamehall.fivechess.server.action.GameMessageAction";
	
	//�������ݽ�����
	private final static String CHAT_CLIENT_ACTION = "org.crazyit.gamehall.fivechess.client.action.game.ReceiveMessageAction";
	
	//tableΪ������Ϣ
	public ChessFrame(Table table, ChessUser user) {
		this.table = table;
		this.user = user;
		//��Ϸ�������������ʹ�õļ���
		this.users = getUsers(table, user);
		//��������б�
		this.userTable = new UserTable(this.users, this.user);
		//��������JPanel
		this.chatPanel = new ChatPanel(this.users, this.user, CHAT_SERVER_ACTION, 
				CHAT_CLIENT_ACTION);
		//������ϷJPanel
		this.gamePanel = new GamePanel(this.table, this.user);
		//�����������
		JScrollPane chatScrollPane = new JScrollPane(this.chatPanel);
		chatScrollPane.setMinimumSize(new Dimension(300, 490));
		//��������б����
		JScrollPane userScrollPane = new JScrollPane(this.userTable);
		userScrollPane.setMinimumSize(new Dimension(300, 300));
		JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
				userScrollPane, chatScrollPane);
		rightPane.setMinimumSize(new Dimension(300, 400));
		//�������ָ����
		JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				this.gamePanel, rightPane);
		this.add(mainPane);
		mainPane.setDividerLocation(1024 - 315);
		mainPane.setDividerSize(3);
		rightPane.setDividerLocation(768 - 550);
		rightPane.setDividerSize(3);
		//���ò��ɸı��С
		this.setResizable(false);
		int perfectWidth = 1024;
		int perfectHeight = 768 - 30;
		this.setPreferredSize(new Dimension(perfectWidth, perfectHeight));
		this.pack();
		initUIContext();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (gamePanel.isGaming()) {
					//������Ϸ���˳�
					int result = UIContext.showConfirm("���Ƿ�Ҫ�˳���Ϸ��?");
					if (result == 1) {
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					} else {
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						//�������������������
						gamePanel.sendLostRequest();
						leave();
					}
				} else {
					leave();
				}
			}
		});
	}
	
	//����Ҽ��������һ�������, ��ʾ������ҽ���
	public void newUserIn(ChessUser user) {
		this.users.add(user);
		refreshUI();
	}
	
	//����˳���Ϸ
	public void userExit(ChessUser user) {
		//�Ӽ�����ȥ����ǰ���
		for (Iterator it = this.users.iterator(); it.hasNext();) {
			ChessUser u = (ChessUser)it.next();
			if (u.getId().equals(user.getId())) {
				it.remove();
			}
		}
		refreshUI();
	}
	
	//ˢ�½������
	public void refreshUI() {
		this.gamePanel.repaint();
		this.chatPanel.refreshJComboBox();
		this.userTable.refresh();
	}
	

	//����뿪��Ϸ, ���������������
	public void leave() {
		int tableNumber = this.table.getTableNumber();
		String userId = this.user.getId();
		Request request = new Request("org.crazyit.gamehall.fivechess.server.action.LeaveGameAction", 
				"org.crazyit.gamehall.fivechess.client.action.game.LeaveGameAction");
		request.setParameter("userId", userId);
		request.setParameter("tableNumber", tableNumber);
		//���ö��ֽ��յ��˳���Ĵ�����
		request.setParameter("exitAction", 
				"org.crazyit.gamehall.fivechess.client.action.game.OpponentExitAction");
		destroyUI();
		//�������׼��״̬
		this.user.setReady(false);
		this.user.getPrintStream().println(XStreamUtil.toXML(request));
	}
	
	//�����Ӷ����еõ������Ϣ(��������ǰ���)
	private List<ChessUser> getUsers(Table table, ChessUser user) {
		List<ChessUser> users = new ArrayList<ChessUser>();
		ChessUser u1 = table.getLeftSeat().getUser();
		ChessUser u2 = table.getRightSeat().getUser();
		if (u1 != null) users.add(u1);
		if (u2 != null) users.add(u2);
		//�Ӽ�����ȥ����ǰ���
		for (Iterator it = users.iterator(); it.hasNext();) {
			ChessUser u = (ChessUser)it.next();
			if (u.getId().equals(user.getId())) {
				it.remove();
			}
		}
		return users;
	}
	
	//���������(ֻ����Ϸ�������)���뵽���������������
	private void initUIContext() {
		UIContext.modules.put(UIContext.GAME_CHAT_PANEL, this.chatPanel);
		UIContext.modules.put(UIContext.GAME_USER_TABLE, this.userTable);
		UIContext.modules.put(UIContext.GAME_PANEL, this.gamePanel);
		UIContext.modules.put(UIContext.GAME_FRAME, this);
	}
	
	//��UIContext��������Ϸ�������ض���
	private void destroyUI() {
		UIContext.modules.remove(UIContext.GAME_CHAT_PANEL);
		UIContext.modules.remove(UIContext.GAME_USER_TABLE);
		UIContext.modules.remove(UIContext.GAME_PANEL);
		UIContext.modules.remove(UIContext.GAME_FRAME);
	}
	
}
