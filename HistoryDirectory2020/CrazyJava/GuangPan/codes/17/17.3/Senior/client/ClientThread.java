package Senior.client;

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
public class ClientThread extends Thread
{
	// �ÿͻ����̸߳������������
	BufferedReader br = null;
	// ʹ��һ�������������������ͻ����߳�
	public ClientThread(BufferedReader br)
	{
		this.br = br;
	}
	public void run()
	{
		try
		{
			String line = null;
			// ���ϴ��������ж�ȡ���ݣ�������Щ���ݴ�ӡ���
			while((line = br.readLine())!= null)
			{
				System.out.println(line);
				/*
				��������ӡ�˴ӷ������˶��������ݡ�ʵ���ϣ��˴���������Ը����ӣ�
				�������ϣ���ͻ����ܿ��������ҵ��û��б�������÷�������
				ÿ�����û���¼���û��˳�ʱ���������û��б���Ϣ����ͻ��˷���һ�顣
				Ϊ�����ַ��������͵���������Ϣ�������û��б�������ҲӦ��
				��Ҫ���͵���Ϣǰ�������һ����Э���ַ������ͻ��˴˴������Э��
				�ַ����Ĳ�ͬ�����в�ͬ�Ĵ���
				�����ӵ������
				������˽�����Ϸ�����п��ܷ�����Ϸ��Ϣ���������˽�����������Ϸ��
				����Ҫ��������������Ϣ�ȣ�������ͬ������Щ����������Ϣǰ����
				���Э���ַ������ٷ��ͣ��ͻ��˾Ϳ��Ը��ݸ���Ϣ֪�����ֵ��������ꡣ
				*/
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		// ʹ��finally�����رո��̶߳�Ӧ��������
		finally
		{
			try
			{
				if (br != null)
				{
					br.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
