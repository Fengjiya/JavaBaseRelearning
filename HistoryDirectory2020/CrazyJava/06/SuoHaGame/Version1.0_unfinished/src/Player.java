public class Player
{
	private String playerID;  //玩家编号，统一编号(可容纳10^11个玩家，即10亿）
	private Stirng playerName;  //玩家昵称
	private String playerState;  //玩家状态：自由free，入座等待waiting，准备ready，游戏中playing
	private String tableID;  //桌号，如东区1号
	private int tableIndex; // 桌子座号，如3号座
	//private HandCards handCards;  //所持卡牌
	private int score; //玩家积分，累计制
	//private int chip;  //玩家筹码，每一局中玩家筹码是初始化固定的，筹码用完即出局
	
	public Player()
	{
	
	}
}