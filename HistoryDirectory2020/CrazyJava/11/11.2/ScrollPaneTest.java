import java.awt.*;

public class ScrollPaneTest
{
	public static void main( String[] args )
	{
		Frame f = new Frame("���Դ���");
		
		ScrollPane sp = new ScrollPane( ScrollPane.SCROLLBARS_ALWAYS );
		sp.add( new TextField( 20 ) );
		sp.add( new Button( "������" ) );
		
		f.add( sp );
		f.setBounds( 30, 30, 250, 120 );
		f.setVisible( true );
	}
}