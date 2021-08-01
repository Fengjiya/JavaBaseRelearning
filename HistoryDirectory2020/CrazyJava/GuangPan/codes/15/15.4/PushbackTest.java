
import java.io.*;
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
public class PushbackTest
{
	public static void main(String[] args) 
	{
		try(
			// ����һ��PushbackReader����ָ���ƻػ������ĳ���Ϊ64
			PushbackReader pr = new PushbackReader(new FileReader(
                    "PushbackTest.java") , 64))
		{
			char[] buf = new char[32];
			// ���Ա����ϴζ�ȡ���ַ�������
			String lastContent = "";
			int hasRead = 0;
			// ѭ����ȡ�ļ�����
			while ((hasRead = pr.read(buf)) > 0)
			{
				// ����ȡ������ת�����ַ���
				String content = new String(buf , 0 , hasRead);
				int targetIndex = 0;
				// ���ϴζ�ȡ���ַ����ͱ��ζ�ȡ���ַ���ƴ������
				// �鿴�Ƿ����Ŀ���ַ���, �������Ŀ���ַ���
				if ((targetIndex = (lastContent + content)
					.indexOf("new PushbackReader")) > 0)
				{
					// ���������ݺ��ϴ�����һ���ƻػ�����
					pr.unread((lastContent + content).toCharArray());
					// ָ����ȡǰ��len���ַ�
					int len = targetIndex > 32 ? 32 : targetIndex;
					// �ٴζ�ȡָ�����ȵ����ݣ�����Ŀ���ַ���֮ǰ�����ݣ�
					pr.read(buf , 0 , len);
					// ��ӡ��ȡ������
					System.out.print(new String(buf , 0 ,len));
					System.exit(0);
				}
				else
				{
					// ��ӡ�ϴζ�ȡ������
					System.out.print(lastContent);
					// ������������Ϊ�ϴζ�ȡ������
					lastContent = content;
				}
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}

