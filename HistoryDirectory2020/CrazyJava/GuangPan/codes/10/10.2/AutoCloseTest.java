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
public class AutoCloseTest
{
	public static void main(String[] args) 
		throws IOException
	{
		try (
                // ��������ʼ�������ɹرյ���Դ
                // try�����Զ��ر���������Դ��
                BufferedReader br = new BufferedReader(
				new FileReader("AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new
				FileOutputStream("a.txt")))
		{
			// ʹ��������Դ
			System.out.println(br.readLine());
			ps.println("ׯ�������Ժ���");
		}
	}
}
