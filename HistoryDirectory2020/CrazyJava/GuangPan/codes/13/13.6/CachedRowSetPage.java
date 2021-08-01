
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.sql.rowset.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class CachedRowSetPage
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	public void initParam(String paramFile)throws Exception
	{
		// ʹ��Properties�������������ļ�
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public CachedRowSet query(String sql , int pageSize 
		, int page)throws Exception
	{
		// ��������
		Class.forName(driver);
		try(
			// ��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection(url
				, user , pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql))
		{
			// ʹ��RowSetProvider����RowSetFactory
			RowSetFactory factory = RowSetProvider.newFactory();
			// ����Ĭ�ϵ�CachedRowSetʵ��
			CachedRowSet cachedRs = factory.createCachedRowSet();
			// ����ÿҳ��ʾpageSize����¼
			cachedRs.setPageSize(pageSize);
			// ʹ��ResultSetװ��RowSet�����ôӵڼ�����¼��ʼ
			cachedRs.populate(rs , (page - 1) * pageSize + 1);
			return cachedRs;
		}
	}
	public static void main(String[] args)throws Exception
	{
		CachedRowSetPage cp = new CachedRowSetPage();
		cp.initParam("mysql.ini");
		CachedRowSet rs = cp.query("select * from student_table" , 3 , 2);   //��
		// �����������
		while (rs.next())
		{
			System.out.println(rs.getString(1)
				+ "\t" + rs.getString(2)
				+ "\t" + rs.getString(3));
		}
	}
}