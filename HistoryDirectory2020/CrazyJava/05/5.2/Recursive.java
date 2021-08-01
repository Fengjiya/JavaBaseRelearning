import java.util.Scanner;

public class Recursive
{
	public static int fn( int n )
	{
		if ( n < 0 )
		{
			System.out.println("请输入非负0的整数!" );
			return 0;
		}
		else if ( n == 0 )
		{
			return 1;
		}
		else if ( n == 1 )
		{
			return 4;
		}
		else
		{
			return fn( n-1 ) * 2 + fn( n-2 );
		}
	}  // end of static fn
	
	public static void main( String[] args )
	{
		Scanner scn = new Scanner( System.in );
		System.out.print("请输入一个非负整数: " );
		int n = scn.nextInt();
		System.out.println( "The result is: " + fn( n ) );
	} // end of main
}
		