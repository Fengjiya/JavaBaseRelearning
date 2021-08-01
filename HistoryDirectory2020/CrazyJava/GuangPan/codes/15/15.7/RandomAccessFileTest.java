
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
public class RandomAccessFileTest
{
	public static void main(String[] args) 
	{
		try(
			RandomAccessFile raf =  new RandomAccessFile(
                    "RandomAccessFileTest.java", "r"))
		{
			// ��ȡRandomAccessFile�����ļ�ָ���λ�ã���ʼλ����0
			System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ�ã�" 
				+ raf.getFilePointer());
			// �ƶ�raf���ļ���¼ָ���λ��
			raf.seek(300);
			byte[] bbuf = new byte[1024];
			// ���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			// ʹ��ѭ�����ظ���ȡˮ������
			while ((hasRead = raf.read(bbuf)) > 0 )
			{
				// ȡ������Ͳ����ˮ�Σ��ֽڣ������ֽ�����ת�����ַ������룡
				System.out.print(new String(bbuf , 0 , hasRead ));
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
