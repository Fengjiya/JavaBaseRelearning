public abstract class SpeedMeter
{
	private double turnRate;
	public SpeedMeter()
	{
	}
	
	public abstract double getRadius();
	//把返回车轮半径的方法定义为抽象方法
	public void setTurnRate( double turnRate )
	{
		this.turnRate = turnRate;
	}
	
	//定义计算速度的通用方法
	public double getSpeed()
	{
		return java.lang.Math.PI * 2 * getRadius() * turnRate;
	}
	
}