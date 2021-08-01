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
public class ServerThread extends Thread
{
	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;
	// ����һ�������������ڽ���һ��Socket������ServerThread�߳�
	public ServerThread(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		try
		{
			// ��ȡ��Socket��Ӧ��������
			br = new BufferedReader(new InputStreamReader(socket
				.getInputStream()));
			// ��ȡ��Socket��Ӧ�������
			ps = new PrintStream(socket.getOutputStream());
			String line = null;
			while((line = br.readLine())!= null)
			{
				// �������������CrazyitProtocol.USER_ROUND��ʼ�������������
				// ����ȷ�����������û���¼���û���
				if (line.startsWith(Senior.server.CrazyitProtocol.USER_ROUND)
					&& line.endsWith(Senior.server.CrazyitProtocol.USER_ROUND))
				{
					// �õ���ʵ��Ϣ
					String userName = getRealMsg(line);
					// ����û����ظ�
					if (Server.clients.containsKey(userName))
					{
						System.out.println("�ظ�");
						ps.println(Senior.server.CrazyitProtocol.NAME_REP);
					}
					else
					{
						System.out.println("�ɹ�");
						ps.println(Senior.server.CrazyitProtocol.LOGIN_SUCCESS);
						Server.clients.put(userName , ps);
					}
				}
				// �������������CrazyitProtocol.PRIVATE_ROUND��ʼ�������������
				// ����ȷ����˽����Ϣ��˽����Ϣֻ���ض������������
				else if (line.startsWith(Senior.server.CrazyitProtocol.PRIVATE_ROUND)
					&& line.endsWith(Senior.server.CrazyitProtocol.PRIVATE_ROUND))
				{
					// �õ���ʵ��Ϣ
					String userAndMsg = getRealMsg(line);
					// ��SPLIT_SIGN�ָ��ַ�����ǰ����˽���û��������������Ϣ
					String user = userAndMsg.split(Senior.server.CrazyitProtocol.SPLIT_SIGN)[0];
					String msg = userAndMsg.split(Senior.server.CrazyitProtocol.SPLIT_SIGN)[1];
					// ��ȡ˽���û���Ӧ���������������˽����Ϣ
					Server.clients.get(user).println(Server.clients
						.getKeyByValue(ps) + "���ĵض���˵��" + msg);
				}
				// ����Ҫ��ÿ��Socket����
				else
				{
					// �õ���ʵ��Ϣ
					String msg = getRealMsg(line);
					// ����clients�е�ÿ�������
					for (PrintStream clientPs : Server.clients.valueSet())
					{
						clientPs.println(Server.clients.getKeyByValue(ps)
							+ "˵��" + msg);
					}
				}
			}
		}
		// ��׽���쳣�󣬱�����Socket��Ӧ�Ŀͻ����Ѿ�����������
		// ���Գ������Ӧ���������Map��ɾ��
		catch (IOException e)
		{
			Server.clients.removeByValue(ps);
			System.out.println(Server.clients.size());
			// �ر����硢IO��Դ
			try
			{
				if (br != null)
				{
					br.close();
				}
				if (ps != null)
				{
					ps.close();
				}
				if (socket != null)
				{
					socket.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	// ������������ȥ��ǰ���Э���ַ����ָ�����ʵ����
	private String getRealMsg(String line)
	{
		return line.substring(Senior.server.CrazyitProtocol.PROTOCOL_LEN
			, line.length() - CrazyitProtocol.PROTOCOL_LEN);
	}
}
