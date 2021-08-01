
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
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
public class JEditorPaneTest
{
	JFrame mainWin = new JFrame("����JEditorPane");
	LinkedList<String> urls = new LinkedList<String>();
	JEditorPane editorPane = new JEditorPane();
	JTextField url = new JTextField(30);
	JCheckBox editable = new JCheckBox();
	JButton backButton = new JButton("����");

	public void init()
	{ 
		//Ĭ�����ò�����༭
		editorPane.setEditable(false);
		editorPane.addHyperlinkListener(new HyperlinkListener()
		{  
			public void hyperlinkUpdate(HyperlinkEvent event)
			{  
				if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
				{  
					try
					{  
						//���û��������URL
						urls.push(event.getURL().toString());
						//���ı���������URL�ַ���
						url.setText(event.getURL().toString());
						//��JEditorPaneװ���µ�ҳ��
						editorPane.setPage(event.getURL());
					}
					catch (IOException e)
					{  
						editorPane.setText("�����쳣: " + e);
					}
				}
			}
		});

		//Ϊ�ɱ༭�ĸ�ѡ������¼���������
		editable.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent event)
			{
				//����ø�ѡ����ѡ��״̬����ñ༭���ɱ༭
				editorPane.setEditable(editable.isSelected());
			}
		});

		//����URLָ��ҳ��ļ�����
		ActionListener listener = new ActionListener()
		{  
			public void actionPerformed(ActionEvent event)
			{  
				try
				{  
					//���û�������URL��ӵ�URLջ��
					urls.push(url.getText());
					editorPane.setPage(url.getText());
				}
				catch (IOException e)
				{  
					editorPane.setText("ҳ��: " + e);
				}
			}
		};

		JButton loadButton = new JButton("����");
		loadButton.addActionListener(listener);
		url.addActionListener(listener);

		//Ϊ���˰�ť��Ӽ�����
		backButton.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent event)
			{
				//�����û���Ѿ��������URL
				if (urls.size() <= 1) return;
				try
				{  
					//ȡ��������ȡ���һ��URL
					String urlString = urls.pop();
					url.setText(urlString);
					//���¼����µ�URL
					editorPane.setPage(urlString);
				}
				catch (IOException e)
				{  
					editorPane.setText("�����쳣: " + e);
				}
			}
		});

		mainWin.add(new JScrollPane(editorPane), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.add(new JLabel("������ַ��"));
		panel.add(url);
		panel.add(loadButton);
		panel.add(backButton);
		panel.add(new JLabel("�Ƿ�ɱ༭"));
		panel.add(editable);

		mainWin.add(panel, BorderLayout.NORTH);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
   }

	public static void main(String[] args) 
	{
		new JEditorPaneTest().init();
	}
}


