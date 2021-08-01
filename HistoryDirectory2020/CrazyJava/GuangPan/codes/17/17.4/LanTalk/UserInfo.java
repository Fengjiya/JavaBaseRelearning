package LanTalk;

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
public class UserInfo
{
	// ���û���ͼ��
	private String icon;
	// ���û�������
	private String name;
	// ���û���MulitcastSocket���ڵ�IP�Ͷ˿�
	private SocketAddress address;
	// ���û�ʧȥ��ϵ�Ĵ���
	private int lost;
	// ���û���Ӧ�Ľ�̸����
	private ChatFrame chatFrame;
	public UserInfo(){}
	// �в����Ĺ�����
	public UserInfo(String icon , String name
		, SocketAddress address , int lost)
	{
		this.icon = icon;
		this.name = name;
		this.address = address;
		this.lost = lost;
	}

	// ʡ������field��setter��getter����

	// icon��setter��getter����
	public void setIcon(String icon)
	{
		this.icon = icon;
	}
	public String getIcon()
	{
		return this.icon;
	}

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// address��setter��getter����
	public void setAddress(SocketAddress address)
	{
		this.address = address;
	}
	public SocketAddress getAddress()
	{
		return this.address;
	}

	// lost��setter��getter����
	public void setLost(int lost)
	{
		this.lost = lost;
	}
	public int getLost()
	{
		return this.lost;
	}

	// chatFrame��setter��getter����
	public void setChatFrame(ChatFrame chatFrame)
	{
		this.chatFrame = chatFrame;
	}
	public ChatFrame getChatFrame()
	{
		return this.chatFrame;
	}

	// ʹ��address��Ϊ���û��ı�ʶ�����Ը���address��Ϊ
	// ��дhashCode()��equals�����ı�׼
	public int hashCode()
	{
		return address.hashCode();
	}
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass() == UserInfo.class)
		{
			UserInfo target = (UserInfo)obj;
			if (address != null)
			{
				return address.equals(target.getAddress());
			}
		}
		return false;
	}
}