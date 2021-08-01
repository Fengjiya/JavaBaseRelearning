import java.sql.*;

public class GetUserTest 
{
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		Connection conn =  JDBCTool.getConnection("jdbc:mysql://localhost:3306/db","root", "123456"); //�������ݿ�
		
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
		System.out.println("ԭʼ���ݣ� ");
		
		while( rs.next())
		{
			String id = rs.getString(1);
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			String entrydate = rs.getString("entrydate");
			String dept = rs.getString("department");
			String others = rs.getString("others");
			
			System.out.print("��ţ�" + id);
			System.out.print("	����:" + name);
			System.out.print("	�Ա�:" + sex);
			System.out.print("	����:" + entrydate);
			System.out.print("	רҵ:" + dept);
			System.out.println("	��ע:" + others);
		}
		*/
		
		ps = conn.prepareStatement("insert into Employees values(?,?,?,?,?,?)");
		ps.setInt(1, 4);
		ps.setString(2, "Taolang");
		ps.setString(3, "c");
		ps.setString(4, "1992-3-8");
		ps.setString(5, "Transportation");
		ps.setString(6, "a clever boy!");
		
		ps.executeUpdate();       //��������
		ps = conn.prepareStatement("select * from Employees");
		
	    rs = ps.executeQuery();
		
		System.out.println("�޸Ĺ�������ݣ� ");
		
		while( rs.next())
		{
			String id = rs.getString(1);
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			String entrydate = rs.getString("entrydate");
			String dept = rs.getString("department");
			String others = rs.getString("others");
			
			System.out.print("��ţ�" + id);
			System.out.print("	����:" + name);
			System.out.print("	�Ա�:" + sex);
			System.out.print("	����:" + entrydate);
			System.out.print("	רҵ:" + dept);
			System.out.println("	��ע:" + others);
		}
	}

}
