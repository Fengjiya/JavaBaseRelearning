import java.util.Map;
//import java.*;

public class SystemTest
{
	public static void main( String[] args ) throws Excption
	{
		Map<String, String> env = System.getenv();
		for( String name : env.keySet() )
		{
			System.out.println( name + "---->" + env.get( name ) );
		}
		
		System.out.println( System.getenv( "JAVA_HOME" ) );
		Properties props = System.getProperties();
		props.stors( new FileOutputStream( "props.txt" ), "System Properties" );
		
		System.out.println( System.getProperty( "os.name" ) );
	}
	
}