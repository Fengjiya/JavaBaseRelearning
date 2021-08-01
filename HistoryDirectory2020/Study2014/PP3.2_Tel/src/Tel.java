/*
 * @version: 2012.12.7
 * @author: Baicai
 * 
 * To get a random telephone number with nine numbers, the 
 * first three number can't contain eight or nine, the three number in middle
 * can't be bigger than 742.
 * ��дһ��Ӧ�ó������ɲ���ӡһ��"XXX-XXX-XXXX"���͵�����绰���룬���������ߣ���ǰ���������в�����8����9���м�
 * ����������ɵ������ܴ���742.
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
