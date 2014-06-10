/*
 * @version: 2012.12.1
 * @author: Baicai
 * 
 * Convert time to hours.
 * 
 */

import java.util.Scanner;

public class SecondtoTime 
{
	public static void main(String[] args)
	{
		final int SECONDS_PER_HOUR = 3600;
		final int SECONDS_PER_MINUTE = 60;
		
		int hour;
		int minute;
		int second;
        Scanner scan = new Scanner(System.in);
		
		
		System.out.print("Enter the second: ");
		second = scan.nextInt();
		
		hour = second / SECONDS_PER_HOUR;
		minute = (second % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
		second = (second % SECONDS_PER_HOUR) % SECONDS_PER_MINUTE;
		
		if (minute >= 60)
		{
			hour ++;
			minute -= 60;
		}
		
		/*if (hour >= 24)
		{
			hour %= 24;
		}*/
		
		System.out.println("The sum time: " + hour + " hours "
		+ minute + " minutes " + second + " seconds");
	}

}
