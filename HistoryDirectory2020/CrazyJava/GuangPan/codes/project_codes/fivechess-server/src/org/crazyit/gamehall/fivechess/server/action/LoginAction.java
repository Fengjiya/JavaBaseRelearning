package org.crazyit.gamehall.fivechess.server.action;

import java.net.Socket;

import org.crazyit.gamehall.commons.Request;
import org.crazyit.gamehall.commons.Response;
import org.crazyit.gamehall.commons.ServerAction;
import org.crazyit.gamehall.fivechess.commons.ChessUser;
import org.crazyit.gamehall.fivechess.server.ChessContext;
import org.crazyit.gamehall.util.XStreamUtil;

/**
 * ��ҽ�����Ϸ���������������ã�
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class LoginAction implements ServerAction {

	
	public void execute(Request request, Response response, Socket socket) {
		//����������еõ��µ�¼����Ҷ���
		ChessUser cu = (ChessUser)request.getParameter("user");
		cu.setSocket(socket);
		//���뵽���������
		ChessContext.users.put(cu.getId(), cu);
		//��������õ���Ӧ��
		response.setData("user", cu);
		//�����������Ϣ���õ���Ӧ��
		response.setData("users", ChessContext.users);
		//�����е�������Ϣ���ص��ͻ���
		response.setData("tables", ChessContext.tables);
		//�����������ӵ��������������ص��ͻ���
		response.setData("tableColumnSize", ChessContext.TABLE_COLUMN_SIZE);
		response.setData("tableRowSize", ChessContext.TABLE_ROW_SIZE);
		//���ظ���¼���, ��¼�ɹ�
		cu.getPrintStream().println(XStreamUtil.toXML(response));
	}
	
}
