
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
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
public class SelectJTree
{
	JFrame jf = new JFrame("��������ѡ���¼�");
	JTree tree;
	//���弸����ʼ�ڵ�
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("�й�"); 
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("�㶫");
	DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("����");
	DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("��ɽ");
	DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("��ͷ");
	DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("����");
	DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("����");
	JTextArea eventTxt = new JTextArea(5 , 20);
	public void init()
	{
		//ͨ��add�����������ڵ�֮��ĸ��ӹ�ϵ
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(guilin);
		guangxi.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		//�Ը��ڵ㴴����
		tree = new JTree(root);
		//����ֻ��ѡ��һ��TreePath
		tree.getSelectionModel().setSelectionMode(
			TreeSelectionModel.SINGLE_TREE_SELECTION); 
		//��Ӽ������ڵ�ѡ���¼��ļ�����
		tree.addTreeSelectionListener(new TreeSelectionListener()
		{
			//��JTree�б�ѡ��ڵ㷢���ı�ʱ���������÷���
			public void valueChanged(TreeSelectionEvent e)
			{
				if (e.getOldLeadSelectionPath() != null)
					eventTxt.append("ԭѡ�еĽڵ�·����" 
					+ e.getOldLeadSelectionPath().toString() + "\n");
				eventTxt.append("��ѡ�еĽڵ�·����" 
					+ e.getNewLeadSelectionPath().toString() + "\n");
			}
		}); 
		//�����Ƿ���ʾ���ڵ�ġ�չ��/�۵���ͼ��,Ĭ����false
		tree.setShowsRootHandles(true);
		//���ø��ڵ��Ƿ�ɼ�,Ĭ����true
		tree.setRootVisible(true);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(tree));
		box.add(new JScrollPane(eventTxt));
		jf.add(box);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new SelectJTree().init();
	}
}

