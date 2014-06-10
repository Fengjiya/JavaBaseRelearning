/*
 * @version: 2012.11.28    @author: Baicai
 * 
 * Demonstrates the use of the string concatenation operator
 * and the automatic conversion of an integer to a string
 * 
 */
public class Facts 
{
	// Print various facts;
	public static void main(String[] args)
	{
		// String can be concatenated into on long string
		System.out.println("We present the following facts for your"
				+ "extracurriclar edification:");
		System.out.println();
		
		// a string can contain numeric digits
		System.out.println("Letters in the Hawaiian alphabet: 12");
		
		// A numeric value can be concatenated to a string
		System.out.println("Dialing code for Antarctica:" + 672);
		System.out.println("Year in which Leonardo da vinci invented the parachute"
				+ 1212);
		System.out.println("Speed of ketchup: " + 40 + " km per year");
	}

}
