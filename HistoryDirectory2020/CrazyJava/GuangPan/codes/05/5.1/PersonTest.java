import lee.sub.Person;

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
public class PersonTest
{
	public static void main(String[] args) 
	{
//����һ��Person���͵ı���
Person p;
//ͨ��new�ؼ��ֵ���Person��Ĺ�����������һ��Personʵ����
//����Personʵ������p������
p = new Person();
		//����p��name Field��ֱ��Ϊ��Field��ֵ��
		p.name = "���";
		//����p��say����������say����ʱ������һ���βΣ�
		//���ø÷�������Ϊ�β�ָ��һ��ֵ
		p.say("Java���Ժܼ򵥣�ѧϰ�����ף�");
		//ֱ�����p��name Field������� ���
		System.out.println(p.name);
		//��p������ֵ��ֵ��p2����
		Person p2 = p;
	}
}
