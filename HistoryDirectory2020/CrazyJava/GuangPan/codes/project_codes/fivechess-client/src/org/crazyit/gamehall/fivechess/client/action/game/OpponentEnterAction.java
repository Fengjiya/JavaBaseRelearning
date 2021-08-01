package org.crazyit.gamehall.fivechess.client.action.game;

import org.crazyit.gamehall.commons.ClientAction;
import org.crazyit.gamehall.commons.Response;
import org.crazyit.gamehall.fivechess.client.ui.HallPanel;
import org.crazyit.gamehall.fivechess.client.ui.UIContext;
import org.crazyit.gamehall.fivechess.client.ui.game.ChessFrame;
import org.crazyit.gamehall.fivechess.commons.ChessUser;

/**
 * ���ֽ�����Ϸ, �ɱ�����ն��ֽ�����Ϸ����Ϣ(����������), ����˵�Ķ�����ָ�������Ϸ�����
 * ��Action�ɵ�һ��������Ϸ����ҽ���
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class OpponentEnterAction implements ClientAction {

	public void execute(Response response) {
		//�õ���������
		HallPanel gameHall = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		
		//�õ����ֵ�ChessUser����
		String opponentId = (String)response.getData("opponentId");
		//�Ӵ����еõ����ֵ���Ϣ
		ChessUser opponent = gameHall.getUser(opponentId);
		ChessFrame cf = (ChessFrame)UIContext.modules.get(UIContext.GAME_FRAME);
		cf.newUserIn(opponent);

	}

}
