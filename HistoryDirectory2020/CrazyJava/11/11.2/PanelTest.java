import java.awt.*;

public class PanelTest
{
	public static void main( String[] args )
	{
		Frame f = new Frame("²âÊÔ´°¿Ú");
		
		Panel p = new Panel();
		p.add( new TextField( 20 ) );
		p.add( new Button( "µ¥»÷ÎÒ" ) );
		
		f.add( p );
		f.setBounds( 30, 30, 250,200 );
		f.setVisible( true );
	}
}