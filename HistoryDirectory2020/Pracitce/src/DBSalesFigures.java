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
		//��¼�м�����¼
		int tmp = saleList.size();
		//������һ��
		System.out.print(" \t" + "Sum\t" + "Avg\t");
		for( int i = 0; i < tmp; i++ )
		{
			System.out.print(saleList.get(i).getMonth() + "\t" );
		}
		System.out.println();
		//��������ÿһ�е�����
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
