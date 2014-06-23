import java.util.Scanner;

public class SalesFigures
{
	private String[]  MONTHS = {"Feb", "April", "June", "Aug", "Oct", "Dec"};
	private double[][] monthly_Sales = new double[MONTHS.length][];
	private double[][] sum_Avg = new double[MONTHS.length][2];
	private int months;
	
	//初始化每个月销售额的数组
	public void init()
	{
		months = 0;
		System.out.println("请输入要统计的月份数（请输入偶数）：" );
		Scanner scan = new Scanner( System.in );
		months = scan.nextInt();
		while( (months <=0) || (months % 2 != 0) )
		{
			System.out.println("请重新输入大于零的偶数: ");
			months = scan.nextInt();
		}
	
		System.out.println("请输入前" + (months/2) + "次的每次销售额" );
		double[] sale = new double[months/2];
		for(int k = 0; k < sale.length; k++)
		{
			sale[k] = scan.nextDouble();
		}
		for( double sales: sale )
			System.out.print( sales + " " );
		
		for( int i = 0; i < sale.length; i++)
			for( int j = 0; j < i; j++)
				monthly_Sales[i][j] = sale[j];
				
		/*for( double[] sales: monthly_Sales )
			System.out.print( sales + " " );*/
	}
	
	//计算总销售额和平均销售额
	public void computer_sum_Avg()
	{
		
	}
	
	//输出销售总表格
	public void output_Figures()
	{
		
	}
	
	public static void main(String[] args)
	{
		new SalesFigures().init();
	}
	
}