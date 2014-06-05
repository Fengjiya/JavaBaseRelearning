import java.util.*;

public class DiamondTest
{
	public static void main( String[] args )
	{
		List< String > books = new ArrayList<>();
		books.add("疯狂Java讲义" );
		books.add("疯狂Android讲义" );
		books.add( "轻量级的进口量" );
		
		for ( String str: books )
		{
			System.out.println( str );
		}
		
		Map< String, List<String> > schoolsInfo = new HashMap<>();
		List< String > schools = new ArrayList<>();
		schools.add("斜月三星洞" );
		schools.add( "西天取经" );
		schools.add( "孙悟空" );
		
		schoolsInfo.put( "孙悟空", schools );
		
		for( String key : schoolsInfo.keySet() )
		{
			List<String> list = schoolsInfo.get( key );
			System.out.println( key + "----->" + list );
		}
		
	}
	
}