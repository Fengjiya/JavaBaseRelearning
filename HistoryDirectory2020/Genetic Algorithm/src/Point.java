import java.lang.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Point
{
	private double val;       //�ĵ��ʮ���Ƶ�ֵ
	private int[] binary = new int[22];    //С���㲿�ֵĶ����Ʊ��룬��22λ��Ҫ��ȷ��С�����6λ
	private double pro;        //���ʣ�probability
	private int exitTime;
	private double adapter;
	private static double piece = 3 / (Math.pow(2, 22)-1);
	
	public Point( double a )
	{
		val = a;
		System.out.print(" ## " + val);
		FloatToBinary( val - (int)val );  //val-int(val)��ȡ����val��С���㲿�֣�����С���㲿��ת��Ϊ�������ַ���
		exitTime = 1;  //ĳ���������ʱ����ô���������ڵĵ�һ��
		adapter = 0;
	}
	
	//��С��λת��Ϊ�����Ʊ���
	private void FloatToBinary( double b)
	{
		double tmp = 0;
		b = Math.abs( b-(int)b ); //ȥ��b���������֣���ֹ|b|>=1;
		//��С���㲿��ת��Ϊ22λ�Ķ������ַ���
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
	
	//�Ѷ����Ʊ���ת��ΪС��
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
		System.out.println("��Ѹ���:" + df.format(val) + "/nС����λ�����Ʊ���:" + binary +
				"/n ���ڴ���:" + exitTime);
	}

}
