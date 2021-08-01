package LanTalk;

import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
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
// ���콻����Ϣ�Ĺ�����
public class ComUtil
{
	// ʹ�ó�����Ϊ������Ķ��㲥IP��ַ
	private static final String BROADCAST_IP
		= "230.0.0.1";
	// ʹ�ó�����Ϊ������Ķ��㲥Ŀ�ĵĶ˿�
	// DatagramSocket���õĵĶ˿�Ϊ�ö˿�-1��
	public static final int BROADCAST_PORT = 30000;
	// ����ÿ�����ݱ�������СΪ4K
	private static final int DATA_LEN = 4096;
	// ���屾�����MulticastSocketʵ��
	private MulticastSocket socket = null;
	// ���屾����˽�ĵ�Socketʵ��
	private DatagramSocket singleSocket = null;
	// ����㲥��IP��ַ
	private InetAddress broadcastAddress = null;
	// ��������������ݵ��ֽ�����
	byte[] inBuff = new byte[DATA_LEN];
	// ��ָ���ֽ����鴴��׼���������ݵ�DatagramPacket����
	private DatagramPacket inPacket = 
		new DatagramPacket(inBuff , inBuff.length);
	// ����һ�����ڷ��͵�DatagramPacket����
	private DatagramPacket outPacket = null;
	// ��������������
	private LanTalk lanTalk;
	// ����������ʼ����Դ
	public ComUtil(LanTalk lanTalk) throws Exception
	{
		this.lanTalk = lanTalk;
		// �������ڷ��͡��������ݵ�MulticastSocket����
		// ��Ϊ��MulticastSocket������Ҫ���գ�������ָ���˿�
		socket = new MulticastSocket(BROADCAST_PORT);
		// ����˽���õ�DatagramSocket����
		singleSocket = new DatagramSocket(BROADCAST_PORT + 1);
		broadcastAddress = InetAddress.getByName(BROADCAST_IP);
		// ����socket����ָ���Ķ��㲥��ַ
		socket.joinGroup(broadcastAddress);
		// ���ñ�MulticastSocket���͵����ݱ������͵�����
		socket.setLoopbackMode(false);
		// ��ʼ�������õ�DatagramSocket��������һ������Ϊ0���ֽ�����
		outPacket = new DatagramPacket(new byte[0] 
			, 0 , broadcastAddress , BROADCAST_PORT);
		// ����������ȡ�������ݵ��߳�
		new ReadBroad().start();
		Thread.sleep(1);
		new ReadSingle().start();
	}
	// �㲥��Ϣ�Ĺ��߷���
	public void broadCast(String msg)
	{
		try
		{
			// ��msg�ַ���ת���ֽ�����
			byte[] buff = msg.getBytes();
			// ���÷����õ�DatagramPacket����ֽ�����
			outPacket.setData(buff);
			// �������ݱ�
			socket.send(outPacket);
		}
		// ��׽�쳣
		catch (IOException ex)
		{
			ex.printStackTrace();
			if (socket != null)
			{
				// �رո�Socket����
				socket.close();
			}
			JOptionPane.showMessageDialog(null
				, "������Ϣ�쳣����ȷ��30000�˿ڿ��У�����������������"
				, "�����쳣", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	// �����򵥶��û�������Ϣ�ķ���
	public void sendSingle(String msg , SocketAddress dest)
	{
		try
		{
			// ��msg�ַ���ת���ֽ�����
			byte[] buff = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(buff
				, buff.length , dest);
			singleSocket.send(packet);
		}
		// ��׽�쳣
		catch (IOException ex)
		{
			ex.printStackTrace();
			if (singleSocket != null)
			{
				// �رո�Socket����
				singleSocket.close();
			}
			JOptionPane.showMessageDialog(null
				, "������Ϣ�쳣����ȷ��30001�˿ڿ��У�����������������"
				, "�����쳣", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	// ���ϴ�DatagramSocket�ж�ȡ���ݵ��߳�
	class ReadSingle extends Thread
	{
		// ��������������ݵ��ֽ�����
		byte[] singleBuff = new byte[DATA_LEN];
		private DatagramPacket singlePacket = 
			new DatagramPacket(singleBuff , singleBuff.length);
		public void run()
		{
			while (true)
			{
				try
				{
					// ��ȡSocket�е����ݡ�
					singleSocket.receive(singlePacket);
					// �����������Ϣ
					lanTalk.processMsg(singlePacket , true);
				}
				// ��׽�쳣
				catch (IOException ex)
				{
					ex.printStackTrace();
					if (singleSocket != null)
					{
						// �رո�Socket����
						singleSocket.close();
					}
					JOptionPane.showMessageDialog(null
						, "������Ϣ�쳣����ȷ��30001�˿ڿ��У�����������������"
						, "�����쳣", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}
	// ������ȡMulticastSocket���߳�
	class ReadBroad extends Thread
	{
		public void run()
		{
			while (true)
			{
				try
				{
					// ��ȡSocket�е����ݡ�
					socket.receive(inPacket);
					// ��ӡ�����socket�ж�ȡ������
					String msg = new String(inBuff , 0
						, inPacket.getLength());
					// ������������������Ϣ
					if (msg.startsWith(YeekuProtocol.PRESENCE)
						&& msg.endsWith(YeekuProtocol.PRESENCE))
					{
						String userMsg = msg.substring(2
							, msg.length() - 2);
						String[] userInfo = userMsg.split(YeekuProtocol
							.SPLITTER);
						UserInfo user = new UserInfo(userInfo[1] 
							, userInfo[0] , inPacket.getSocketAddress(), 0);
						// �����Ƿ���Ҫ��Ӹ��û������
						boolean addFlag = true;
						ArrayList<Integer> delList = new ArrayList<>();
						// ����ϵͳ�����е������û�,��ѭ������ѭ�����
						for (int i = 1 ; i < lanTalk.getUserNum() ; i++ )
						{
							UserInfo current = lanTalk.getUser(i);
							// �������û�ʧȥ��ϵ�Ĵ�����1
							current.setLost(current.getLost() + 1);
							// �������Ϣ��ָ���û����͹���
							if (current.equals(user))
							{
								current.setLost(0);
								// ���ø��û��������
								addFlag = false;
							}
							if (current.getLost() > 2)
							{
								delList.add(i);
							}
						}
						// ɾ��delList�е�����������Ӧ���û�
						for (int i = 0; i < delList.size() ; i++)
						{
							lanTalk.removeUser(delList.get(i));
						}
						if (addFlag)
						{
							// ������û�
							lanTalk.addUser(user);
						}
					}
					// �����������ǹ�����Ϣ
					else
					{
						// �����������Ϣ
						lanTalk.processMsg(inPacket , false);
					}
				}
				// ��׽�쳣
				catch (IOException ex)
				{
					ex.printStackTrace();
					if (socket != null)
					{
						// �رո�Socket����
						socket.close();
					}
					JOptionPane.showMessageDialog(null
						, "������Ϣ�쳣����ȷ��30000�˿ڿ��У�����������������"
						, "�����쳣", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}
}
