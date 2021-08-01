package AIO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
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
public class AIOClient
{
	final static String UTF_8 = "utf-8";
	final static int PORT = 30000;
	// ���������ͨ�ŵ��첽Channel
	AsynchronousSocketChannel clientChannel;
	JFrame mainWin = new JFrame("��������");
	JTextArea jta = new JTextArea(16 , 48);
	JTextField jtf = new JTextField(40);
	JButton sendBn = new JButton("����");
	public void init()
	{
		mainWin.setLayout(new BorderLayout());
		jta.setEditable(false);
		mainWin.add(new JScrollPane(jta), BorderLayout.CENTER);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(sendBn);
		//������Ϣ��Action,Action��ActionListener���ӽӿ�
		Action sendAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				String content = jtf.getText();
				if (content.trim().length() > 0)
				{
					try
					{
						// ��content����д��Channel��
						clientChannel.write(ByteBuffer.wrap(content
							.trim().getBytes(UTF_8))).get();    //��
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				// ��������
				jtf.setText("");
			}
		};
		sendBn.addActionListener(sendAction);
		//��Ctrl+Enter����"send"����
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n'
			, java.awt.event.InputEvent.CTRL_MASK) , "send");
		//��"send"��sendAction����
		jtf.getActionMap().put("send", sendAction);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.add(jp , BorderLayout.SOUTH);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public void connect()
		throws Exception
	{
		// ����һ��ByteBuffer׼����ȡ����
		final ByteBuffer buff = ByteBuffer.allocate(1024);
		// ����һ���̳߳�
		ExecutorService executor = Executors.newFixedThreadPool(80);
		// ��ָ���̳߳�������һ��AsynchronousChannelGroup
		AsynchronousChannelGroup channelGroup = 
			AsynchronousChannelGroup.withThreadPool(executor);
		// ��channelGroup��Ϊ�������������AsynchronousSocketChannel
		clientChannel = AsynchronousSocketChannel.open(channelGroup);
		// ��AsynchronousSocketChannel���ӵ�ָ��IP��ָ���˿�
		clientChannel.connect(new InetSocketAddress("127.0.0.1"
			, PORT)).get(); 
		jta.append("---����������ӳɹ�---\n");
		buff.clear();
		clientChannel.read(buff, null
			, new CompletionHandler<Integer,Object>()   //��
		{
			@Override
			public void completed(Integer result, Object attachment)
			{
				buff.flip();
				// ��buff������ת��Ϊ�ַ���
				String content = StandardCharsets.UTF_8
					.decode(buff).toString();
				// ��ʾ�ӷ������˶�ȡ������
				jta.append("ĳ��˵��" + content + "\n");
				buff.clear();
				clientChannel.read(buff , null , this);
			}
			@Override  
			public void failed(Throwable ex, Object attachment)
			{
				System.out.println("��ȡ����ʧ��: " + ex);
			}
		});
	}
	public static void main(String[] args) 
		throws Exception
	{
		AIOClient client = new AIOClient();
		client.init();
		client.connect();
	}
}