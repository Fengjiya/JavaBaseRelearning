package MultiThread.client;

import Senior.client.ClientThread;

import java.io.*;
import java.net.*;
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
public class MyClient
{
	public static void main(String[] args)throws Exception 
	{
		Socket s = new Socket("127.0.0.1" , 30000);
		// �ͻ�������ClientThread�̲߳��϶�ȡ���Է�����������
		new Thread(new ClientThread(s)).start();   // ��
		// ��ȡ��Socket��Ӧ�������
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		// ���϶�ȡ��������
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		while ((line = br.readLine()) != null)
		{
			// ���û��ļ�����������д��Socket��Ӧ�������
			ps.println(line);
		}
	}
}
