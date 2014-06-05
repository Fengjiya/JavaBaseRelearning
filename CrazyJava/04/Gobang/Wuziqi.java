/**
* 五子棋第一个版本，只是简单的实现了显示一个棋盘，然后再上面设置你要下的棋子，但是没有对手
* 电脑无法只能下棋，只是随机的设置一个位置为黑子
* Version:1.0  Author: Caipinglan
* Date:2014/01/05 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Wuziqi
{
	final String white = "O";
	final String black = "●";
	public static void main( String[] args ) throws Exception
	{
		Gobang gb = new Gobang();
		
		//用于获取键盘输入
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String inputStr = null;
		//br.readLine():每当在键盘上输入一行内容后按回车，刚输入的内容将会被br读取到
		while ( ( inputStr = br.readLine() ) != null )
		{
			//将用户输入的字符串以“，”隔开，分割为2个字符
			String[] posStrArr = inputStr.split( "," );
			//将2个字符串转化为下棋的坐标
			int xPos = Integer.parseInt( posStrArr[0] );
			int yPos = Integer.parseInt( posStrArr[1] );
			gb.setPoint( xPos, yPos );
			//gb.printBoard();
			
			System.out.println("请输入下棋坐标，应以x，y的格式: " );
		} // end of while 
	} // end of main

} // end of Wuziqi