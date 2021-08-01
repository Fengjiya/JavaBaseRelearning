/**
* �������һ���汾��ֻ�Ǽ򵥵�ʵ������ʾһ�����̣�Ȼ��������������Ҫ�µ����ӣ�����û�ж���
* �����޷�ֻ�����壬ֻ�����������һ��λ��Ϊ����
* Version:1.0  Author: Caipinglan
* Date:2014/01/05 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Wuziqi
{
	final String white = "O";
	final String black = "��";
	public static void main( String[] args ) throws Exception
	{
		Gobang gb = new Gobang();
		
		//���ڻ�ȡ��������
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String inputStr = null;
		//br.readLine():ÿ���ڼ���������һ�����ݺ󰴻س�������������ݽ��ᱻbr��ȡ��
		while ( ( inputStr = br.readLine() ) != null )
		{
			//���û�������ַ����ԡ������������ָ�Ϊ2���ַ�
			String[] posStrArr = inputStr.split( "," );
			//��2���ַ���ת��Ϊ���������
			int xPos = Integer.parseInt( posStrArr[0] );
			int yPos = Integer.parseInt( posStrArr[1] );
			gb.setPoint( xPos, yPos );
			//gb.printBoard();
			
			System.out.println("�������������꣬Ӧ��x��y�ĸ�ʽ: " );
		} // end of while 
	} // end of main

} // end of Wuziqi