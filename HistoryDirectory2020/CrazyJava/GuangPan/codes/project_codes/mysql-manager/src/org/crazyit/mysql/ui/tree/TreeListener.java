package org.crazyit.mysql.ui.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.crazyit.mysql.ui.MainFrame;

/**
 * ��������¼�������
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class TreeListener extends MouseAdapter {

	private MainFrame mainFrame;
	
	public TreeListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			//���������鿴���Ľڵ�
			this.mainFrame.viewTreeDatas();
		}
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			//�Ҽ��˵�
			this.mainFrame.showTreeMenu(e);
		}
		
	}

}
