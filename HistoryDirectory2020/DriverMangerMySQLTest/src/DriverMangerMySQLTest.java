import java.sql.*;

public class DriverMangerMySQLTest 
{ 
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" JDBCDriver have been found. Connecting¡­¡­");
			
		}
		catch( ClassNotFoundException e)
		{
			System.out.println("Cann't find Dirver!");
		}
	}

}
