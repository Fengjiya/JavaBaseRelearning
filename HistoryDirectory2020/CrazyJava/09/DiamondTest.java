import java.util.*;

public class DiamondTest
{
	public static void main( String[] args )
	{
		List< String > books = new ArrayList<>();
		books.add("���Java����" );
		books.add("���Android����" );
		books.add( "�������Ľ�����" );
		
		for ( String str: books )
		{
			System.out.println( str );
		}
		
		Map< String, List<String> > schoolsInfo = new HashMap<>();
		List< String > schools = new ArrayList<>();
		schools.add("б�����Ƕ�" );
		schools.add( "����ȡ��" );
		schools.add( "�����" );
		
		schoolsInfo.put( "�����", schools );
		
		for( String key : schoolsInfo.keySet() )
		{
			List<String> list = schoolsInfo.get( key );
			System.out.println( key + "----->" + list );
		}
		
	}
	
}