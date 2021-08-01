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
public class BetterPrinter implements Output
{
	private String[] printData 
		= new String[MAX_CACHE_LINE * 2];
	//���Լ�¼��ǰ���ӡ����ҵ��
	private int dataNum = 0;
	public void out()
	{
		//ֻҪ������ҵ��������ӡ
		while(dataNum > 0)
		{
			System.out.println("���ٴ�ӡ�����ڴ�ӡ��" + printData[0]);
			//����ҵ��������ǰ��һλ������ʣ�µ���ҵ����1	
			System.arraycopy(printData , 1, printData, 0, --dataNum);
		}
	}
	public void getData(String msg)
	{
		if (dataNum >= MAX_CACHE_LINE * 2)
		{
			System.out.println("����������������ʧ��");
		}
		else
		{
			//�Ѵ�ӡ������ӵ�������ѱ������ݵ�������1��
			printData[dataNum++] = msg;
		}
	}
}
