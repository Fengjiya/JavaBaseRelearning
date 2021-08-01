import java.sql.*;
import java.util.*;

public class CreateDB 
{
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql:/localhost:3306/car";
	
	//Database credentials
	static final String USER = "root";
	static final String PASSWD = "1234566";
	
	//将QueryList中的所有数据写入表中
	public CreateDB( List<String[]> QueryList, List<String> overspeed, List<String> willoverspeed ) 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		 
		
		try{
			
			Class.forName(JDBC_DRIVER);
			
			//step2: Open a connection
			System.out.println("Connecting to database car...");
			conn = DriverManager.getConnection(DB_URL,USER,PASSWD);
			
			/*
			String sql = "SELECT * FROM cars";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
			while( rs.next())
			{
				System.out.println(rs.getString(1));
			}
			*/
			
			//step3: Execute a query
			//stmt = conn.createStatement();
			//String sql = "CREATE DATABASE if not exists my_db";  
			//stmt.executeUpdate( sql );
			
			System.out.println("Datebase car connected successfully!");
			
			ps = conn.prepareStatement("use car" );  
			rs = ps.executeQuery()	;
			
			/*
			//建表
			String query = "create table if not exists carinfo" 
			        +"(license varchar(10) not null , spd1 varchar(3) null, spd2 varchar(3) null,"
					+"spd3 varchar(3) null,spd4 varchar(3) null, spd5 varchar(3) null)";
			
			stmt.executeUpdate( query );
			*/


			System.out.println("正在写入所有的数据...");
			//开始查询QueryList中车辆的速度并插入数据库中
			ps = conn.prepareStatement("insert into carinfo values(?,?,?,?,?,?)");
			for ( int m = 0; m < QueryList.size(); ++m)
			{
				for( int j = 0; j < QueryList.get(m).length; j++)
				{
					if ( QueryList.get(m)[j] != null )
					{
						ps.setString(j+1, QueryList.get(m)[j] );
					}
					else continue;
				}
				ps.executeUpdate();       //更新数据，确保每辆车的数据被插入到数据库中
			}
			System.out.println("所有数据成功写!");
			
			System.out.println("正在写入超速车辆的数据...");
			//把超速车辆的车牌号写入数据库的overspeedcar表中
			ps = conn.prepareStatement(" insert into overspeedcar values(?)");
			for ( int n = 0; n < overspeed.size(); ++n	)
			{
				ps.setString( n+1, overspeed.get(n));
				ps.executeUpdate();
			}
			
			System.out.println("正在写入将要超速车辆的数据...");
			//把超速车辆的车牌号写入数据库的overspeedcar表中
			ps = conn.prepareStatement(" insert into willoverspeedcar values(?)");
			for ( int k = 0; k < willoverspeed.size(); ++k	)
			{
				ps.setString( k+1, willoverspeed.get(k));
				ps.executeUpdate();
			}
		}
		catch( SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch( Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if( stmt != null)
					stmt.close();
			}
			catch( SQLException se2)
			{
			}
			
			try
			{
				if( conn != null )
				conn.close();
			}
			catch( SQLException se )
			{
				se.printStackTrace();
			}// end of finally try
		}//end of try
		
		//System.out.println("Goodbye, DateBase and Table creating is done!");
	}//end main
}//end CreateDB
		
		
		