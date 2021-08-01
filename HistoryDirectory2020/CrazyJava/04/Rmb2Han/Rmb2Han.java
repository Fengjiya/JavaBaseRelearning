import java.util.Scanner;
/**
* ������double�͵������ת��Ϊ��д�����ַ���
* С�������д����
* 2014/01/03
*/

public class Rmb2Han
{
	private final String[] numArr = { "��", "Ҽ", "��", "��", "��", "��",
								"½", "��", "��", "��" };
	private final String[] unitArr = { "��", "��", "��" ,"", "ʰ","��", "Ǫ" , "��", "��" };
	
	/**
	* ���ڰ��������ֺ�С�����ַֿ�
	* @param num��Ҫ���ֽ�ĸ�����
	* @return �ֽ�������������ֺ�С�����֡���һ������Ԫ�����������֣��ڶ�������Ԫ����С������
	*/
	private String[] divide( double num )
	{
		//��һ��������ǿ��ת��ȡ�������õ���������
		long zheng = (long)num;
		//double��ȥ�������֣�Ȼ�����1000�����õ�С�������3λ���֣������������룩
		String dou = num - zheng + "";
		//long xiao = Math.round( (num - zheng) * 1000 ); //Math.round()С��������������������
		String xiao = dou.substring( 0, 3 );
		//���ְ�����ת��Ϊ�ַ����ķ���������Integer.toString(i)����Ч��
		String[] tmp = new String[2];
		tmp[0] = zheng + "";
		tmp[1] = xiao;
		return tmp;
	} // end of function: divide
	
	/**
	* ������õ����������ֺ�С�����ֱַ�ת��Ϊ����
	* @param numStr��String�������͵��β�
	* @return ���صõ��ĺ����ַ���
	*/
	private String toHan( String[] numStr )
	{
		String intNum = numStr[0];
		String douNum = numStr[1];
		String result = "";
		int intlen = intNum.length();
		if( intlen <= 4 )
		{
			result += intConverter( intNum );
		}
		else if ( intlen <= 8 )
		{
			String str1 = intNum.substring( 0, intlen - 4 );
			String str2 = intNum.substring( intlen - 4, intlen );
		    result += intConverter( str1 ) + "��" + intConverter( str2 );
		}
		else if ( intlen <= 12 )
		{
			String str1 = intNum.substring( 0, intlen - 8 );
			String str2 = intNum.substring( intlen - 8, intlen - 4 );
			String str3 = intNum.substring( intlen - 4, intlen );
			result += intConverter( str1 ) + "��" + intConverter( str2 ) 
						+ "��" + intConverter( str3 );
		
		}
		else 
		{
			System.out.println("���������̫���������ֲ�Ӧ�ó���12λ��" );
			return "";
		}
		
		//result += "Ԫ��" + douConverter( douNum );
		result += "Ԫ��";
		
		return result;
	}
	
	/**
	*����ת���������֣���һ����λ����ת��Ϊ��д����
	* @param numStr��λ�����ַ���
	* @return ת���Ĵ�д�����ַ���
	*/
	private String intConverter( String numStr )
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
			result += numArr[num] + unitArr[ numlen - i + 2 ];
		} // end of for
		return result;
	}  // end of function: intConverter
	
	/**
	* ����ת��С�����ֵõ��ǣ��֣���
	* @param numStr��String���͵��β�
	* @return ����С������ת����ĺ���
	*/
	private String douConverter( String numStr )
	{
		String result = "";
		int num1 = numStr.charAt( 0 ) -48;
		if ( num1 != 0 )
		{
			result += numArr[num1] + unitArr[ 2 ];
		}
		
		int num2 = numStr.charAt( 1 ) -48;
		if ( num2 != 0 )
		{
			result += numArr[num2] + unitArr[ 1 ];
		}
		
		int num3 = numStr.charAt( 2 ) -48;
		if ( num3 != 0 )
		{
			result += numArr[num3] + unitArr[ 0 ];
		}
		
						
		/*		
		//�ж�С�������Ƿ���ڣ��������ڣ�ֱ�ӷ���
		if ( numStr == "0" )
		{
			return null;
		}
		
		int numlen = numStr.length();
		switch( numlen )
		{
			case 1:
				num1 = numStr.charAt( 0 ) - 48;
				if ( num1 == 0 )
				{
					break;
				}
				result += numArr[num1] + unitArr[ 2 ];
				break;
			case 2:
				num1 = numStr.charAt( 0 ) -48;
				if ( num1 != 0 )
				{
					result += numArr[num1] + unitArr[ 2 ];
				}
				
				num2 = numStr.charAt( 1 ) -48;
				result += numArr[num2] + unitArr[ 1 ];
				break;
			case 3:
				num1 = numStr.charAt( 0 ) -48;
				result += numArr[num1] + unitArr[ 2 ];
				num2 = numStr.charAt( 1 ) -48;
				result += numArr[num2] + unitArr[ 1 ];
				num3 = numStr.charAt( 2 ) -48;
				result += numArr[num3] + unitArr[ 0 ];
				break;
			default:
		}*/
			
		return result;
	}  // end of function: douConverter
	
	/**
	* �����ṩ�Ľӿ�
	* @param num��double�͵��β�
	* @return  ����ת���õ��ĺ���
	*/
	public  String RmbToHan( double num )
	{
		//String str;
		String[] tmp = new String[2];
		tmp = divide( num );
		String str = toHan( tmp );
		return str;
	}
	
	public static void main( String[] args )
	{
		Scanner scn = new Scanner( System.in );
		System.out.print("��������Ҫת��������: " );
		double a = scn.nextDouble();
		
		Rmb2Han rh = new Rmb2Han();
		
		String b = rh.RmbToHan( a );
		System.out.println( b );
		
	} // end of main
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	