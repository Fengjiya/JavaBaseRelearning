package condition;

import java.util.concurrent.locks.*;
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
public class Account
{
	// ��ʽ����Lock����
	private final Lock lock = new ReentrantLock();
	// ���ָ��Lock�����Ӧ��Condition
	private final Condition cond  = lock.newCondition(); 
	// ��װ�˻���š��˻��������Field
	private String accountNo;
	private double balance;
	//��ʶ�˻����Ƿ����д������
	private boolean flag = false;

	public Account(){}
	// ������
	public Account(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	// accountNo��setter��getter����
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getAccountNo()
	{
		return this.accountNo;
	}
	// ����˻�����������޸ģ�����ֻΪbalance�ṩgetter������
	public double getBalance()
	{
		return this.balance;
	}

	public void draw(double drawAmount)
	{
		// ����
		lock.lock();
		try
		{
			// ���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ��ȡǮ��������
			if (!flag)
			{
				cond.wait();
			}
			else
			{
				// ִ��ȡǮ
				System.out.println(Thread.currentThread().getName() 
					+ " ȡǮ:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ��" + balance);
				// ����ʶ�˻��Ƿ����д��������Ϊfalse��
				flag = false;
				// ���������߳�
				cond.signalAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		// ʹ��finally�����ͷ���
		finally
		{
			lock.unlock();
		}
	}
	public void deposit(double depositAmount)
	{
		lock.lock();
		try
		{
			// ���flagΪ�棬�����˻��������˴�Ǯ��ȥ�����Ǯ��������
			if (flag)             //��
			{
				cond.wait();
			}
			else
			{
				// ִ�д��
				System.out.println(Thread.currentThread().getName()
					+ " ���:" +  depositAmount);
				balance += depositAmount;
				System.out.println("�˻����Ϊ��" + balance);
				// ����ʾ�˻��Ƿ����д��������Ϊtrue
				flag = true;
				// ���������߳�
				cond.signalAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		// ʹ��finally�����ͷ���
		finally
		{
			lock.unlock();
		}
	}

	// ����������������accountNo����дhashCode()��equals()����
	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if (obj !=null
			&& obj.getClass() == Account.class)
		{
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}