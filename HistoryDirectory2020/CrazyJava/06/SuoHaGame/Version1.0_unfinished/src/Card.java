public class Card
{
	public static final String[] CARD_COLOUR = { "∫⁄Ã“", "∫ÏÃ“", "≤›ª®", "∑Ω∆¨" };
	public static final char[] CARD_VALUE = { '8', '9', '10', 'J', 'Q', 'K', 'A' };
	
	private String cardColour;  
	private char cardValue;
	
	public void setCardColour( String str )
	{
		cardColour = str;
	}
	
	public void setCardValue( char value )
	{
		cardValue = value;
	}
	
	public String getCardColour()
	{
		return cardColour;
	}
	
	public char getCardValue()
	{
		return cardValue;
	}
	
	public void replaceCard( Card tmp )
	{
		cardColour = tmp.getCardColour();
		cardValue = tmp.getCardValue();
	}
}