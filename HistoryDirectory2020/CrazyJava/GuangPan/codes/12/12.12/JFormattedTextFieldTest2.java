
import java.text.*;

import java.lang.reflect.Array;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

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
public class JFormattedTextFieldTest2
{
	private JFrame mainWin = new JFrame("���Ը�ʽ���ı���");
	private JButton okButton = new JButton("ȷ��");
	// ����������Ӹ�ʽ���ı��������
	private JPanel mainPanel = new JPanel();
	public void init()
	{
		// ��Ӱ�ť
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		mainPanel.setLayout(new GridLayout(0, 3));
		mainWin.add(mainPanel, BorderLayout.CENTER);
		JFormattedTextField intField0 = new JFormattedTextField(
		new InternationalFormatter(NumberFormat.getIntegerInstance())
		{
			protected DocumentFilter getDocumentFilter()
			{
				return new NumberFilter();
			}
		});
		intField0.setValue(100); 
		addRow("ֻ�������ֵ��ı���", intField0);
		JFormattedTextField intField1 = new JFormattedTextField
			(NumberFormat.getIntegerInstance());
		intField1.setValue(100);
		// �������У����
		intField1.setInputVerifier(new FormattedTextFieldVerifier());
		addRow("������У�������ı���", intField1);
		// �����Զ����ʽ������
		IPAddressFormatter ipFormatter = new IPAddressFormatter();
		ipFormatter.setOverwriteMode(false);
		// ���Զ����ʽ�����󴴽���ʽ���ı���
		JFormattedTextField ipField = new JFormattedTextField(ipFormatter);
		ipField.setValue(new byte[]{(byte)192, (byte)168, 4, 1});
		addRow("IP��ַ��ʽ", ipField);
		mainWin.add(buttonPanel , BorderLayout.SOUTH);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	// �������һ�и�ʽ���ı���ķ���
	private void addRow(String labelText, final JFormattedTextField field)
	{
		mainPanel.add(new JLabel(labelText));
		mainPanel.add(field);
		final JLabel valueLabel = new JLabel();
		mainPanel.add(valueLabel);
		// Ϊ"ȷ��"��ť����¼�������
		// ���û�������ȷ������ťʱ���ı������ʾ�ı����ڵ�ֵ
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Object value = field.getValue();
				// �����ֵ�����飬ʹ��Arrays��toString�����������
				if (value.getClass().isArray())
				{ 
					StringBuilder builder = new StringBuilder();
					builder.append('{');
					for (int i = 0; i < Array.getLength(value); i++)
					{
						if (i > 0) 
							builder.append(',');
						builder.append(Array.get(value, i).toString());
					}
					builder.append('}');
					valueLabel.setText(builder.toString());
				}
				else
				{
					// �����ʽ���ı����ֵ
					valueLabel.setText(value.toString());
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		new JFormattedTextFieldTest2().init();
	}
}
// ����У����
class FormattedTextFieldVerifier extends InputVerifier 
{
	// ���������ʧȥ����ʱ���÷���������
	public boolean verify(JComponent component) 
	{
		JFormattedTextField field = (JFormattedTextField)component;
		// �����û������Ƿ���Ч
		return field.isEditValid();
	}
}
// ���ֹ�����
class NumberFilter extends DocumentFilter
{
	public void insertString(FilterBypass fb , int offset
		, String string , AttributeSet attr)throws BadLocationException 
	{
		StringBuilder builder = new StringBuilder(string);
		// �����û�����������ַ�
		filterInt(builder);
		super.insertString(fb, offset, builder.toString(), attr);
	}
	public void replace(FilterBypass fb , int offset , int length
		, String string , AttributeSet attr)throws BadLocationException 
	{
		if (string != null) 
		{
			StringBuilder builder = new StringBuilder(string);
			// �����û��滻�������ַ�
			filterInt(builder);
			string = builder.toString();
		}
		super.replace(fb, offset, length, string, attr);
	}
	// ���������ַ��������з�0��9���ַ�ȫ��ɾ��
	private void filterInt(StringBuilder builder)
	{
		for (int i = builder.length() - 1; i >= 0; i--)
		{
			int cp = builder.codePointAt(i);
			if (cp > '9' || cp < '0') 
			{
				builder.deleteCharAt(i);
			}
		}
	}
}
class IPAddressFormatter extends DefaultFormatter
{
	public String valueToString(Object value) 
		throws ParseException
	{
		if (!(value instanceof byte[])) 
		{
			throw new ParseException("��IP��ַ��ֵֻ�����ֽ�����", 0);
		}
		byte[] a = (byte[])value;
		if (a.length != 4) 
		{
			throw new ParseException("IP��ַ�������ĸ�����", 0);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++)
		{
			int b = a[i];
			if (b < 0) b += 256;
				builder.append(String.valueOf(b));
			if (i < 3) builder.append('.');
		}
		return builder.toString();
	}
	public Object stringToValue(String text) throws ParseException
	{
		// ����ʽ���ı����ڵ��ַ����Ե�ţ�.���ֳ��Ľڡ�
		String[] nums = text.split("\\.");
		if (nums.length != 4)
		{
			throw new ParseException("IP��ַ�������ĸ�����", 0);
		}
		byte[] a = new byte[4];
		for (int i = 0; i < 4; i++)
		{
			int b = 0;
			try
			{
				b = Integer.parseInt(nums[i]);
			}
			catch (NumberFormatException e)
			{
				throw new ParseException("IP��ַ����������", 0);
			}
			if (b < 0 || b >= 256) 
			{
				throw new ParseException("IP��ֵַֻ����0~255֮��", 0);
			}
			a[i] = (byte) b;
		}
		return a;
	}
}
