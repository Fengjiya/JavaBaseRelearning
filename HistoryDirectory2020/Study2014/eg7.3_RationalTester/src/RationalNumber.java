/* RationalNumber.java                Author: Baicai
 * 
 * Represents one rational number with a numerator and denominator.
 */
public class RationalNumber 
{
	private int numerator;
	private int denominator;
	
	//-------------------------------------------------------------------
	//Constructor:Sets up the rational number by ensuring a nozero
	//denominator and making only the numerator singed.
	//---------------------------------------------------------------------
	public RationalNumber( int numer, int denom)
	{
		if ( denom == 0)
		{
			denom =1;
		}
		
		//Make the numerator "store" the sign.
		if ( denom < 0 )
		{
			numer *= -1;
			denom *= -1;
		}
		
		numerator = numer;
		denominator = denom;
		
		reduce();
	}
	
	//--------------------------------------------------------------
	//Reduce this rational number by dividing both the numerator
	//and the denominator bye their greatest common divisor.
	//---------------------------------------------------------------
	private void reduce()
	{
		if ( numerator != 0)
		{
			int common = gcd (Math.abs(numerator), denominator);
			numerator = numerator / common;
			denominator = denominator / common;
		}
	}
	
	//-----------------------------------------------------------------
	//Computes and return the greatest common divisor of the two numbers.
	//Use Euclid's algorithm.
	//即求两个数的最大公因子。
	//------------------------------------------------------------------
	private int gcd ( int num1, int num2)
	{
		while (num1 != num2)
		{
			if (num1 > num2)
				num1 = num1 - num2;
			else num2 = num2 - num1;
		}
		
		return num1;
	}
	
	//------------------------------------------------
	//Return the numerator of the number.
	//------------------------------------------------
	public int getNumerator()
	{
		return numerator;
	}
	
	//--------------------------------------------
	//Return the denominator of the number.
	//----------------------------------------------
	public int getDenominator()
	{
		return denominator;
	}
	
	//------------------------------------------------------------
	//Return the reciprocal of this rational number.
	//------------------------------------------------------------
	public RationalNumber reciprocal()
	{
		return new RationalNumber(denominator, numerator);
	}
	
	//--------------------------------------------------------------
	//Adds the two rational number.
	//--------------------------------------------------------------
	public RationalNumber add(RationalNumber num)
	{
		int commonDenominator = denominator * num.getDenominator();
		int numerator1 = numerator * num.getDenominator();
		int numerator2 = num.getNumerator() * denominator;
		int sumNumerator = numerator1 + numerator2;
		
		return new RationalNumber(sumNumerator, commonDenominator);
	}
	
	//---------------------------------------------------------
	//Subtracts this rational number.
	//---------------------------------------------------------
	public RationalNumber subtract(RationalNumber num)
	{
		int commonDenominator = denominator * num.getDenominator();
		int numerator1 = numerator * num.getDenominator();
		int numerator2 = num.getNumerator() * denominator;
		int sumNumerator = numerator1 - numerator2;
		
		return new RationalNumber(sumNumerator, commonDenominator);
	}
	
	//-----------------------------------------------------------------
	//Multiplies the rational number by the one passed as a parameter.
	//------------------------------------------------------------------
	public RationalNumber multiply (RationalNumber num)
	{
		int numer = numerator * num.getNumerator();
		int denom = denominator * num.getDenominator();
		
		return new RationalNumber(numer, denom);
	}
	
	//-------------------------------------------------------------------
	//Divides this two rational number.
	//-------------------------------------------------------------------
	public RationalNumber divide(RationalNumber num)
	{
		return multiply(num.reciprocal());
	}
	
	//-----------------------------------------------------
	//Determins if this rational number is equal to the other one.
	//--------------------------------------------------------------
	public boolean isLike(RationalNumber num)
	{
		if ( numerator == num.getNumerator() &&
		     denominator == num.getDenominator())
			return true;
		else return false;
	}
	
	//----------------------------------------------------------------------
	//Returns the rational number as a string.
	//----------------------------------------------------------------------
	public String toString()
	{
		String result;
		if (numerator == 0)
			result = "0";
		else if (denominator == 1)
			result = numerator + " ";
		else result = numerator + "/" + denominator;
		
		return result;
	}
}

