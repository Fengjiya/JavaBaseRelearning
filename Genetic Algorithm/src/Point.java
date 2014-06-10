import java.lang.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Point
{
	private double val;       //改点的十进制的值
	private int[] binary = new int[22];    //小数点部分的二进制编码，共22位，要求精确到小数点后6位
	private double pro;        //概率，probability
	private int exitTime;
	private double adapter;
	private static double piece = 3 / (Math.pow(2, 22)-1);
	
	public Point( double a )
	{
		val = a;
		System.out.print(" ## " + val);
		FloatToBinary( val - (int)val );  //val-int(val)提取的是val的小数点部分，将此小数点部分转化为二进制字符串
		exitTime = 1;  //某个个体产生时，那么就是它存在的第一代
		adapter = 0;
	}
	
	//把小数位转化为二进制编码
	private void FloatToBinary( double b)
	{
		double tmp = 0;
		b = Math.abs( b-(int)b ); //去掉b的整数部分，防止|b|>=1;
		//将小数点部分转化为22位的二进制字符串
		for ( int i = 0; i < 22; i++)
		{
			tmp = b * 2;
			binary[i] = (int)tmp;
			b = tmp - (int)tmp;
		}
		
		for ( int i = 0; i < 22; i++)
		{
			//System.out.print(binary[i] + " ");
		}
	}
	
	//把二进制编码转化为小数
	public double binaryToFloat( int[] bin )
	{
		int tmp = 0;
		for ( int i = 0; i < 22; i++)
		{
			tmp = ( tmp + bin[i] ) * 2;
		}
		return tmp * piece;
	}
	
	public void set_val(double a)
	{
		val = a;
	}
	
	public double get_val()
	{
		return val;
	}
	
	public void set_pro(double pro)
	{
		this.pro = pro;
	}
	
	public double get_pro()
	{
		return pro;
	}
	
	public int[] get_binary()
	{
		return binary;
	}
	
	public double set_binary( int[] tmp )
	{
		binary = tmp;
		double tmpDou = 0;
		double tmpVal = (int)val;
		for( int i = 0; i< 22; i++)
		{
			tmpDou = ( tmpDou + tmp[i]) * piece;
		}
		tmpVal = tmpVal + tmpDou;
		return tmpVal;
		
	}
	
	public void add_exitTime()
	{
		exitTime++;
	}
	
	public int get_exitTime()
	{
		return exitTime;
	}
	
	public void set_adapter(double adapter)
	{
		this.adapter = adapter;
	}
	
	public double get_adapter()
	{
		return adapter;
	}
	
	public void pointPrint()
	{
		 DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
		 df.setMaximumFractionDigits(6);
		System.out.println("最佳个体:" + df.format(val) + "/n小数部位二进制编码:" + binary +
				"/n 存在代数:" + exitTime);
	}

}
