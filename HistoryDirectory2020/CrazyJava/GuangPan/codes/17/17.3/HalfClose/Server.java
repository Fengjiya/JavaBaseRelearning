package HalfClose;

import java.io.*;
import java.net.*;
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
public class Server
{
	public static void main(String[] args) 
		throws Exception
	{
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("�������ĵ�һ������");
		ps.println("�������ĵڶ�������");
		//�ر�socket���������������������Ѿ�����
		socket.shutdownOutput();
		//������佫���false������socket��δ�رա�
		System.out.println(socket.isClosed());
		Scanner scan = new Scanner(socket.getInputStream());
		while (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		scan.close();
		socket.close();
		ss.close();
	}
}

