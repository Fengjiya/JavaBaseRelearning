import java.util.Scanner;
import java.util.ArrayList;

public class DBSalesFigures
{
	private ArrayList<MetaSale> saleList = new ArrayList<>();
	
	public DBSalesFigures( ArrayList<MetaSale> saleList )
	{
		this.saleList = saleList;
	}
	
	public  void generateTable( )
	{
		//记录有几条记录
		int tmp = saleList.size();
		//产生第一行
		System.out.print(" \t" + "Sum\t" + "Avg\t");
		for( int i = 0; i < tmp; i++ )
		{
			System.out.print(saleList.get(i).getMonth() + "\t" );
		}
		System.out.println();
		//产生下面每一行的数据
		for( int j = 0; j < tmp; j++ )
		{
			System.out.print(saleList.get(j).getMonth() + "\t");
			System.out.print(Sum() + "\t");
			System.out.print(Avg() + "\t");
			for( int k = 0; k <= j; k++ )
			{
				System.out.print(saleList.get(j).getSale() + "\t");
			}
			
			System.out.println();
		}
	}
	
	private  double Sum(  )
	{
		double tmp = 0;
		for ( int i = 0; i <= saleList.size() ; i++ )
		{
			tmp += saleList.get(i).getSale();
		}
		
		return tmp;
	}
	
	private  double Avg( )
	{
		return Sum() / saleList.size();
	}
	
	


}
