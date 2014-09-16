<%@ page language="java" contentType="text/html; charset=GBK"  errorPage=""%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
	out.println("DB connected successful!");
	%>
	<br/>
	<% Statement stm = conn.createStatement();
	ResultSet rs = stm.executeQuery("select * from tab1");
	while( rs.next() )
	{
		out.println(rs.toString());
	}
			
	%>
</body>
</html>