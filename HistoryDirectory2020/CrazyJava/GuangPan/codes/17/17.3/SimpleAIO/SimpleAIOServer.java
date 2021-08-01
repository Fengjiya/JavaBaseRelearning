package SimpleAIO;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.concurrent.*;
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
public class SimpleAIOServer
{
	static final int PORT = 30000;
	public static void main(String[] args)
		throws Exception
	{
		try(
			// �ٴ���AsynchronousServerSocketChannel����
			AsynchronousServerSocketChannel serverChannel = 
				AsynchronousServerSocketChannel.open())
		{
			// ��ָ����ָ����ַ���˿ڼ�����
			serverChannel.bind(new InetSocketAddress(PORT));
			while (true)
			{
				// �۲���ѭ���������Կͻ��˵�����
				Future<AsynchronousSocketChannel> future
					= serverChannel.accept();
				// ��ȡ������ɺ󷵻ص�AsynchronousSocketChannel
				AsynchronousSocketChannel socketChannel = future.get();
				// ִ�������
				socketChannel.write(ByteBuffer.wrap("��ӭ������AIO�����磡"
					.getBytes("UTF-8"))).get();
			}
		}
	}
}
