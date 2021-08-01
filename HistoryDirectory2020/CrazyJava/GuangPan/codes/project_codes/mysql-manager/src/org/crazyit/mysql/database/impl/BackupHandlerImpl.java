package org.crazyit.mysql.database.impl;

import java.io.File;
import java.util.List;

import org.crazyit.mysql.database.BackupHandler;
import org.crazyit.mysql.object.GlobalContext;
import org.crazyit.mysql.object.list.TableData;
import org.crazyit.mysql.object.tree.Database;
import org.crazyit.mysql.object.tree.ServerConnection;
import org.crazyit.mysql.util.CommandUtil;
import org.crazyit.mysql.util.MySQLUtil;

/**
 * ���ݴ���ʵ����
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class BackupHandlerImpl implements BackupHandler {

	//���mysql bin��Ŀ¼
	private String getMySQLBin(GlobalContext ctx) {
		return ctx.getMySQLHome() + MySQLUtil.MYSQL_HOME_BIN + File.separator;
	}
	
	public void dumpDatabase(GlobalContext ctx, Database db, File targetFile) {
		StringBuffer dumpCommand = new StringBuffer();
		//ע��, ��ҪΪ�������˫����, ���û��˫����, mysql��װĿ¼�пո񽫲�����������
		dumpCommand.append('"' + getMySQLBin(ctx));
		//����mysqldump����
		dumpCommand.append(MySQLUtil.MYSQLDUMP_COMMAND + '"');
		//���������Ϣ
		//Ϊ�������-u -p -h����
		getExecuteCommand(dumpCommand, db.getServerConnection());
		dumpCommand.append(" --force --databases " + db.getDatabaseName() + " > ");
		//���������·���пո񽫲�����������, ���ע����ҪΪ·����������
		dumpCommand.append('"' + targetFile.getAbsolutePath() + '"');
		System.out.println(dumpCommand.toString());
		//����ִ�е������߳�
		CommandThread thread = new CommandThread(dumpCommand.toString());
		thread.start();
	}
	

	public void dumpTable(GlobalContext ctx, List<TableData> tables, Database db, 
			File targetFile) {
		StringBuffer dumpCommand = new StringBuffer();
		StringBuffer tableNames = new StringBuffer();
		//�õ����б����ַ���
		for (TableData table : tables) tableNames.append(table.getName() + " ");
		dumpCommand.append('"' + getMySQLBin(ctx));
		//����mysqldump����
		dumpCommand.append(MySQLUtil.MYSQLDUMP_COMMAND + '"');
		//Ϊ�������-u -p -h����
		getExecuteCommand(dumpCommand, db.getServerConnection());
		dumpCommand.append(" --databases " + db.getDatabaseName());
		dumpCommand.append(" --tables " + tableNames.toString() + " > ");
		dumpCommand.append('"' + targetFile.getAbsolutePath() + '"');
		System.out.println(dumpCommand.toString());
		new CommandThread(dumpCommand.toString()).start();
	}

	public void executeSQLFile(GlobalContext ctx, Database db, File sqlFile) {
		StringBuffer dumpCommand = new StringBuffer();
		dumpCommand.append('"' + getMySQLBin(ctx));
		dumpCommand.append(MySQLUtil.MYSQL_COMMAND + '"');
		//Ϊ�������-u -p -h����
		getExecuteCommand(dumpCommand, db.getServerConnection());
		dumpCommand.append(" -D" + db.getDatabaseName());
		dumpCommand.append(" < \"" + sqlFile.getAbsolutePath() + "\"");
		System.out.println(dumpCommand.toString());
		new CommandThread(dumpCommand.toString()).start();
	}

	public void executeSQLFile(GlobalContext ctx, ServerConnection conn,
			File sqlFile) {
		StringBuffer dumpCommand = new StringBuffer();
		dumpCommand.append('"' + getMySQLBin(ctx));
		dumpCommand.append(MySQLUtil.MYSQL_COMMAND + '"');
		//Ϊ�������-u -p -h����
		getExecuteCommand(dumpCommand, conn);
		dumpCommand.append(" < \"" + sqlFile.getAbsolutePath() + "\"");
		new CommandThread(dumpCommand.toString()).start();
	}
	
	//Ϊ�������-u -p -h����
	private StringBuffer getExecuteCommand(StringBuffer command, ServerConnection conn) {
		command.append(" -u" + conn.getUsername());
		command.append(" -p" + conn.getPassword());
		command.append(" -h" + conn.getHost());
		return command;
	}

	/**
	 * ��ȡ������
	 * @param is
	 * @return
	 */
//	private String readInputStream(InputStream is) {
//		try {
//			StringBuffer result = new StringBuffer();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
//			while(br.read() != -1) {
//				result.append(br.readLine());
//			}
//			return result.toString();
//		} catch (Exception e) {
//			throw new CommandException("��ȡ�����������" + e.getMessage());
//		}
//
//	}
}

/**
 * ��������ִ���߳�
 * @author yangenxiong
 *
 */
class CommandThread extends Thread {

	private String command;
	
	public CommandThread(String command) {
		this.command = command;
	}
	
	public void run() {
		CommandUtil.executeCommand(this.command);
	}
	
}
