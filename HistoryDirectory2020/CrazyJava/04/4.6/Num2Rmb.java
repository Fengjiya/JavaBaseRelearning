import java.util.Arrays;  
import java.util.Scanner;

public class Num2Rmb
{
	private String[] hanArr = { "零", "壹", "贰", "叁", "肆", "伍",
								"陆", "柒", "捌", "玖" };
	private String[] unitArr = { "", "拾","佰", "仟" };
	
	/**
	* 用于把整数部分和小数部分分开
	* @param num需要被分解的浮点数
	* @return 分解出来的整数部分和小数部分。第一个数组元素是整数部分，第二个数组元素是小数部分
	*/
	private String[] divide( double num )
	{
		//将一个浮点数强制转化取整，即得到整数部分
		long zheng = (long)num;
		//double减去整数部分，然后乘以100，即得到小数点后面2位数字（采用四舍五入）
		long xiao = Math.round( (num - zheng) * 100 ); //Math.round()小数点后面的数字四舍五入
		//两种把整数转化为字符串的方法，还有Integer.toString(i)最有效率
		return new String[] { zheng + "", String.valueOf( xiao) };
	} // end of function: divide
	
	/**
	*用于把一个四位整数转化为大写汉字
	* @param numStr四位整数字符串
	* @return 转后后的大写汉字字符串
	*/
	private String toHanStr( String numStr )
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
			result += hanArr[num] + unitArr[ numlen - i -1 ];
		} // end of for
		
		return result;
	}  // end of function: toHanStr
	
	public static void main( String[] args )
	{
		Scanner scn = new Scanner( System.in );
		Num2Rmb nr = new Num2Rmb();
		
		System.out.println( "输入要分解的double数和四位整数：" );
		System.out.print( "分解数:" );
		double db = scn.nextDouble();
		System.out.print( "四位整数: " );
		String str = scn.next();
		
		
		//测试把一个浮点数分解为整数部分和小数部分的功能
		System.out.println( Arrays.toString( nr.divide( db ) ) );
		//测试把四位整数转化为汉字字符串
		System.out.println( str+ "= " + nr.toHanStr( str ) );
	} // end of main
	
} // end of class: Num2Rmb
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			