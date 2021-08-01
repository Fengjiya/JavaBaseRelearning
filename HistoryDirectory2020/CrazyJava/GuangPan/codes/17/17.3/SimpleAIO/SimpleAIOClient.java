package SimpleAIO;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
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
public class SimpleAIOClient
{
	static final int PORT = 30000;
	public static void main(String[] args)
		throws Exception
	{
		// ���ڶ�ȡ���ݵ�ByteBuffer��
		ByteBuffer buff = ByteBuffer.allocate(1024);
		Charset utf = Charset.forName("utf-8");
		try(
			// �ٴ���AsynchronousSocketChannel����
			AsynchronousSocketChannel clientChannel 
				= AsynchronousSocketChannel.open())
		{
			// ������Զ�̷�����
			clientChannel.connect(new InetSocketAddress("127.0.0.1" 
				, PORT)).get();     //��
			buff.clear();
			// �۴�clientChannel�ж�ȡ����
			clientChannel.read(buff).get();     //��
			buff.flip();
			// ��buff������ת��Ϊ�ַ���
			String content = utf.decode(buff).toString();
			System.out.println("��������Ϣ��" + content);
		}
	}
}
