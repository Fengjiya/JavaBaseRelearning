import java.awt.*;

public class PanelTest
{
	public static void main( String[] args )
	{
		Frame f = new Frame("���Դ���");
		
		Panel p = new Panel();
		p.add( new TextField( 20 ) );
		p.add( new Button( "������" ) );
		
		f.add( p );
		f.setBounds( 30, 30, 250,200 );
		f.setVisible( true );
	}
}