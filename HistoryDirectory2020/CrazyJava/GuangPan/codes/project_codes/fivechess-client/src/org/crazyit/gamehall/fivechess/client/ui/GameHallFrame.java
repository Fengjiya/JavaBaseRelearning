package org.crazyit.gamehall.fivechess.client.ui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.crazyit.gamehall.commons.Request;
import org.crazyit.gamehall.fivechess.client.object.GameHallInfo;
import org.crazyit.gamehall.fivechess.commons.ChessUser;
import org.crazyit.gamehall.fivechess.commons.Table;
import org.crazyit.gamehall.util.XStreamUtil;

/**
 * ��Ϸ������JFrame
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class GameHallFrame extends JFrame {

	private HallPanel hallPanel;
	
	private ChatPanel chatPanel;
	
	private UserTable userTable;
	
	//��ǰ��������
	private ChessUser user;
	
	//��������ķ�����������
	private final static String CHAT_SERVER_ACTION = "org.crazyit.gamehall.fivechess.server.action.SendMessageAction";
	
	//��������Ŀͻ��˴�����
	private final static String CHAT_CLIENT_ACTION = "org.crazyit.gamehall.fivechess.client.action.ReceiveMessageAction";
	
	/**
	 * ����һ����Ϸ�������������
	 * @param gameHallInfo ��Ϸ��������Ϣ, ��������
	 * @param user
	 * @param users
	 */
	public GameHallFrame(GameHallInfo gameHallInfo, ChessUser user, 
			List<ChessUser> users) {
		this.user = user;
		//���û�������ȥ����ǰ�û�, ���Լ��Ӽ�����ɾ��
		sortUsers(users);
		//������Ϸ������JPanel
		this.hallPanel = new HallPanel(gameHallInfo, this.user, users);
		//ע������ChatPanel�ĺ���������
		this.chatPanel = new ChatPanel(users, user, CHAT_SERVER_ACTION, 
				CHAT_CLIENT_ACTION);
		//�����û���Ϣ�б��JPanel
		this.userTable = new UserTable(users, this.user);
		JScrollPane hallScrollPane = new JScrollPane(this.hallPanel);
		hallScrollPane.setMinimumSize(new Dimension(750, 1024 - 305));
		JScrollPane chatScrollPane = new JScrollPane(this.chatPanel);
		chatScrollPane.setMinimumSize(new Dimension(300, 490));
		JScrollPane userScrollPane = new JScrollPane(this.userTable);
		userScrollPane.setMinimumSize(new Dimension(300, 300));
		//�����ұߵ����·ָ�
		JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
				userScrollPane, chatScrollPane);
		rightPane.setMinimumSize(new Dimension(300, 400));
		rightPane.setDividerLocation(768 - 550);
		rightPane.setDividerSize(3);
		//����������������ҷָ�
		JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, hallScrollPane, 
				rightPane);
		mainPane.setDividerSize(3);
		mainPane.setDividerLocation(1024 - 305);
		this.add(mainPane);
		//���ò��ɸı��С
		this.setResizable(false);
		int perfectWidth = 1024;
		int perfectHeight = 768 - 30;
		this.setPreferredSize(new Dimension(perfectWidth, perfectHeight));
		this.pack();
		this.setTitle("��������Ϸ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
		initUIContext();
	}
	
	//���Լ��ᵽ�û��б����ǰ��
	private void sortUsers(List<ChessUser> users) {
		if (this.user == null) return;
		Iterator it = users.iterator(); 
		while (it.hasNext()) {
			ChessUser u = (ChessUser)it.next();
			if (u.getId().equals(this.user.getId())) it.remove();
		}
	}
	
	//��ʼ��UIContext��
	private void initUIContext() {
		UIContext.modules.put(UIContext.HALL_PANEL, this.hallPanel);
		UIContext.modules.put(UIContext.HALL_CHAT_PANEL, this.chatPanel);
		UIContext.modules.put(UIContext.HALL_USER_TABLE, this.userTable);
		UIContext.modules.put(UIContext.HALL_FRAME, this);
	}
	
	//������������û��������������
	public void sendUserIn() {
		//����һ������, ���߷������û��������, ��������Ӧ��������ReceiveInAction
		Request req = new Request("org.crazyit.gamehall.fivechess.server.action.NewUserInAction", 
				"org.crazyit.gamehall.fivechess.client.action.ReceiveInAction");
		req.setParameter("userId", this.user.getId());
		//�õ��û���Socket����������, ���߷������û������˴���
		this.user.getPrintStream().println(XStreamUtil.toXML(req));
	}
	
	public static void main(String[] args) {
		int TABLE_COLUMN_SIZE = 5;
		int TABLE_ROW_SIZE = 10;
		//��ʼ��������Ϣ
		Table[][] tables = new Table[TABLE_COLUMN_SIZE][TABLE_ROW_SIZE];
		int tableNumber = 0;
		for (int i = 0; i < tables.length; i++) {
			for (int j = 0; j < tables[i].length; j++) {
				Table table = new Table(Table.DEFAULT_IMAGE_WIDTH*i, 
						Table.DEFAULT_IMAGE_HEIGHT*j, tableNumber);
				tables[i][j] = table;
				tableNumber++;
			}
		}
		List<ChessUser> users = new ArrayList<ChessUser>();
		ChessUser u1 = new ChessUser();
		u1.setId("abc");
		u1.setName("���1");
		u1.setSex(0);
		u1.setHeadImage("images/fivechess/heads/1.gif");
		
		ChessUser u2 = new ChessUser();
		u2.setId("abc");
		u2.setName("���2");
		u2.setSex(0);
		u2.setHeadImage("images/fivechess/heads/2.gif");
		
		users.add(u1);
		users.add(u2);
		
		ChessUser user = new ChessUser();
		user.setId("abc");
		user.setName("boxiong");
		user.setHeadImage("images/fivechess/heads/1.gif");
		GameHallFrame g = new GameHallFrame(new GameHallInfo(tables, 
				TABLE_COLUMN_SIZE, TABLE_ROW_SIZE), user, users);
	}

}
