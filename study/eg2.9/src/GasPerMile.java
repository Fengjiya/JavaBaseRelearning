/*
 * @version: 2012.11.29
 * @author: Baicai
 * 
 * Demonstrates the use of the Scanner class to read numeric data.
 * 
 * 1 gallon = 3.785 L
 */

import java.util.Scanner;

public class GasPerMile
{
	//------------------------------------------------------------
	//Calculates fuel efficiency based on values entered by 
	//the users.
	//------------------------------------------------------------
	public static void main(String[] args)
	{
		double miles;
		double gallons;
		double average;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the miles you have drived: ");
		miles = scan.nextDouble();
		
		System.out.print("Enter the gallons of fuel you have used: ");
		gallons = scan.nextDouble();
		
		average = miles / gallons;
		 System.out.println("Miles per gallon: " + average);
		
		
	}

}
