package Senior.server;

import java.net.*;
import java.io.*;
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
public class Server
{
	private static final int SERVER_PORT = 30000;
	// ʹ��CrazyitMap����������ÿ���ͻ����ֺͶ�Ӧ�����֮��Ķ�Ӧ��ϵ��
	public static CrazyitMap<String , PrintStream> clients
		= new CrazyitMap<>();
	public void init()
	{
		try(
			// ����������ServerSocket
			ServerSocket ss = new ServerSocket(SERVER_PORT))
		{
			// ������ѭ�������Ͻ������Կͻ��˵�����
			while(true)
			{
				Socket socket = ss.accept();
				new ServerThread(socket).start();
			}
		}
		// ����׳��쳣
		catch (IOException ex)
		{
			System.out.println("����������ʧ�ܣ��Ƿ�˿�"
				+ SERVER_PORT + "�ѱ�ռ�ã�");
		}
	}
	public static void main(String[] args)
	{
		Server server = new Server();
		server.init();
	}
}

