public class ForeachTest
{
	public static void main( String[] args )
	{
		int[] tmp = { 1,2,3,4,5 };
		for( int i: tmp )
		{
			i = 123;
			System.out.print( i + "	" );
		}
		
		System.out.println(  );
		for( int j: tmp )
		{
			//i = 123;
			System.out.print( j + "	" );
		}
	}
}