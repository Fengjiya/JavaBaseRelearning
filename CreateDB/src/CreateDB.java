import java.sql.*;
public class CreateDB 
{
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";
	
	//Database credentials
	static final String USER = "root";
	static final String PASSWD = "123456";
	
	public static void main(String[] args) 
	{
		Connection conn = null;
		Statement stmt = null;
		 
		try{
			//step1:Register JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//step2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASSWD);
			
			//step3: Execute a query
			System.out.println("Creating  database...");
			stmt = conn.createStatement();
			
			String sql = "CREATE DATABASE Carinfo";
			stmt.executeUpdate( sql );
			System.out.println("Datebase created successfully");
			
			ResultSet rs = null;
			PreparedStatement ps = conn.prepareStatement("use Carinfo");
			rs = ps.executeQuery()	;
			
			String query = "create table carinfo2" 
			        +" (license varchar(10) not null primary key, spd1 varchar(2) null, spd2 varchar(2) null,"
					+"spd3 varchar(2) null,spd4 varchar(2) null, spd5 varchar(2) null)";
			
			stmt.executeUpdate( query );
			System.out.println("Table created successfully");
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
		
		System.out.println("Goodbye, DateBase and Table creating is done!");
			
	}//end main
}//end CreateDB
		
		
		
		
		/*
		Connection con = null;
		Statement stmt;
		ResultSet rs = null;
		
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?", "root", "123456");
		stmt = con.createStatement();
		System.out.println("Creating datebase...");
		
		String sql = "CREATE DATABASE car2";
		stmt.executeUpdate( sql );
		
		
		stmt.executeUpdate("create table carinfo2" 
		        +"(license varchar(10) not null primary key, spd1 varchar(2) null, spd2 varchar(2) null,"
				+"spd3 varchar(2) null,spd4 varchar(2) null, spd5 varchar(2) null, spd5 varchar(2) null");
		
		
		rs.close();
		stmt.close();
		con.close();
		*/
		
				
		
	
