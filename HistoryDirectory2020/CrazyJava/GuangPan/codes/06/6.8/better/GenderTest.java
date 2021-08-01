package better;

import best.Gender;

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
public class GenderTest
{
	public static void main(String[] args) 
	{
		Gender g = Enum.valueOf(Gender.class , "FEMALE");
		g.setName("Ů");
		System.out.println(g + "����:" + g.getName());
		//��ʱ����nameֵʱ������ʾ��������
		g.setName("��");
		System.out.println(g + "����:" + g.getName());
	}
}
