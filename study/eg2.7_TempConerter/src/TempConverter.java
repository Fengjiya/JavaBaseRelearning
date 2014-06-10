/*
 * @version: 2012.11.29       @author: Baicai
 * 
 * Demonstrates the use of primitive data types and arithmetic
 * expressions.
 * ********************************************************************
 * @version: 2012.12.7          @author: Baicai
 * Add the DecimalFormat class to format output .
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class TempConverter 
{
	//-------------------------------------------------------------------------------
		//Computes the Fahrenheit equivalet of a specific Celsius
		//value using the formula F = (9/5)C + 32.
		//-------------------------------------------------------------------------------
		public static void main(String[] args)
		{
			final int BASE = 32;
			final double CONVERSION_FACTOR = 9.0 / 5.0;
			
			double fahrenheitTemp;
			double celsiusTemp ;
			Scanner scan = new Scanner(System.in);
			DecimalFormat fmt = new DecimalFormat("0.##");
			
			System.out.print("Input the Celsius Temperture: ");
			celsiusTemp = scan.nextDouble();
			
			
			while(celsiusTemp <= -273.15)
			{
				System.out.println("The Temperture can't be lower than absolute temperture!");
				System.out.print("Input the Celsius Temperture again: ");
				celsiusTemp = scan.nextDouble();
				
			}
			
			System.out.println();
			
			fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;
			
			System.out.println("Celsius Temperture: " + celsiusTemp);
			System.out.println("Fahrenheit Equivalent: " + fmt.format(fahrenheitTemp));
		}


}
