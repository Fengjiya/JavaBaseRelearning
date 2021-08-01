
import java.sql.*;


public class DbDao
{
	private Connection conn;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:33.6/test";
	private final String username = "root";
	private final String pass = "123456";
	public DbDao()
	{
	}
	
	

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	

	/**
	 * @return the user
	 */
	public String getUser() {
		return username;
	}

	
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	
	
	//To get db's connection
	public Connection getConnection() throws Exception
	{
		if( conn == null )
		{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, username, pass);
		}
		return conn;
	}
	
	//Insert data
	public ResultSet query(String sql,Object... args) throws Exception
	{
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		for( int i = 0; i < args.length; i++ )
		{
			pstm.setObject( i+1, args[i]);
		}
		return pstm.executeQuery();
	}
	
	//update data
	public void modify(String sql, Object... args) throws Exception
	{
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		for( int i = 0; i< args.length; i++ )
		{
			pstm.setObject(i+1, args[i]);
		}
		pstm.executeUpdate();
		pstm.close();
	}
	
	//To close the connection
	public void closeConn() throws Exception
	{
		if( conn != null && conn.isClosed() )
		{
			conn.close();
		}
	}

}
