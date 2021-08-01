public class Gobang
{
	private String[][] board;
	private static int BOARD_SIZE = 20;
	
	
	public Gobang()
	{
		initBoard();
		printBoard();
	}
	
	
	private void initBoard()
	{
		board = new String[ BOARD_SIZE ][ BOARD_SIZE ];
		//System.out.println("________________________________________" );
		for( int i = 0; i < BOARD_SIZE; i++ )
		{
			for ( int j = 0; j < BOARD_SIZE; j++ )
			{
				board[ i ][ j ] = "©ï";
			} // end of for:j
		} // end of for: i
		//System.out.println("________________________________________" );
	} // end of initBoard
	
	
	private void printBoard()
	{
	
		for( int i = 0; i < BOARD_SIZE; i++ )
		{
			for ( int j = 0; j < BOARD_SIZE; j++ )
			{
				 System.out.print( board[ i ][ j ] );
			} // end of for:j
			System.out.println();
		} // end of for: i
	} // end of initBoard
	
	
	public void setPoint( int x, int y )
	{
		board[ x ][ y ] = "¡ñ";
		printBoard();
	}

}