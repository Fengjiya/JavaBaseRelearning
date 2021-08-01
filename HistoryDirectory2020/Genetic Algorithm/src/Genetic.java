import java.util.*;

public class Genetic
{
	private static double PI = 3.141592653589;
	private static double PM = 0.0001;
	private static int maxGen = 300;
	private static double bestDis  = 0.25;  //�����̾���
	
	private Point bestone;
	
	public Genetic()
	{
		
	}
	
	//���ɳ�ʼȺ��,[x,y],��ʾ��ʼȺ�����Ŀ
	public void PopulationGeneration( double x, double y,int b, List<Point> set)
	{
		//��������[x,y]����ȷֲ��ĳ�ʼȺ��
		for ( int m = 0; m < b; m++)
		{
			Point tmp = new Point( x + (m+1)*(y-x)/(b+1) );
			set.add(tmp);
			//System.out.println("   " + set.get(m).get_val() );
		}
		
		FitnessCal( set );
		ChanceCal( set );
		
		/*
		//�Ѹ��尴����Ӧ�ȵĽ������У���ѡ������Ÿ���
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
		descendingSort(set);  //ʵ�ֵľ�������Ľ������еĹ���
		
		bestone = set.get(0);
		
		for ( int m = 0; m < b; m++)
		{
			//System.out.println(set.get(m).get_val() + " " + set.get(m).get_binary() );
		}
	}
	
	//��Ӧ�ȼ��㺯��
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
	//ѡ����Ӧ����ߵĸ���:�����и��尴����Ӧ�Ƚ������У���ô��һ���������Ÿ���
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
	
	//����ÿ�����屻ѡ�еĸ���
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
	
	//�����̷������ѡ��������,������Գ�
	public void Roulette( List<Point> set )
	{
		int[] order = new int[set.size()];  //����������������
		double tmp = 0;
		Random rd = new Random();
		for( int i = 0; i < set.size(); i++)
		{
			
			tmp = rd.nextDouble();  //���С��
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
		
		//��ѡ������ѡ������󣬴�set���ó���Ӧ�ĵ㸳��list2��Ȼ���set��ֵΪlist2
		List<Point> list2 = new ArrayList<Point>();
		for ( int i = 0; i < set.size(); i++ )
		{
			list2.set(i, set.get( order[i] ));
		}
		set = list2;
		descendingSort(set);  //����set�Ľ�������
		
	}
	
	//�����㷨�����������齵������
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
	
	//����ƽ����Ӧ��
	private double averFitness( List<Point> set )
	{
		double tmp = 0;
		for ( int i = 0; i < set.size(); i++)
		{
			tmp += set.get(i).get_adapter();
		}
		
		return tmp / set.size();
	}
	
	//�ж��㷨�Ƿ�ֹͣ
	public boolean genStop( List<Point> set)
	{
		double tmp = averFitness(set);
		if( bestone.get_exitTime() >= 6 && (bestone.get_adapter()-tmp) / bestone.get_adapter() <= bestDis )
			return true;
		else return false;
	}
	
	//�ӽ��㷨
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
			} while( rdtmp == i ); //������Խ����������ӽ���
			
			for ( int m = 0; m < 7; m++ )
			{
				int[] tmp1 = set.get(i).get_binary();
				int[] tmp2 = set.get(rdtmp).get_binary();
				tmp1[m] = tmp2[m];  //����Ⱦɫ��ĵ�һ������
				tmp1[ 21 - m ] = tmp2[ 21 - m ];  //����Ⱦɫ������һ������
				
				Point tmp3 = new Point( set.get(i).set_binary( tmp1 ) );
				list2.add( tmp3 );  //���ݸı��С�����ֵ�ֵ������µĵ㣬Ȼ����ӵ�list2
			} //end of for  main
		}  // end of for i
		set = list2;
	}  //end of crossBreed

	//�����㷨
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
			
			Point tmp4 = new Point( set.get(tmp).set_binary(tmp2));  //�ѱ�����ֵ����ԭ����ֵ
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
