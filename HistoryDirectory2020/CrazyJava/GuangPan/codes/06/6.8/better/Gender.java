package better;

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
public enum Gender 
{
	MALE,FEMALE;
	private String name;
	public void setName(String name)
	{
		switch (this)
		{
			case MALE:
				if (name.equals("��"))
				{
					this.name = name;
				}
				else
				{
					System.out.println("��������");
					return;
				}
				break;
			case FEMALE:
			if (name.equals("Ů"))
			{
				this.name = name;
			}
			else
			{
				System.out.println("��������");
				return;
			}
			break;
		}
	}
	public String getName()
	{
		return this.name;
	}
}
