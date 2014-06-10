import java.sql.*;

public class GetUserTest 
{
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		Connection conn =  JDBCTool.getConnection("jdbc:mysql://localhost:3306/db","root", "123456"); //连接数据库
		
		//PreparedStatement ps = conn.prepareStatement("select * from employees  ");
		//ps.setString( 1, "2" );
		//ps.setString( 2, "Caipinglan" );	
		
		/*
		ResultSet rs = ps.executeQuery();
		 while ( rs.next())
		 {
			// System.out.println("1111111111");
			 System.out.println(rs.getString("id") + " : " + rs.getString("name"));
		 }
		 rs.close();
		 ps.close();
		 conn.close();
		 */
		PreparedStatement ps;
		
		ps = conn.prepareStatement("select * from Employees");
		
		ResultSet rs = ps.executeQuery();
		
		/*
		System.out.println("原始数据： ");
		
		while( rs.next())
		{
			String id = rs.getString(1);
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			String entrydate = rs.getString("entrydate");
			String dept = rs.getString("department");
			String others = rs.getString("others");
			
			System.out.print("编号：" + id);
			System.out.print("	姓名:" + name);
			System.out.print("	性别:" + sex);
			System.out.print("	生日:" + entrydate);
			System.out.print("	专业:" + dept);
			System.out.println("	备注:" + others);
		}
		*/
		
		ps = conn.prepareStatement("insert into Employees values(?,?,?,?,?,?)");
		ps.setInt(1, 4);
		ps.setString(2, "Taolang");
		ps.setString(3, "c");
		ps.setString(4, "1992-3-8");
		ps.setString(5, "Transportation");
		ps.setString(6, "a clever boy!");
		
		ps.executeUpdate();       //更新数据
		ps = conn.prepareStatement("select * from Employees");
		
	    rs = ps.executeQuery();
		
		System.out.println("修改过后的数据： ");
		
		while( rs.next())
		{
			String id = rs.getString(1);
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			String entrydate = rs.getString("entrydate");
			String dept = rs.getString("department");
			String others = rs.getString("others");
			
			System.out.print("编号：" + id);
			System.out.print("	姓名:" + name);
			System.out.print("	性别:" + sex);
			System.out.print("	生日:" + entrydate);
			System.out.print("	专业:" + dept);
			System.out.println("	备注:" + others);
		}
	}

}
