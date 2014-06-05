
public class BreakTest2
{
	public static void main(String[] args)
	{
		//外层循环,outer作为标识符
		int count = 0;
		outer:
		for( int i = 0; i < 5; i++)
		{
			//内层循环
			for ( int j = 0; j < 3; j++)
			{
				System.out.println( "i= " + i + "  j= " + j );
				if ( j == 1 )
				{
					//break;
					break outer;
				}
			} // end of for:j
			count++;
			System.out.println( "Back to for:i !" + "	count=" + count );
		} // end of for:i
	} //end of main
} // end of class