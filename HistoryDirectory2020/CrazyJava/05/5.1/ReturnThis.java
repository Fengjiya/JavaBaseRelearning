public class ReturnThis
{
	public int age;
	public ReturnThis grow()
	{
		age++;
		return this;
	}
	
	public static void main( String[] args )
	{
		ReturnThis rt = new ReturnThis();
		
		rt.grow().grow().grow();
		System.out.println("re��age Fieldֵ��: " + rt.age );
	} // end of main
} // end of class