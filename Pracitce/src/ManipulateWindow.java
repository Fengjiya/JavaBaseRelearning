import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;

public class ManipulateWindow
{
	public static void main( String[] args) throws Exception
	{
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the month you want to search: ");
		n = scan.nextInt();
		
		DbDao dd = new DbDao();
		PreparedStatement pstm = dd.getConnection().prepareStatement("select * from sales where id <= ?", n);
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<MetaSale> saleList = new ArrayList<>();
		while( rs.next() )
		{
			saleList.add(new MetaSale( rs.getString(2), rs.getDouble(3)) );
		}
		
		new DBSalesFigures( saleList );
		for( MetaSale ms: saleList )
		{
			System.out.println( ms );
		}
	}

}
