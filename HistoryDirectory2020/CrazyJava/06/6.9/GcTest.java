public class GcTest
{
	public static void main( String args[] )
	{
		for ( int i = 0; i < 3; i++ )
		{
			new GcTest();
			System.gc();
			//Runtime.getRuntime().gc();
		}
		
	}
	
	public void finalize()
	{
		System.out.println("System is doing the cleaning......" );
	}
	
}