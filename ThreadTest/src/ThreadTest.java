import java.lang.Thread;

public class ThreadTest extends Thread 
{
	private int count = 10;
	
	public void run()
	{
		while( true )
		{
			
			System.out.print( count + " " );
			if( --count == 0 )
			{
				return;
			}
		}//end of while
	}//end of public void run()
	
	public static void main( String[] args )
	{
		new ThreadTest().start();
	}

}
