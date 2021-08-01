package org.crazyit.mysql.object.tree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import org.crazyit.mysql.exception.ConnectionException;
import org.crazyit.mysql.util.ImageUtil;

/**
 * ���������Ӷ���
 * @author yangenxiong
 *
 */
public class ServerConnection extends ConnectionNode {

	
	//MySQL����
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	//��������
	private String connectionName;
	//�û���
	private String username;
	//����
	private String password;
	//����ip
	private String host;
	//���Ӷ˿�
	private String port;
	
	public ServerConnection(String connectionName, String username,
			String password, String host, String port) {
		super();
		this.connectionName = connectionName;
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}
	
	/**
	 * ���һ�������������������е����ݿ�
	 * @param conn
	 * @return
	 */
	public List<Database> getDatabases() {
		List<Database> result = new ArrayList<Database>();
		try {
			//���һ�������������е����ݿ�
			ResultSet rs = query("show databases");
			while (rs.next()) {
				String databaseName = rs.getString("Database");
				Database db = new Database(databaseName, this);
				result.add(db);
			}
			rs.close();
			return result;
		} catch (Exception e) {
			return result;
		}
	}

	//��ѯ������ResultSet����
	public ResultSet query(String sql) throws Exception {
		Statement stmt = getStatement();
		return stmt.executeQuery(sql);
	}
	
	//��������������ӣ���ʹ���ֳɵ����Ӵ���Statement��û���������´�������
	public Statement getStatement() throws Exception {
		if (super.connection != null) {
			return super.connection.createStatement();
		}
		Connection conn = createConnection("");
		return conn.createStatement();
	}
	
	//���������ַ���
	public String getConnectUrl() {
		return "jdbc:mysql://" + this.host + ":" + this.port + "/";
	}
	
	//��ȡ����
	public Connection connect() {
		//serverConnection�ڱ����ʵ����ֻ��һ��ʵ��
		if (super.connection != null) {
			return super.connection;
		}
		try {
			Class.forName(DRIVER);
			Connection conn = createConnection("");
			super.connection = conn;
			return super.connection;
		} catch (Exception e) {
			throw new ConnectionException("��������������, ��������");
		}
	}
	
	//��������, ���������ݿ�����
	public Connection createConnection(String database) throws Exception {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(getConnectUrl() + database, 
				this.username, this.password);
		return conn;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getConnectionName() {
		return connectionName;
	}
	
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	
	public Icon getIcon() {
		if (super.connection == null) return ImageUtil.CONNECTION_CLOSE;
		else return ImageUtil.CONNECTION_OPEN;
	}

	
	public String toString() {
		return this.connectionName;
	}
	
	
}
