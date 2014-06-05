/*
 * @version: 2012.12.7
 * @author: Baicai
 * 
 * To get a random telephone number with nine numbers, the 
 * first three number can't contain eight or nine, the three number in middle
 * can't be bigger than 742.
 * 编写一个应用程序，生成并打印一个"XXX-XXX-XXXX"类型的随机电话号码，包括连接线，。前三个数字中不能有8或者9，中间
 * 三个数字组成的数不能大于742.
 */

import java.util.Scanner;
import java.util.Random;
import java.text.*;

public class Tel 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		DecimalFormat fmt = new DecimalFormat("####.");
		
		int num1, num2, num3;
		String str = "";
		
		for ( int i = 0; i < 3; i++)
		{
			str += random.nextInt(8);
		}
		
		str += "-";
		str += random.nextInt(742);
		str += "-";
		str += random.nextInt(10000);
		
		System.out.println("Tht telephone: " + str);
	}

}
