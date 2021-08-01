
import custom.Person;

import java.io.*;
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
public class SerializeMutable
{
	public static void main(String[] args) 
	{
		
		try(
                // ����һ��ObjectOutputStream������
                ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("mutable.txt"));
                // ����һ��ObjectInputStream������
                ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("mutable.txt")))
		{		
			custom.Person per = new custom.Person("�����", 500);
			// ϵͳ��per����ת���ֽ����в����
			oos.writeObject(per);
			// �ı�per�����name Field
			per.setName("��˽�");
			// ϵͳֻ��������л���ţ����Ըı���name���ᱻ���л�
			oos.writeObject(per);
			custom.Person p1 = (custom.Person)ois.readObject();    //��
			custom.Person p2 = (Person)ois.readObject();    //��
			// �������true���������л���p1����p2
			System.out.println(p1 == p2);
			// ������Ȼ�������"�����"�����ı���Fieldû�б����л�
			System.out.println(p2.getName());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}