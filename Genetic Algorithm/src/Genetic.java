import java.util.*;

public class Genetic
{
	private static double PI = 3.141592653589;
	private static double PM = 0.0001;
	private static int maxGen = 300;
	private static double bestDis  = 0.25;  //最佳最短距离
	
	private Point bestone;
	
	public Genetic()
	{
		
	}
	
	//生成初始群体,[x,y],表示初始群体的数目
	public void PopulationGeneration( double x, double y,int b, List<Point> set)
	{
		//生成区间[x,y]类均匀分布的初始群体
		for ( int m = 0; m < b; m++)
		{
			Point tmp = new Point( x + (m+1)*(y-x)/(b+1) );
			set.add(tmp);
			//System.out.println("   " + set.get(m).get_val() );
		}
		
		FitnessCal( set );
		ChanceCal( set );
		
		/*
		//把个体按照适应度的降序排列，并选择出最优个体
		for( int i = 0; i < set.size(); i++)
		{
			for ( int m = set.size() - 1; m > i; m--)
			{
				Point tmp = null;
				if( set.get(i).get_adapter() < set.get(m).get_adapter( ))
				{
					tmp = set.get(i);
					set.set(i, set.get(m));
					set.set(m, tmp);
				}
			}
		}*/
		descendingSort(set);  //实现的就是上面的降序排列的功能
		
		bestone = set.get(0);
		
		for ( int m = 0; m < b; m++)
		{
			//System.out.println(set.get(m).get_val() + " " + set.get(m).get_binary() );
		}
	}
	
	//适应度计算函数
	public void FitnessCal( List<Point> set )
	{
		double tmp;
		for ( int i = 0; i < set.size(); i++)
		{
			tmp = set.get(i).get_val();
			tmp = tmp * PI / 180.0;
			set.get(i).set_adapter( tmp*Math.sin(10*PI*tmp)+2.0 );
		}
	}
	
	/*
	//选定适应度最高的个体:把所有个体按照适应度降序排列，那么第一个就是最优个体
	private void ChooseBest( List<Point> set)
	{
		for( int i = 0; i < set.size(); i++)
		{
			for ( int y = set.size() - 1; y > i; y--)
			{
				Point tmp = null;
				if( set.get(i).get_adapter() < set.get(i).get_adapter( ))
				{
					tmp = set.get(i);
					set.set(i, set.get(y));
					set.set(y, tmp);
				}
			}
		}
		
		bestone = set.get(0);
		
	}*/
	
	//计算每个个体被选中的概率
	public void ChanceCal( List<Point> set )
	{
		double tmp = 0;
		for ( int i = 0; i < set.size(); i++)
		{
			tmp += set.get(i).get_adapter();
		}
		
		for ( int i = 0; i < set.size(); ++i )
		{
			set.get(i).set_pro(set.get(i).get_adapter()/tmp);
			//System.out.print(set.get(i).get_pro() + " i=" + i + "  ");
		}
	}
	
	//用轮盘法来随机选择个体对象,生产配对池
	public void Roulette( List<Point> set )
	{
		int[] order = new int[set.size()];  //保存产生的随机数列
		double tmp = 0;
		Random rd = new Random();
		for( int i = 0; i < set.size(); i++)
		{
			
			tmp = rd.nextDouble();  //随机小数
			double pro_total = 0;
			for ( int m = 0; m < set.size(); m ++)
			{
				pro_total = pro_total + set.get(m).get_pro();
				//System.out.print("pro_total=" + pro_total+"  tmp= " + tmp+"  " );
				if ( pro_total >= tmp ) 
				{
					order[i] = m;
					break;
				}//end of if
			}//end of for
		}//end of for
		
		//将选择序列选择出来后，从set中拿出对应的点赋给list2，然后把set赋值为list2
		List<Point> list2 = new ArrayList<Point>();
		for ( int i = 0; i < set.size(); i++ )
		{
			list2.set(i, set.get( order[i] ));
		}
		set = list2;
		descendingSort(set);  //保持set的降序排列
		
	}
	
	//排序算法，用来对数组降序排列
	private void descendingSort( List<Point> set )
	{
		for( int i = 0; i < set.size(); i++ )
		{
			for ( int m = set.size() - 1; m > i; m--)
			{
				Point tmp = null;
				if( set.get(i).get_adapter() < set.get(i).get_adapter() )
				{
					tmp = set.get(i);
					set.set(i, set.get(i));
					set.set(i, tmp);
				}
			}
		}
	}
	
	//计算平均适应度
	private double averFitness( List<Point> set )
	{
		double tmp = 0;
		for ( int i = 0; i < set.size(); i++)
		{
			tmp += set.get(i).get_adapter();
		}
		
		return tmp / set.size();
	}
	
	//判断算法是否停止
	public boolean genStop( List<Point> set)
	{
		double tmp = averFitness(set);
		if( bestone.get_exitTime() >= 6 && (bestone.get_adapter()-tmp) / bestone.get_adapter() <= bestDis )
			return true;
		else return false;
	}
	
	//杂交算法
	public void crossBreed( List<Point> set )
	{
		Random rd = new Random();
		List<Point> list2 = new ArrayList<Point>();
		int rdtmp = -1;
		for( int i = 0; i < set.size(); i++ )
		{
			do
			{
				rdtmp = rd.nextInt();
			} while( rdtmp == i ); //避免和自交（和自身杂交）
			
			for ( int m = 0; m < 7; m++ )
			{
				int[] tmp1 = set.get(i).get_binary();
				int[] tmp2 = set.get(rdtmp).get_binary();
				tmp1[m] = tmp2[m];  //交行染色体的第一个基因
				tmp1[ 21 - m ] = tmp2[ 21 - m ];  //交换染色体的最后一个基因
				
				Point tmp3 = new Point( set.get(i).set_binary( tmp1 ) );
				list2.add( tmp3 );  //根据改变的小数部分的值来添加新的点，然后添加到list2
			} //end of for  main
		}  // end of for i
		set = list2;
	}  //end of crossBreed

	//变异算法
	public void mutate( List<Point> set )
	{
		Random rd1 = new Random();
		for( int i = 0; i < 4; i++ )
		{
			int tmp;
			tmp = Math.abs( rd1.nextInt()) % 30;
			int[] tmp2 = set.get(tmp).get_binary();
			int tmp3 = Math.abs( rd1.nextInt()) % 22;
			if( tmp2[tmp3] == 1 )
				tmp2[tmp3] = 0;
			else tmp2[tmp3] = 1;
			
			Point tmp4 = new Point( set.get(tmp).set_binary(tmp2));  //把变异后的值代替原来的值
			set.set(i, tmp4);
		}  //end of for
		
	descendingSort(set);
	bestone.add_exitTime();
	} // end of mutate
	
	public void geneticPrint()
	{
		bestone.pointPrint();
	}
	
}
