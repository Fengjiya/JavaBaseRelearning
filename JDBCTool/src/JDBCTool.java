import java.sql.*;

public class JDBCTool
{
	
	public static Connection getConnection(String url, String user, String passwd ) 
			throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection(url, user, passwd);
		
	}
	
	
	
	/*
	private Connection conn;
	
	public Connection getConnectionTool()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" JDBCDriver have been found. Connecting¡­¡­");
			
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "123456");
			System.out.println("DB linked successful.");
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	*/
	
	/*
	public static void main(String[] args)
	{
		JDBCTool c = new JDBCTool();
		c.getConnection();
	}
	*/

}
