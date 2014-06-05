import java.util.Arrays;
import java.util.Scanner;
/**
* 用来把double型的人民币转化为大写汉字字符串
* 小数部分有待解决
* 2014/01/03
*/

public class Rmb2Han
{
	private final String[] numArr = { "零", "壹", "贰", "叁", "肆", "伍",
								"陆", "柒", "捌", "玖" };
	private final String[] unitArr = { "厘", "分", "角" ,"", "拾","佰", "仟" , "万", "亿" };
	
	/**
	* 用于把整数部分和小数部分分开
	* @param num需要被分解的浮点数
	* @return 分解出来的整数部分和小数部分。第一个数组元素是整数部分，第二个数组元素是小数部分
	*/
	private String[] divide( double num )
	{
		//将一个浮点数强制转化取整，即得到整数部分
		long zheng = (long)num;
		//double减去整数部分，然后乘以1000，即得到小数点后面3位数字（采用四舍五入）
		String dou = num - zheng + "";
		//long xiao = Math.round( (num - zheng) * 1000 ); //Math.round()小数点后面的数字四舍五入
		String xiao = dou.substring( 0, 3 );
		//两种把整数转化为字符串的方法，还有Integer.toString(i)最有效率
		String[] tmp = new String[2];
		tmp[0] = zheng + "";
		tmp[1] = xiao;
		return tmp;
	} // end of function: divide
	
	/**
	* 将分离得到的整数部分和小数部分分别转化为汉字
	* @param numStr是String数组类型的形参
	* @return 返回得到的汉字字符串
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
		    result += intConverter( str1 ) + "万" + intConverter( str2 );
		}
		else if ( intlen <= 12 )
		{
			String str1 = intNum.substring( 0, intlen - 8 );
			String str2 = intNum.substring( intlen - 8, intlen - 4 );
			String str3 = intNum.substring( intlen - 4, intlen );
			result += intConverter( str1 ) + "亿" + intConverter( str2 ) 
						+ "万" + intConverter( str3 );
		
		}
		else 
		{
			System.out.println("输入的数字太大，整数部分不应该长于12位！" );
			return "";
		}
		
		//result += "元整" + douConverter( douNum );
		result += "元整";
		
		return result;
	}
	
	/**
	*用于转换整数部分，把一个四位整数转化为大写汉字
	* @param numStr四位整数字符串
	* @return 转后后的大写汉字字符串
	*/
	private String intConverter( String numStr )
	{
		String result = "";
		int numlen = numStr.length();
		//遍历数字字符串的每个字符
		for( int i = 0; i < numlen; i++ )
		{
			//char与int之间，在ASCII中相差48
			//因此把char型减去48得到int数字
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
	* 用来转换小数部分得到角，分，厘
	* @param numStr是String类型的形参
	* @return 返回小数部分转化后的汉字
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
		//判断小数部分是否存在，若不存在，直接返回
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
	* 对外提供的接口
	* @param num是double型的形参
	* @return  返回转换得到的汉字
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
		System.out.print("请输入你要转化的数字: " );
		double a = scn.nextDouble();
		
		Rmb2Han rh = new Rmb2Han();
		
		String b = rh.RmbToHan( a );
		System.out.println( b );
		
	} // end of main
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	