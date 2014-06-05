import java.lang.String;



public class Car 
{
	private double[] speed = new double[20];
	private double acce;                       //加速度 acceleration
	private int speed_num;                     //每辆车速度点的个数
	public String license;                     //车牌号
	
	//初始化car的几个参数
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
	
	
	//根据speed[]数组计算加速度acce
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
	
	
	//判断每辆车是否超速
	public boolean IsOverSpeed( double v_max, double v_min)
	{
		if (speed[speed_num -1] >= v_max )
			return true;
		else return false;
		
	}
	
	//判断是否要超速
	public boolean WillOverSpeed(double v_max, double v_min)
	{
		if (speed[speed_num -1] >= v_min && speed[speed_num -1] < v_max)
			return true;
		else if( speed[speed_num -1 ] < v_min &&speed[speed_num - 1]  +  acce >= v_min )
			return true;
		else return false;
	}
	
	//重新计算每辆车的最大加速度
	public void reSetAcce(double sp)               //sp是指已经存在的车辆更新数据后的最新一个速度点
	{
		double acce_temp = 0;
		acce_temp = sp - speed[speed_num -1];
		if ( acce_temp > acce )
			acce = acce_temp;		
	}
	
	//重置每辆车的最后一个速度值，即speed[speed_num -1]
	public void reSetCar(double sp)
	{
		speed[ speed_num-2] = speed[ speed_num -1];
		speed[ speed_num -1] = sp;
	}
	
	//返回每辆车的车牌号
	public String getLicense()
	{
		return license;
	}
	
	//返回速度个数
	public int getSpeed_num()
	{
		return speed_num;
		
	}
	
	//返回速度数组
	public double[] getSpeed()
	{
		return speed;
	}
	
	//输出速度数组
	public void printSpeed()
	{
		for ( int i = 0; i < speed_num ; i++)
		{
			System.out.print(speed[i] + " ");
		}
		System.out.println();
	}
	
	//返回加速度
	public double getAcce()
	{
		return acce;
	}
}
