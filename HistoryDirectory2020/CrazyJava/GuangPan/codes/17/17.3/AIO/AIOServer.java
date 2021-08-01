package AIO;

import java.net.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
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
public class AIOServer
{
	static final int PORT = 30000;
	final static String UTF_8 = "utf-8";
	static List<AsynchronousSocketChannel> channelList
		= new ArrayList<>();
	public void startListen() throws InterruptedException,
		Exception 
	{
		// ����һ���̳߳�
		ExecutorService executor = Executors.newFixedThreadPool(20);
		// ��ָ���̳߳�������һ��AsynchronousChannelGroup
		AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup
			.withThreadPool(executor);
		// ��ָ���̳߳�������һ��AsynchronousServerSocketChannel
		AsynchronousServerSocketChannel serverChannel 
			= AsynchronousServerSocketChannel.open(channelGroup)
			// ָ������������PORT�˿�
			.bind(new InetSocketAddress(PORT));
		// ʹ��CompletionHandler�������Կͻ��˵���������
		serverChannel.accept(null, new AcceptHandler(serverChannel));  //��
	}   
	public static void main(String[] args)
		throws Exception
	{
		AIOServer server = new AIOServer();
		server.startListen();
	}
}
// ʵ���Լ���CompletionHandler��
class AcceptHandler implements
	CompletionHandler<AsynchronousSocketChannel, Object>
{
	private AsynchronousServerSocketChannel serverChannel; 
	public AcceptHandler(AsynchronousServerSocketChannel sc)
	{
		this.serverChannel = sc;
	}
	// ����һ��ByteBuffer׼����ȡ����
	ByteBuffer buff = ByteBuffer.allocate(1024); 
	// ��ʵ��IO�������ʱ�򴥷��÷���
	@Override
	public void completed(final AsynchronousSocketChannel sc
		, Object attachment)
	{
		// ��¼�����ӵĽ�����Channel
		AIOServer.channelList.add(sc);
		// ׼�����ܿͻ��˵���һ������
		serverChannel.accept(null , this);
		sc.read(buff , null 
			, new CompletionHandler<Integer,Object>()  //��
		{
			@Override
			public void completed(Integer result
				, Object attachment)
			{
				buff.flip();
				// ��buff������ת��Ϊ�ַ���
				String content = StandardCharsets.UTF_8
					.decode(buff).toString();
				// ����ÿ��Channel�����յ�����Ϣд���Channel��
				for(AsynchronousSocketChannel c : AIOServer.channelList)
				{
					try
					{
						c.write(ByteBuffer.wrap(content.getBytes(
							AIOServer.UTF_8))).get();
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				buff.clear();
				// ��ȡ��һ������
				sc.read(buff , null , this);
			}
			@Override
			public void failed(Throwable ex, Object attachment)
			{
				System.out.println("��ȡ����ʧ��: " + ex);
				// �Ӹ�Channel��ȡ����ʧ�ܣ��ͽ���Channelɾ��
				AIOServer.channelList.remove(sc);
			}
		});
	}
	@Override
	public void failed(Throwable ex, Object attachment)
	{
		System.out.println("����ʧ��: " + ex);
	}
}