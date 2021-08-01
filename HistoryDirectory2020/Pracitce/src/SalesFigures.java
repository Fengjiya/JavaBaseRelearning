import java.util.Scanner;
import java.math.BigDecimal;

public class SalesFigures
{
	static final String[] MONTHS = {"Feb", "Apr", "June", "Aug", "Oct", "Dec"};
	
	public static void main(String[] args)
	{
		int month;
		double sale;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input the month now: ");
		month = scan.nextInt();
		
		double[] sales = new double[month/2];
		
		for( int i = 0; i < month / 2; i++ )
		{
			System.out.println("Input the sale of " + MONTHS[i] + " : ");
			sale = scan.nextDouble();
			sales[i] = sale;
		}

		generateTable(sales);
		

	}
	
	public static void generateTable(double[] sales )
	{
		//记录有几条记录
		int tmp = sales.length;
		//产生第一行
		System.out.print("\tSum\tAvg\t");
		for( int i = 0; i < tmp; i++ )
		{
			System.out.print(MONTHS[i] + "\t" );
		}
		System.out.println();
		//产生下面每一行的数据
		for( int j = 0; j < tmp; j++ )
		{
			System.out.print(MONTHS[j] + "\t");
			System.out.print(Sum(sales, j) + "\t");
			System.out.print(Avg(sales, j) + "\t");
			for( int k = 0; k <= j; k++ )
			{
				System.out.print(sales[k] + "\t");
			}
			
			System.out.println();
		}
	}
	
	public static double Sum( double[] sales, int n )
	{
		double tmp = 0;
		for ( int i = 0; i <= n ; i++ )
		{
			tmp += sales[i];
		}
		
		return tmp;
	}
	
	public static double Avg( double[] sales, int n )
	{
		BigDecimal bd = new BigDecimal( Sum(sales, n) / (n+1) );
		//Format the Avg to be '#.00'
		return  bd.setScale( 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	

}
