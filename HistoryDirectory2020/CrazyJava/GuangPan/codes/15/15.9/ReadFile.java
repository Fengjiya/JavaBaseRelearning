
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
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
public class ReadFile
{
	public static void main(String[] args)
		throws IOException
	{
		try(
                // �����ļ�������
                FileInputStream fis = new FileInputStream("ReadFile.java");
                // ����һ��FileChannel
                FileChannel fcin = fis.getChannel())
		{
			// ����һ��ByteBuffer���������ظ�ȡˮ
			ByteBuffer bbuff = ByteBuffer.allocate(64);
			// ��FileChannel�����ݷ���ByteBuffer��
			while( fcin.read(bbuff) != -1 )
			{
				// ����Buffer�Ŀհ���
				bbuff.flip();
				// ����Charset����
				Charset charset = Charset.forName("GBK");
				// ����������(CharsetDecoder)����
				CharsetDecoder decoder = charset.newDecoder();
				// ��ByteBuffer������ת��
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.print(cbuff);
				// ��Buffer��ʼ����Ϊ��һ�ζ�ȡ������׼��
				bbuff.clear();
			}
		}
	}
}
