import java.sql.*;

public class test 
{
	public static void main (String[] arg)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "baicai", "123456");
			System.out.println("Connected!");
		}
		catch(ClassNotFoundException e) 
		{
            System.out.println("Sorry,can`t find the Driver!"); 
            e.printStackTrace();
            System.out.println("Not Connected!");
         } 
		catch( SQLException e)
		{
			e.printStackTrace();
			System.out.println("Not Connected!");
		}
		finally
		{
			System.out.println("END!");
		}
		
		
	}

}
