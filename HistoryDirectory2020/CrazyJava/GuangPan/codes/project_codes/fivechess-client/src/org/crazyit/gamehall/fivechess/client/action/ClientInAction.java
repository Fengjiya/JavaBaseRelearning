package org.crazyit.gamehall.fivechess.client.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.crazyit.gamehall.commons.ClientAction;
import org.crazyit.gamehall.commons.Response;
import org.crazyit.gamehall.commons.User;
import org.crazyit.gamehall.fivechess.client.ChessClientContext;
import org.crazyit.gamehall.fivechess.client.object.GameHallInfo;
import org.crazyit.gamehall.fivechess.client.ui.GameHallFrame;
import org.crazyit.gamehall.fivechess.commons.ChessUser;
import org.crazyit.gamehall.fivechess.commons.Table;

/**
 * �������ÿͻ���������Ϸ����
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class ClientInAction implements ClientAction {

	
	public void execute(Response response) {
		//�ӷ������еõ�������Ϣ����װ��һ��GameHallInfo����
		GameHallInfo hallInfo = getGameHallInfo(response);
		//�õ�ȫ����ҵ���Ϣ
		List<ChessUser> users = getUsers(response);
		//�õ�������Ϸ�������Ϣ
		ChessUser cu = ChessClientContext.chessUser;
		//��������GameHallFrame
		GameHallFrame mainFrame = new GameHallFrame(hallInfo, cu, users);
		mainFrame.sendUserIn();
	}
	
	//��Response�еõ�������ҵ���Ϣ, ��ת����List(�������б�������ݽṹ��Map)
	private List<ChessUser> getUsers(Response response) {
		Map<String, User> users = (Map<String, User>)response.getData("users");
		List<ChessUser> result = new ArrayList<ChessUser>();
		for (String id : users.keySet()) {
			ChessUser cu = (ChessUser)users.get(id);
			result.add(cu);
		}
		return result;
	}
	
	private GameHallInfo getGameHallInfo(Response response) {
		//�õ�������������
		int tableColumnSize = (Integer)response.getData("tableColumnSize");
		//�õ�������������
		int tableRowSize = (Integer)response.getData("tableRowSize");
		//�õ�������Ϣ
		Table[][] tables = (Table[][])response.getData("tables");
		GameHallInfo info = new GameHallInfo(tables, tableColumnSize, tableRowSize);
		return info;
	}

}
