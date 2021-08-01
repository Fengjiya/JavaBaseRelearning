package synchronizedBlock;

import condition.Account;

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
public class DrawThread extends Thread
{
	// ģ���û��˻�
	private Account account;
	// ��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
	private double drawAmount;
	public DrawThread(String name , Account account
		, double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	// �������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ���⡣
	public void run()
	{
		// ʹ��account��Ϊͬ�����������κ��߳̽�������ͬ�������֮ǰ��
		// �����Ȼ�ö�account�˻����������������߳��޷��������Ҳ���޷��޸���
		// �����������ϣ������� �� �޸� �� �ͷ��������߼�
		synchronized (account)
		{
			// �˻�������ȡǮ��Ŀ
			if (account.getBalance() >= drawAmount)
			{
				// �³���Ʊ
				System.out.println(getName()
					+ "ȡǮ�ɹ����³���Ʊ:" + drawAmount);
				try
				{
				Thread.sleep(1);
				}
				catch (InterruptedException ex)
				{
				ex.printStackTrace();
				}
				// �޸����
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("\t���Ϊ: " + account.getBalance());			
			}
			else
			{
				System.out.println(getName() + "ȡǮʧ�ܣ����㣡");
			}
		}
		//ͬ���������������߳��ͷ�ͬ����
	}
}
