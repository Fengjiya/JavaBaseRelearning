/*
 * @version: 2012.12.8
 * @author: Baicai
 * 
 * Represents one die(singular of dice) with faces showing values
 * between 1 and 6.
 */
public class Die 
{
	private final int MAX = 6;
	private int faceValue;
	
	//----------------------------------------------------
	//   Constructor: Sets the initial face value.
	//----------------------------------------------------
	public Die()
	{
		faceValue = 1;
	}

	//-----------------------------------------------
	//  Rolls the die and returns the result.
	//-----------------------------------------------
	public int roll()
	{
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
	}
	
	//------------------------------------------------------
	//  Face value mutator.
	//------------------------------------------------------
	public void setFaceValue(int value)
	{
		faceValue = value;
	}
	
	//--------------------------------------------------------
	//  Face value accessor.
	//--------------------------------------------------------
	public int getFaceValue()
	{
		return faceValue;
	}
	
	//--------------------------------------------------------
	//  Returns a string represention of this die.
	//--------------------------------------------------------
	public String toString()
	{
		String result = Integer.toString(faceValue);
		return result;
	}
	
	
	
}
