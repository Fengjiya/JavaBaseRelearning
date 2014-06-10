import java.util.*;
import java.net.*;
import java.io.*;  
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.Calendar;
import java.sql.*;

public class Car_Calculate
{
	static final int NUM = 6;     //定义每个速度组的车牌号和最多速度点数目，与Car类中的speed成员和License成员对应
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		List<String[]> QueryList = new ArrayList<String[]>();   //QueryList就是从数据库给的数组集合
		List<Car> CarList = new ArrayList<Car>();      			//创建的汽车集合
		
		
		String[] str1 = {"A-34001","42","45","44","40","48"};
		String[] str2 = {"A-34002","58","55","50","45","49"};
		String[] str3 = {"A-34003","30","32","20","40","42"};
		String[] str4 = {"A-34004","55","56","50","52","60"};
		
		QueryList.add( str1 );
		QueryList.add( str2 );
		QueryList.add( str3 );
		QueryList.add( str4 );
		
	   
		
		
		
		//从QueryList中读取每辆车的信息并将之添加到CarList中
		int counter;
		for(int i = 0; i < QueryList.size(); ++i)
		{
			
			counter = 0;
			double[] speed_temp = new double[NUM - 1];               //建立一个速度数组，用来存放每个QueryList元素数组中的所有速度
			for ( int j = 1; j < (QueryList.get(i)).length; j++ )
			{
				
				if( QueryList.get(i)[j] != null )
				{
					speed_temp[j-1] = Integer.parseInt( (QueryList.get(i))[j] );
					//System.out.print(speed_temp[j-1] + " ");
				}
				else continue;
				counter ++;
			}
			//j = QueryList.get(i).length - 1;       最开始没有考虑null值的时候直接按照长度来算速度点个数的，是错误的方法，以此警示
			
			CarList.add( new Car( QueryList.get(i)[0] , speed_temp, counter) ); //每次从QueryList中读取一个元素，建立一个Car对象，并将之添加到CarList集合中
			                                                                //(QueryList.get(i))[0]表示的是String类型的车牌号
			
		}
		
		
		/*
		//测试上述程序部分是否正确
		for (int k = 0 ; k < CarList.size(); ++k )
		{
			System.out.print("车牌号：" +CarList.get(k).getLicense() + " 速度： ");
			CarList.get(k).printSpeed();
			//System.out.println("加速度: " + CarList.get(k).getAcce());
		}
		*/
		
		ArrayList<String> OverSpeedCar = new ArrayList<String>();          //用来存放已超速的车牌号，将之作为数据控制中心的访问接口
		ArrayList<String> WillOverSpeedCar = new ArrayList<String>();      //用来存放将要超速的车牌号
		
		final double speedMAX = 60;                 //超速的上限
		final double speedMIN = speedMAX - 5;       //达到speedMIN即为要将要超速，需要预警
		
		for ( int k = 0; k < CarList.size(); k++)
		{
			if( CarList.get(k).IsOverSpeed(speedMAX, speedMIN))
			{
				
				OverSpeedCar.add( CarList.get(k).getLicense());
				System.out.println("Car: " + CarList.get(k).getLicense() + " is over speed!!!");
				
				/*
				BufferedOutputStream os = null;
				String CarNum = CarList.get(k).getLicense();
				
				String IP_addr;//"59.69.75.104"
				if ((CarNum.compareTo("A-34010")) < 0)
				{
					IP_addr="192.168.34.10";//"59.69.75.104"
				}
				else
				{
					IP_addr="192.168.34.59";//"59.69.75.104"
				}
				
				try {
    				Socket socket=new Socket(IP_addr,2111);
    				socket.setSoTimeout(60000); 
    				os=new BufferedOutputStream(socket.getOutputStream());
    				
    				Date now = new Date();
    				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    				String hehe = dateFormat.format( now );
    				String sent;
    				sent= hehe + " " + CarList.get(k).getLicense() +":  已超速！" ;
    				
    				os.write(sent.getBytes());
    				os.flush();
    				socket.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				System.out.println("Exception:" + IP_addr+"连接失败！"); 
    			}finally{
    				try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}*/
			}
			else if ( (CarList.get(k)).WillOverSpeed(speedMAX,speedMIN) )
			{
				WillOverSpeedCar.add(CarList.get(k).getLicense());
				System.out.println("Car: " + CarList.get(k).getLicense() + " will over speed!");
				
				/*
				BufferedOutputStream os = null;
				String CarNum = CarList.get(k).getLicense();
				
				String IP_addr;//"59.69.75.104"
				if ((CarNum.compareTo("A-34010")) < 0)
				{
					IP_addr="192.168.34.59";//"59.69.75.104"
				}
				else
				{
					IP_addr="192.168.34.10";//"59.69.75.104"
				}
				
				try {
    				Socket socket=new Socket(IP_addr,2111);
    				socket.setSoTimeout(60000); 
    				os=new BufferedOutputStream(socket.getOutputStream());
    				
    				Date now = new Date();
    				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    				String hehe = dateFormat.format( now );
    				String sent;
    				sent= hehe + " " + CarList.get(k).getLicense() +":  将超速！" ;
    				
    				os.write(sent.getBytes());
    				os.flush();
    				socket.close();
    			} 
    			catch (IOException e) 
    			{
    				// TODO Auto-generated catch block
    				System.out.println("Exception:" + IP_addr+"连接失败！"); 
    			}
    			finally
    			{
    				try 
    				{
						os.close();
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}*/
			}
		}
		
			 //创建并连接数据库的语句
			CreateDB db1 = new CreateDB( QueryList, OverSpeedCar, WillOverSpeedCar ); //将所有车辆的速度信息都存放在carinfo表中
		//可以输出超速车牌号OverSpeedCar和将要超速的车牌号WillOverSpeedCar
		
	}
}
