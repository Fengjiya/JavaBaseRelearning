import java.lang.String;



public class Car 
{
	private double[] speed = new double[20];
	private double acce;                       //���ٶ� acceleration
	private int speed_num;                     //ÿ�����ٶȵ�ĸ���
	public String license;                     //���ƺ�
	
	//��ʼ��car�ļ�������
	public Car (String a, double[] str,int c)
	{
		license = a;
		speed_num = c;
		
		for( int i = 0; i < speed_num   ; i++)
		{
			speed[i] = str[i];
		}
		
		acce = SetAcce();
		
	}
	
	
	//����speed[]���������ٶ�acce
	private double SetAcce()
	{
		
		double acc_temp = -200;
		if ( speed_num == 1 ) return 0;
		else 
		{
			acc_temp = speed[1] - speed[0];
			for (int i = speed_num - 1; i > 0; i--)
			{
				if ((speed[i] - speed[i-1]) >= acc_temp)
					acc_temp = speed[i] - speed[i-1];
			}
		}
		
		return acc_temp;
	}
	
	
	//�ж�ÿ�����Ƿ���
	public boolean IsOverSpeed( double v_max, double v_min)
	{
		if (speed[speed_num -1] >= v_max )
			return true;
		else return false;
		
	}
	
	//�ж��Ƿ�Ҫ����
	public boolean WillOverSpeed(double v_max, double v_min)
	{
		if (speed[speed_num -1] >= v_min && speed[speed_num -1] < v_max)
			return true;
		else if( speed[speed_num -1 ] < v_min &&speed[speed_num - 1]  +  acce >= v_min )
			return true;
		else return false;
	}
	
	//���¼���ÿ�����������ٶ�
	public void reSetAcce(double sp)               //sp��ָ�Ѿ����ڵĳ����������ݺ������һ���ٶȵ�
	{
		double acce_temp = 0;
		acce_temp = sp - speed[speed_num -1];
		if ( acce_temp > acce )
			acce = acce_temp;		
	}
	
	//����ÿ���������һ���ٶ�ֵ����speed[speed_num -1]
	public void reSetCar(double sp)
	{
		speed[ speed_num-2] = speed[ speed_num -1];
		speed[ speed_num -1] = sp;
	}
	
	//����ÿ�����ĳ��ƺ�
	public String getLicense()
	{
		return license;
	}
	
	//�����ٶȸ���
	public int getSpeed_num()
	{
		return speed_num;
		
	}
	
	//�����ٶ�����
	public double[] getSpeed()
	{
		return speed;
	}
	
	//����ٶ�����
	public void printSpeed()
	{
		for ( int i = 0; i < speed_num ; i++)
		{
			System.out.print(speed[i] + " ");
		}
		System.out.println();
	}
	
	//���ؼ��ٶ�
	public double getAcce()
	{
		return acce;
	}
}
