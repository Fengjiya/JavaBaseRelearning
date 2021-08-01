/*
 * @version:2012.11.28        @author:Baicai
 * 
 * To display a picture of diamond with some regular
 * 
 */

import java.util.Scanner;

public class disDiamond 
{
	public static void main(String[] args)
	{
		int num;   //the max number of diamond a line user want to display
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please to input the maxmium odd number of diamond a line: ");
		num = scan.nextInt();
		while ( num <= 1 || num % 2 == 0)
		{
			System.out.print("Please input a odd number!\nInput: ");
			num = scan.nextInt();
		}
		
		
		int n;            // the key variable to control the number of spaces and diamonds in each line
		n = num / 2;
		
		
		for (int i = -n; i <= n; i++)
		{
			
			//to print space in each line
			for ( int space_num = 0; space_num < Math.abs(i); space_num++)
			{
				System.out.print(" ");
			}
			
			
			int diamonds;
			diamonds = (n + 1 - Math.abs(i)) * 2 - 1;   //the number of diamonds in each line
			
			//to print diamonds each line
			for ( int diamond_num = 1; diamond_num <= diamonds; diamond_num++)
			{
				System.out.print("*");
			}
			
			System.out.println();
			
		}
	}

}
