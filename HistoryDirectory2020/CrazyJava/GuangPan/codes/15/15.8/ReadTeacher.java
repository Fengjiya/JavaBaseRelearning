
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
public class ReadTeacher
{
	public static void main(String[] args) 
	{
		try(
			// ����һ��ObjectInputStream�����
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("teacher.txt")))
		{
			// ���ζ�ȡObjectInputStream�������е��ĸ�����
			Teacher t1 = (Teacher)ois.readObject();
			Teacher t2 = (Teacher)ois.readObject();
			custom.Person p = (Person)ois.readObject();
			Teacher t3 = (Teacher)ois.readObject();
			// ���true
			System.out.println("t1��student���ú�p�Ƿ���ͬ��"
				+ (t1.getStudent() == p));
			// ���true
			System.out.println("t2��student���ú�p�Ƿ���ͬ��"
				+ (t2.getStudent() == p));
			// ���true
			System.out.println("t2��t3�Ƿ���ͬһ������"
				+ (t2 == t3));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
