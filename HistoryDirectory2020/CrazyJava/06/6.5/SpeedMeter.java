public abstract class SpeedMeter
{
	private double turnRate;
	public SpeedMeter()
	{
	}
	
	public abstract double getRadius();
	//�ѷ��س��ְ뾶�ķ�������Ϊ���󷽷�
	public void setTurnRate( double turnRate )
	{
		this.turnRate = turnRate;
	}
	
	//��������ٶȵ�ͨ�÷���
	public double getSpeed()
	{
		return java.lang.Math.PI * 2 * getRadius() * turnRate;
	}
	
}