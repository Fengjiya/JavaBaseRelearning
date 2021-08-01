package org.crazyit.gamehall.fivechess.client.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.crazyit.gamehall.fivechess.commons.ChessUser;

/**
 * �����Ϣ��JPanel
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class UserTable extends JTable {

	//�������(��������ǰ���)
	private List<ChessUser> users;
	
	//��ǰ������������
	private ChessUser user;
	
	//ͷ��
	private Map<String, Icon> heads;
	
	public UserTable(List<ChessUser> users, ChessUser user) {
		this.users = users;
		this.user = user;
		//���Լ��ӵ�����б���ǰ��
		this.users.add(0, user);
		this.heads = new HashMap<String, Icon>();
		DefaultTableModel model = (DefaultTableModel)this.getModel();
		model.setDataVector(getDatas(), getColumns());
		setTableFaces();
	}
	
	//�����б���ʽ
	private void setTableFaces() {
		this.getColumn("id").setMinWidth(0);
		this.getColumn("id").setMaxWidth(0);
		this.getColumn("ͷ��").setCellRenderer(new UserTableCellRenderer());
		this.getColumn("ͷ��").setMaxWidth(40);
		this.getColumn("����").setCellRenderer(new UserTableCellRenderer());
		this.getColumn("�Ա�").setMaxWidth(28);
		this.getColumn("�Ա�").setCellRenderer(new UserTableCellRenderer());
		this.setRowHeight(34);
	}
	
	//������������б�
	public void setUsers(List<ChessUser> users) {
		this.users = users;
		refresh();
	}
	
	public void addUser(ChessUser user) {
		this.users.add(user);
		refresh();
	}
	
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)this.getModel();
		model.setDataVector(getDatas(), getColumns());
		setTableFaces();
	}
	
	//�õ�����б�����ݸ�ʽ
	private Vector<Vector> getDatas() {
		Vector<Vector> result = new Vector<Vector>();
		for (ChessUser user : this.users) {
			Vector v = new Vector();
			v.add(user.getId());
			v.add(getHead(user.getHeadImage()));
			v.add(user.getName());
			v.add(getSex(user.getSex()));
			result.add(v);
		}
		return result;
	}
	
	private String getUserState(int state) {
		if (state == 0) return "";
		else return "��Ϸ��";
	}
	
	private String getSex(int sex) {
		return (sex == 0) ? "��" : "Ů";
	}
	
	//��Map�еõ�ͷ��, û�еø���·����ȡ
	private Icon getHead(String url) {
		if (this.heads.get(url) == null) {
			try {
				ImageIcon head = new ImageIcon(url);
				this.heads.put(url, head);
			} catch (Exception e) {
				return null;
			}
		}
		return this.heads.get(url);
	}
	
	//����JTable����
	private Vector getColumns() {
		Vector columns = new Vector();
		columns.add("id");
		columns.add("ͷ��");
		columns.add("����");
		columns.add("�Ա�");
		return columns;
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
