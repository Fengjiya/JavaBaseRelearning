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
public class Computer
{
	private Output out;
	public Computer(Output out)
	{
		this.out = out;
	}
	//����һ��ģ���ȡ�ַ�������ķ���
	public void keyIn(String msg)
	{
		out.getData(msg);
	}
	//����һ��ģ���ӡ�ķ���
	public void print()
	{
		out.out();
	}
}

