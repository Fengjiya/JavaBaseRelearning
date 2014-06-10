/*
 * @version: 2012.12.1
 * @arthor: Baicai
 * 
 * To calculate the time you need in float.
 * 
 */

import java.util.Scanner;

public class TravelTime 
{
	public static void main(String[] args)
	{
		int speed;
		int distance;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the speed: ");
		speed = scan.nextInt();
		System.out.print("Enter the distance: ");
		distance = scan.nextInt();
		
		System.out.println("The time you need: " + ((float)distance / speed) + " hours");
	}

}
