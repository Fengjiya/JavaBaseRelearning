
public class BreakTest2
{
	public static void main(String[] args)
	{
		//���ѭ��,outer��Ϊ��ʶ��
		int count = 0;
		outer:
		for( int i = 0; i < 5; i++)
		{
			//�ڲ�ѭ��
			for ( int j = 0; j < 3; j++)
			{
				System.out.println( "i= " + i + "  j= " + j );
				if ( j == 1 )
				{
					//break;
					break outer;
				}
			} // end of for:j
			count++;
			System.out.println( "Back to for:i !" + "	count=" + count );
		} // end of for:i
	} //end of main
} // end of class