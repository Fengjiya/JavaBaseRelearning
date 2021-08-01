import custom.Person;

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
public class Teacher 
	implements java.io.Serializable
{
	private String name;
	private custom.Person student;
	public Teacher(String name , custom.Person student)
	{
		this.name = name;
		this.student = student;
	}
	//�˴�ʡ����name��student��setter��getter����

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// student��setter��getter����
	public void setStudent(custom.Person student)
	{
		this.student = student;
	}
	public Person getStudent()
	{
		return this.student;
	}
}