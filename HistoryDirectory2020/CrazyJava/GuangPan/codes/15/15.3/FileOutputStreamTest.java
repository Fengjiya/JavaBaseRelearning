
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
public class FileOutputStreamTest
{
	public static void main(String[] args)
	{
		try(
                // �����ֽ�������
                FileInputStream fis = new FileInputStream(
                        "FileOutputStreamTest.java");
                // �����ֽ������
                FileOutputStream fos = new FileOutputStream("newFile.txt"))
		{
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			// ѭ������������ȡ������
			while ((hasRead = fis.read(bbuf)) > 0 )
			{
				// ÿ��ȡһ�Σ���д���ļ�����������˶��٣���д���١�
				fos.write(bbuf , 0 , hasRead);
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
