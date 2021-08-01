
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;
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
public class QueryExecutor
{
	JFrame jf = new JFrame("��ѯִ����");
	private JScrollPane scrollPane;
	private JButton execBn = new JButton("��ѯ");
	// ���������ѯ�����ı���
	private JTextField sqlField = new JTextField(45);
	private static Connection conn;
	private static Statement stmt;
	// ���þ�̬��ʼ��������ʼ��Connection��Statement����
	static
	{
		try
		{
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String drivers = props.getProperty("driver");
			String url = props.getProperty("url");
			String username = props.getProperty("user");
			String password = props.getProperty("pass");
			// �������ݿ�����
			Class.forName(drivers);
			// ȡ�����ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// --------��ʼ������ķ���---------
	public void init()
	{
		JPanel top = new JPanel();
		top.add(new JLabel("�����ѯ��䣺"));
		top.add(sqlField);
		top.add(execBn);
		// Ϊִ�а�ť�������ı�������¼�������
		execBn.addActionListener(new ExceListener());
		sqlField.addActionListener(new ExceListener());
		jf.add(top , BorderLayout.NORTH);
		jf.setSize(680, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	// ���������
	class ExceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			// ɾ��ԭ����JTable(JTableʹ��scrollPane����װ)
			if (scrollPane != null)
			{
				jf.remove(scrollPane);
			}
			try(
				// �����û������SQLִ�в�ѯ
				ResultSet rs = stmt.executeQuery(sqlField.getText()))
			{
				// ȡ��ResultSet��MetaData
				ResultSetMetaData rsmd = rs.getMetaData();
				Vector<String> columnNames =  new Vector<>();
				Vector<Vector<String>> data = new Vector<>();
				// ��ResultSet������������ӵ�Vector��
				for (int i = 0 ; i < rsmd.getColumnCount(); i++ )
				{
					columnNames.add(rsmd.getColumnName(i + 1));
				}
				// ��ResultSet�����м�¼��ӵ�Vector��
				while (rs.next())
				{
					Vector<String> v = new Vector<>();
					for (int i = 0 ; i < rsmd.getColumnCount(); i++ )
					{
						v.add(rs.getString(i + 1));
					}
					data.add(v);
				}
				// �����µ�JTable
				JTable table = new JTable(data , columnNames);
				scrollPane = new JScrollPane(table);
				// ����µ�Table
				jf.add(scrollPane);
				// ����������
				jf.validate();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) 
	{
		new QueryExecutor().init();
	}
}
