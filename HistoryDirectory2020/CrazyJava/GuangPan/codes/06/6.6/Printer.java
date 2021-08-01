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
//����һ��Product�ӿ�
interface Product
{
	int getProduceTime();
}
//��Printer��ʵ��Output��Product�ӿ�
public class Printer implements Output , Product
{
	private String[] printData 
		= new String[MAX_CACHE_LINE];
	//���Լ�¼��ǰ���ӡ����ҵ��
	private int dataNum = 0;
	public void out()
	{
		//ֻҪ������ҵ��������ӡ
		while(dataNum > 0)
		{
			System.out.println("��ӡ����ӡ��" + printData[0]);
			//����ҵ��������ǰ��һλ������ʣ�µ���ҵ����1
			System.arraycopy(printData , 1
				, printData, 0, --dataNum);
		}
	}
	public void getData(String msg)
	{
		if (dataNum >= MAX_CACHE_LINE)
		{
			System.out.println("����������������ʧ��");
		}
		else
		{
			//�Ѵ�ӡ������ӵ�������ѱ������ݵ�������1��
			printData[dataNum++] = msg;
		}
	}
	public int getProduceTime()
	{
		return 45;
	}
	public static void main(String[] args)
	{
		//����һ��Printer���󣬵���Outputʹ��
		Output o = new Printer();
		o.getData("������Java EE��ҵӦ��ʵս");
		o.getData("���Java����");
		o.out();
		o.getData("���Android����");
		o.getData("���Ajax����");
		o.out();
		//����һ��Printer���󣬵���Productʹ��
		Product p = new Printer();
		System.out.println(p.getProduceTime());
		//���нӿ����͵����ñ�������ֱ�Ӹ���Object���͵ı���
		Object obj = p;
	}
}
