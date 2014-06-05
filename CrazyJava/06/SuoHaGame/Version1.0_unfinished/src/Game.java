import java.util.Scanner;

public class Game
{
	private GameTpye gameType;
	//private Player[] players;
	private GameState deskState;
	
	
	private void initGame( GameType gameType )
	{
		this.gameType = gameType;
		players = null;
		deskState = GameState.values()[ 0 ];
		System.out.println( gameType + deskState );
		
		startGame();
	}
	//根据gameType游戏类型来启动游戏
	private void startGame()
	{
		if( gameType == GameType.values()[ 0 ] )
		{
			startSuoHa();
		}
		else if ( gameType == GameType.values()[ 1 ] )
		{
			startWuZiQi();
		}
		else
		{
			startBaShuMa();
		}
	}
	
	//启动梭哈游戏
	public void startSuoHa()
	{
		System.out.println( "游戏开始初始化...." );
		//players = new SuoHaPlayer[ 5 ];
		
		SuoHa suoha = new SuoHa();
		SuoHaPlayer[] players = suoha.getPlayerList();
		//首先判断人数是否已满，或者是否要添加玩家
		int playerNum = suoha.getPlayerNum();  //获得玩家人数
		//让玩家选择是否添加玩家
		if ( playerNum == 0 )
		{
			System.out.println( "玩家必须不少于2人，现在无法开始游戏！" 
			                  + "等待新玩家加入……" );
			/*
			*连接数据库，读取新玩家代码待写！！！
			*/
			pl = ~~~~;
			suoha.addPlayer( pl );
			playNum++;
		}
		
		else if ( playerNum <= 1 )
		{
			System.out.println( "玩家必须不少于2人，现在无法开始游戏！" 
			                  + "等待新玩家加入……" );
			/*
			*连接数据库，读取新玩家代码待写！！！
			*/
			pl = ~~~~;
			suoha.addPlayer( pl );
			playNum++;
		}
		
		else 
		{
			while ( playerNum < 5 )
			{
				System.out.println( "现在有: " + playerNum + "个玩家，是否继续等待新玩家加入？" );
				System.out.println( "Y/N  ?" );
				Scanner scn = new Scanner( System.in );
				String s = scn.next();
				Char ch = s.charAt( 0 );
				if( ch == 'Y' ) 
				{
					SuoHaPlayer pl = ~~~~~~~~~~~~;
					suoha.addPlayer( pl );
					playerNum++;
					continue;
				}
				else
				{
					break;
				}
			} // end of while
		}   // end of else
					
		//玩家添加完毕，然后开始游戏
		//还没写完，需要继续写
		
		SuoHaProcedure pro = new SuoHaProcedure();
		//第一步：发前2轮牌
		pro.init2HandCards( SuoHaPlayer[] players, int playerNum );
		
		
		
		//玩家添加完毕，开始启动游戏,尚未完成
	}
	
	//判断游戏结束
	public boolean gameOver( SuoHa suoha )
	{
		int playerNum = suoha.getPlayerNum();
		if ( playerNum > 1 )
		{
			deskState = GameState.values()[ 2 ];
			System.out.println( deskState );
			return true;
		}
		else
			return false;
	}
}















