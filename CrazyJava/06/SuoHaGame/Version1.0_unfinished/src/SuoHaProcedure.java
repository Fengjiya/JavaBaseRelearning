/**
* 梭哈游戏简化版，无数据库，只是用数组来保存数据，玩家不超过五个
* @Author:蔡平兰 
* @Time:2014.01.08 ~ 
* @Version： 1.0
*/
public class SuoHaProcedure
{
	private Card[] totalCard;
	private int cardList;  //随机的发牌序列，含有25个数
	
	public SuoHaProcedure()
	{
		//首先初始化牌堆，共28张扑克牌
		totalCard = new Card[ 28 ];
		int count = 0;  //计数，0~28，用来初始化牌堆的计数器
		for ( int i = 0; i < CARD_COLOUR.length(); i++ )
			for ( int j = 0; j < CARD_VALUE.length(); j++ )
			{
				totalCard[ count ].setCardColour( CARD_COLOUR[ i ] );
				totalCard[ count ].setCardValue( CARD_VALUE[ j ] );
				count++;
			}
		
		//初始化随机发牌序列,赋值
		for ( int i = 0; i < 25; i++ )
		{
			cardList[ i ] = i;
		}
		//打乱发牌顺序
		for( int i = 0; i < 100; i++ )
		{
			Random rd = new Random();
			int index1 = rd.nextInt( 25 );
			int index2 = rd.nextInt( 25 );
			
			int tmp = cardList[ index1 ];
			cardList[ index1 ] = cardList[ index2 ];
			cardList[ index2 ] = tmp;
		}
		
		//开始洗牌，把牌池排序打乱
		for( int i = 0; i < 100; i++ )
		{
			Random rd = new Random();
			int index1 = rd.nextInt( 28 );
			int index2 = rd.nextInt( 28 );
			
			Card tmp = new Card();
			tmp.replaceCard( totalCard[ index1 ]
			totalCard[ index1 ].replaceCard( totalCard[ index2 ] );
			totalCard[ index2 ].replaceCard( tmp );
		}
		
		
		
	}
	
	//开始2轮发牌
	public void inti2HandCards( SuoHaPlayer[] players, int playerNum )
	{
		//首先从1号位开始发牌
		
	}
	//下注
	public void loadChip()
	{
	
	}
	//加注
	public void addChip()
	{
	
	}
	//跟注
	public void followChip()
	{
	
	}
	
	public void chipChoose()
	{
	
	
	
	}
	
}