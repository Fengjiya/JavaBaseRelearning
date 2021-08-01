package MultiThread.server;

import Senior.server.ServerThread;

import java.net.*;
import java.io.*;
import java.util.*;
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
public class MyServer
{
	//���屣������Socket��ArrayList
	public static ArrayList<Socket> socketList
		= new ArrayList<>();
	public static void main(String[] args) 
		throws IOException
	{
		ServerSocket ss = new ServerSocket(30000);
		while(true)
		{
			// ���д������������һֱ�ȴ����˵�����
			Socket s = ss.accept();
			socketList.add(s);
			// ÿ���ͻ������Ӻ�����һ��ServerThread�߳�Ϊ�ÿͻ��˷���
			new Thread(new ServerThread(s)).start();
		}
	}
}
