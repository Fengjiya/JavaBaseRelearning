/*
 * @version: 2012.12.1
 * @author: Baicai
 * 
 * Conerter time to seconds.
 * 
 */

import java.util.Scanner;

public class TimetoSecond 
{
	public static void main(String[] args)
	{
		final int SECONDS_PER_HOUR = 3600;
		final int SECONDS_PER_MINUTE = 60;
		
		int hour;
		int minute;
		int second;
		long sum_second;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the hour: ");
		hour = scan.nextInt();
		System.out.print("Enter the minute: ");
		minute = scan.nextInt();
		System.out.print("Enter the second: ");
		second = scan.nextInt();
		
		sum_second = hour * SECONDS_PER_HOUR + minute * SECONDS_PER_MINUTE + second;
		
		System.out.println("the sum of second: " + sum_second + "s");
	}

}
