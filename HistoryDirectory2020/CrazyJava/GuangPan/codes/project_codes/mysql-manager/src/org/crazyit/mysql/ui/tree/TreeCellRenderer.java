package org.crazyit.mysql.ui.tree;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.crazyit.mysql.object.ViewObject;

/**
 * �������ڵ�Ĵ�����
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
@SuppressWarnings("serial")
public class TreeCellRenderer extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		//���ÿ���ڵ��ViewObject
		ViewObject obj = (ViewObject)node.getUserObject();
		if (obj == null) return this;
		//����ͼƬ���ļ�
		this.setText(obj.toString());
		this.setIcon(obj.getIcon());
		//�ж��Ƿ�ѡ������������ɫ
		if (sel) this.setForeground(Color.blue);
		else this.setForeground(getTextNonSelectionColor());
		return this;
	}
}
