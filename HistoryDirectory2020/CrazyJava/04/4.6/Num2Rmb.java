import java.util.Arrays;  
import java.util.Scanner;

public class Num2Rmb
{
	private String[] hanArr = { "��", "Ҽ", "��", "��", "��", "��",
								"½", "��", "��", "��" };
	private String[] unitArr = { "", "ʰ","��", "Ǫ" };
	
	/**
	* ���ڰ��������ֺ�С�����ַֿ�
	* @param num��Ҫ���ֽ�ĸ�����
	* @return �ֽ�������������ֺ�С�����֡���һ������Ԫ�����������֣��ڶ�������Ԫ����С������
	*/
	private String[] divide( double num )
	{
		//��һ��������ǿ��ת��ȡ�������õ���������
		long zheng = (long)num;
		//double��ȥ�������֣�Ȼ�����100�����õ�С�������2λ���֣������������룩
		long xiao = Math.round( (num - zheng) * 100 ); //Math.round()С��������������������
		//���ְ�����ת��Ϊ�ַ����ķ���������Integer.toString(i)����Ч��
		return new String[] { zheng + "", String.valueOf( xiao) };
	} // end of function: divide
	
	/**
	*���ڰ�һ����λ����ת��Ϊ��д����
	* @param numStr��λ�����ַ���
	* @return ת���Ĵ�д�����ַ���
	*/
	private String toHanStr( String numStr )
	{
		String result = "";
		int numlen = numStr.length();
		//���������ַ�����ÿ���ַ�
		for( int i = 0; i < numlen; i++ )
		{
			//char��int֮�䣬��ASCII�����48
			//��˰�char�ͼ�ȥ48�õ�int����
			int num =  numStr.charAt(i) - 48;
			if ( num == 0 )
			{
				continue;
			}
			result += hanArr[num] + unitArr[ numlen - i -1 ];
		} // end of for
		
		return result;
	}  // end of function: toHanStr
	
	public static void main( String[] args )
	{
		Scanner scn = new Scanner( System.in );
		Num2Rmb nr = new Num2Rmb();
		
		System.out.println( "����Ҫ�ֽ��double������λ������" );
		System.out.print( "�ֽ���:" );
		double db = scn.nextDouble();
		System.out.print( "��λ����: " );
		String str = scn.next();
		
		
		//���԰�һ���������ֽ�Ϊ�������ֺ�С�����ֵĹ���
		System.out.println( Arrays.toString( nr.divide( db ) ) );
		//���԰���λ����ת��Ϊ�����ַ���
		System.out.println( str+ "= " + nr.toHanStr( str ) );
	} // end of main
	
} // end of class: Num2Rmb
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			