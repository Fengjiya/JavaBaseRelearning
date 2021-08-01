/*
 * @version: 2012.12.6
 * @author: Baicai
 * 
 * Demonstrates the formatting of decimal values uisng the 
 * DecimalFormat class.
 */

import java.text.DecimalFormat;
import java.util.Scanner;


public class CircleStats 
{
	//Calculates the area and circumference of a circle given its
	//radius.
	public static void main(String[] args)
	{
		double radius, area, circumference;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the circel's radius: ");
		radius = scan.nextDouble();
		
		area = Math.PI * Math.pow(radius, 2);
		circumference = 2 * Math.PI * radius;
		
		//Round the output to three decimal places.
		DecimalFormat fmt = new DecimalFormat("0.###");
		
		System.out.println("The circle's area: " + fmt.format(area));
		System.out.println("The circle's circumference: " + fmt.format(circumference));
	}

}
