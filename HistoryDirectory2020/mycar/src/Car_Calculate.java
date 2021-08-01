import java.util.*;
//import java.net.*;
//import java.io.*;  
//import java.text.SimpleDateFormat;
//import java.util.Date; 
//import java.util.Calendar;
import java.sql.*;

public class Car_Calculate
{
	static final int NUM = 6;     //����ÿ���ٶ���ĳ��ƺź�����ٶȵ���Ŀ����Car���е�speed��Ա��License��Ա��Ӧ
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		List<String[]> QueryList = new ArrayList<String[]>();   //QueryList���Ǵ����ݿ�������鼯��
		List<Car> CarList = new ArrayList<Car>();      			//��������������
		
		
		String[] str1 = {"A-34001","42","45","44","40","48"};
		String[] str2 = {"A-34002","58","55","50","45","49"};
		String[] str3 = {"A-34003","30","32","20","40","42"};
		String[] str4 = {"A-34004","55","56","50","52","60"};
		
		QueryList.add( str1 );
		QueryList.add( str2 );
		QueryList.add( str3 );
		QueryList.add( str4 );
		
	    //�������ݿ�����
		CreateDB db = new CreateDB( QueryList );
		
		/*
		//�������ݿ�
		Connection conn =  JDBCTool.getConnection("jdbc:mysql://localhost:3306/Carinfo","root", "123456"); //�������ݿ�
		PreparedStatement ps = conn.prepareStatement("insert into carinfo2 values(?,?,?,?,?,?)");
		
		
		for ( int m = 0; m < QueryList.size(); ++m)
		{
			for( int j = 0; j < QueryList.get(m).length; j++)
			{
				if ( QueryList.get(m)[j] != null )
				{
					ps.setString(j+1, QueryList.get(m)[j] );
				}
				else continue;
			}
			ps.executeUpdate();       //�������ݣ�ȷ��ÿ���������ݱ����뵽���ݿ���
		}
		System.out.println("�ɹ�д�����ݿ�!");
		
		//�ͷŶ������ݿ������
		ps.close();              
		conn.close();
		*/
		
		//��QueryList�ж�ȡÿ��������Ϣ����֮��ӵ�CarList��
		int counter;
		for(int i = 0; i < QueryList.size(); ++i)
		{
			
			counter = 0;
			double[] speed_temp = new double[NUM - 1];               //����һ���ٶ����飬�������ÿ��QueryListԪ�������е������ٶ�
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
			//j = QueryList.get(i).length - 1;       �ʼû�п���nullֵ��ʱ��ֱ�Ӱ��ճ��������ٶȵ�����ģ��Ǵ���ķ������Դ˾�ʾ
			
			CarList.add( new Car( QueryList.get(i)[0] , speed_temp, counter) ); //ÿ�δ�QueryList�ж�ȡһ��Ԫ�أ�����һ��Car���󣬲���֮��ӵ�CarList������
			                                                                //(QueryList.get(i))[0]��ʾ����String���͵ĳ��ƺ�
			
		}
		
		
		/*
		//�����������򲿷��Ƿ���ȷ
		for (int k = 0 ; k < CarList.size(); ++k )
		{
			System.out.print("���ƺţ�" +CarList.get(k).getLicense() + " �ٶȣ� ");
			CarList.get(k).printSpeed();
			//System.out.println("���ٶ�: " + CarList.get(k).getAcce());
		}
		*/
		
		ArrayList<String> OverSpeedCar = new ArrayList<String>();          //��������ѳ��ٵĳ��ƺţ���֮��Ϊ���ݿ������ĵķ��ʽӿ�
		ArrayList<String> WillOverSpeedCar = new ArrayList<String>();      //������Ž�Ҫ���ٵĳ��ƺ�
		
		final double speedMAX = 60;                 //���ٵ�����
		final double speedMIN = speedMAX - 5;       //�ﵽspeedMIN��ΪҪ��Ҫ���٣���ҪԤ��
		
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
    				sent= hehe + " " + CarList.get(k).getLicense() +":  �ѳ��٣�" ;
    				
    				os.write(sent.getBytes());
    				os.flush();
    				socket.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				System.out.println("Exception:" + IP_addr+"����ʧ�ܣ�"); 
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
    				sent= hehe + " " + CarList.get(k).getLicense() +":  �����٣�" ;
    				
    				os.write(sent.getBytes());
    				os.flush();
    				socket.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				System.out.println("Exception:" + IP_addr+"����ʧ�ܣ�"); 
    			}finally{
    				try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}*/
			}
		}
		
		
		//����������ٳ��ƺ�OverSpeedCar�ͽ�Ҫ���ٵĳ��ƺ�WillOverSpeedCar
		
	}

}
