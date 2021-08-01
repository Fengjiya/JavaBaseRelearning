public class SuoHaPlayer extends Player
{
	private HandCards cards;
	private int chip;
	
	public SuoHaPlayer()
	{
		super();
		cards = null;
		chip = 200;
	}
	
	public void gainCards( Card cd )
	{
		cards.setCard( cd );
	}
	
	
}