/*@version:2012.12.1
 *@arthor: Baicai
 *
 *To convert miles to km.
 *
 */

import java.util.Scanner;

public class MilesConverter 
{
	public static void main(String[] args)
	{
		final double CONVERTER_FACTOR = 1.60935;
		
		double miles;
		double kilometers;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the miles: ");
		miles = scan.nextDouble();
		
		kilometers = miles * CONVERTER_FACTOR;
		
		System.out.println("The kilometers: " + kilometers );
	}

}
