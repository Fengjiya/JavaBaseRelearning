public class StaticAccessNonStatic
{
	public void info ()
	{
		System.out.println("�򵥵�info����" );
	}
	
	public static void main( String[] args )
	{
		//main���ܵ��÷�static����
		new StaticAccessNonStatic().info();
	}
	
}