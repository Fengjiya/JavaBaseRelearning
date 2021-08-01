package condition;

import synchronizedMethod.DrawThread;

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
public class DrawTest
{
	public static void main(String[] args) 
	{
		// ����һ���˻�
		Account acct = new Account("1234567" , 0);
		new DrawThread("ȡǮ��" , acct , 800).start();
		new DepositThread("����߼�" , acct , 800).start();
		new DepositThread("�������" , acct , 800).start();
		new DepositThread("����߱�" , acct , 800).start();
	}
}
