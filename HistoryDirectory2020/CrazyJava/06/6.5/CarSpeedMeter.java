public class CarSpeedMeter extends SpeedMeter
{
	public double getRadius()
	{
		return 0.28;
	}
	
	public static void main( String[] args )
	{
		CarSpeedMeter csm = new CarSpeedMeter();
		csm.setTurnRate( 15 );
		System.out.println( csm.getSpeed() );
	}
	
}