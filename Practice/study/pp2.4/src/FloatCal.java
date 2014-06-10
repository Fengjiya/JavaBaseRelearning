/*
 * @version: 2012.12.1
 * @authoer: Baicai
 * 
 * To calculate the result of two doubles.
 * 
 */

import java.util.Scanner;

public class FloatCal 
{
	public static void main(String[] args)
	{
		float num1;
		float num2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter two float numbers: ");
		num1 = scan.nextFloat();
		num2 = scan.nextFloat();
		
		System.out.println("The sum is: " + (num1 + num2));
		System.out.println("The difference is: " + (num1 - num2));
		System.out.println("The product is: " + (num1 * num2));
		
	}

}
