/**
* �����ж����ƴ�С��
*
*/
public class HandCards
{
	private Card[] cards;
	private int cardNum;
	private int handCardLevel;
	
	public HandCards()
	{
		cards = new Card[ 5 ];
		cardNum = 0;
	}
	
	public void gainCard( Card cd )
	{
		Cards[ cardNum ].replaceCard( cd );
		cardNum++;
	}
	
}