/**
* �����Ϸ�򻯰棬�����ݿ⣬ֻ�����������������ݣ���Ҳ��������
* @Author:��ƽ�� 
* @Time:2014.01.08 ~ 
* @Version�� 1.0
*/
public class SuoHaProcedure
{
	private Card[] totalCard;
	private int cardList;  //����ķ������У�����25����
	
	public SuoHaProcedure()
	{
		//���ȳ�ʼ���ƶѣ���28���˿���
		totalCard = new Card[ 28 ];
		int count = 0;  //������0~28��������ʼ���ƶѵļ�����
		for ( int i = 0; i < CARD_COLOUR.length(); i++ )
			for ( int j = 0; j < CARD_VALUE.length(); j++ )
			{
				totalCard[ count ].setCardColour( CARD_COLOUR[ i ] );
				totalCard[ count ].setCardValue( CARD_VALUE[ j ] );
				count++;
			}
		
		//��ʼ�������������,��ֵ
		for ( int i = 0; i < 25; i++ )
		{
			cardList[ i ] = i;
		}
		//���ҷ���˳��
		for( int i = 0; i < 100; i++ )
		{
			Random rd = new Random();
			int index1 = rd.nextInt( 25 );
			int index2 = rd.nextInt( 25 );
			
			int tmp = cardList[ index1 ];
			cardList[ index1 ] = cardList[ index2 ];
			cardList[ index2 ] = tmp;
		}
		
		//��ʼϴ�ƣ����Ƴ��������
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
	
	//��ʼ2�ַ���
	public void inti2HandCards( SuoHaPlayer[] players, int playerNum )
	{
		//���ȴ�1��λ��ʼ����
		
	}
	//��ע
	public void loadChip()
	{
	
	}
	//��ע
	public void addChip()
	{
	
	}
	//��ע
	public void followChip()
	{
	
	}
	
	public void chipChoose()
	{
	
	
	
	}
	
}