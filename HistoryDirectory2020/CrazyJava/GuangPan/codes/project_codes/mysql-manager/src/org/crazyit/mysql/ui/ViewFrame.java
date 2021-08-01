package org.crazyit.mysql.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import org.crazyit.mysql.object.list.ViewData;

/**
 * ����(�޸���ͼ����)
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class ViewFrame extends CommonFrame {

	private JScrollPane editPane;
	
	private JTextArea editArea = new JTextArea(20, 40);
	
	private JToolBar toolBar = new JToolBar();
	
	private NameFrame nameFrame;
	
	private Action save = new AbstractAction("����", new ImageIcon("images/save-view.gif")) {
		public void actionPerformed(ActionEvent e) {
			save();
		}
	};
	
	//��ǰ����ͼ����
	private ViewData viewData;
	//���������
	private MainFrame mainFrame;
	
	public ViewFrame(ViewData viewData, MainFrame mainFrame) {
		this.viewData = viewData;
		this.mainFrame = mainFrame;
		this.nameFrame = new NameFrame(this);
		if (viewData.getContent() != null) {
			this.editArea.setText(viewData.getContent());
		}
		this.editArea.setLineWrap(true);
		this.editPane = new JScrollPane(this.editArea);
		this.add(editPane);
		this.setLocation(250, 150);
		this.toolBar.add(save).setToolTipText("����");
		this.add(toolBar, BorderLayout.NORTH);
		this.setTitle("������ͼ");
		this.pack();
	}
	
	public void setViewData(ViewData viewData) {
		this.viewData = viewData;
	}
	
	public ViewData getViewData() {
		return this.viewData;
	}
	
	public JTextArea getEditArea() {
		return this.editArea;
	}
	
	private void save() {
		if (this.viewData.getContent() == null) {
			//����Ϊ�գ����
			add();
		} else {
			//�޸�
			update();
		}
	}
	
	//���
	private void add() {
		this.nameFrame.setVisible(true);
	}
	
	//�޸�
	private void update() {
		try {
			String content = this.editArea.getText();
			this.viewData.setContent(content);
			this.viewData.alterView();
			this.mainFrame.refreshDataList();
		} catch (Exception e) {
			showMessage(e.getMessage(), "����");
		}
	}
	
	public int showMessage(String s, String title) {
		return JOptionPane.showConfirmDialog(this, s, title,
				JOptionPane.OK_CANCEL_OPTION);
	}
	
	//�÷�����NameFrame����
	public void confirm(String name) {
		//�õ��û��������ͼ����
		String content = this.getEditArea().getText();
		if (content.trim().equals("") || name.trim().equals("")) {
			this.showMessage("������������Ϣ", "����");
			return;
		}
		ViewData viewData = this.getViewData();
		try {
			viewData.createView();
			viewData.setName(name);
			viewData.setContent(content);
			this.setViewData(viewData);
			nameFrame.setVisible(false);
			//ˢ��MainFrame�б�
			this.mainFrame.refreshDataList();
		} catch (Exception e) {
			showMessage(e.getMessage(), "����");
		}
	}
	
}
