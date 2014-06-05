import java.sql.*;

public class JDBCTool
{
	public static Connection getConnection(String url, String user, String passwd ) 
			throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection(url, user, passwd);
		
	}

}
