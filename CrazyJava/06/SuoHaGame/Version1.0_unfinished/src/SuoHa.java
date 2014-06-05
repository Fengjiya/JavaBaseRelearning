public class SuoHa
{
	private static final int INIT_CHIP = 200;
	private static final int ADD_SMALL = 5;
	private static final int ADD_MIDDLE = 10;
	private static final int ADD_BIG = 20;
	private int chipPool;
	private int playerNum;
	private SuoHaPlayer[] playerList;
	
	public SuoHa()
	{
		chipPool = 0;
		playerNum = 0;
		playerList = new SuoHaPlayer[ 5 ];
	}
	
	public void addPlay( SuoHaPlayer pl )
	{
		if ( playerNum < 5 )
		{
			playerList[ player++ ] = pl;
		}
		else
		{
			System.out.println("房间已满，无法加入");
		}
	}
	
	public SuoHaPlayers[] getPlayerList()
	{
		return playerList;
	}
	public void poolIncrease( int chip )
	{
		chipPool += chip;
	}
	
	public int getPlayerNum()
	{
		return playerNum;
	}
	
}