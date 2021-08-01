import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import java.awt.event.*;

public class CardLayoutTest
{
	Frame f = new Frame( "���Դ���" );
	String[] names = { "��һ��", "�ڶ���", "������", "������", "������" };
	Panel pl = new Panel();
	 
	public void init()
	{
		final CardLayout c = new CardLayout();
		pl.setLayout( c );
		
		for ( int i = 0; i < names.length; i++ )
		{
			pl.add( names[i], new Button( names[i] ) );
		}
		
		Panel p = new Panel();
		
		//������ʾ��һ�ŵİ�ť
		Button previous = new Button( "��һ��" );
		previous.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				c.previous( pl );
			}
		} );
		
		//������ʾ��һ�ŵİ�ť
		Button next = new Button( "��һ��" );
		next.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				c.next( pl );
			}
		} );
		
		//������ʾ��һ�ŵİ�ť
		Button first = new Button( "��һ��" );
		first.addActionListener( new ActionListener()
		{
			public void actionPerformed ( ActionEvent e)
			{
				c.first( pl );
			}
		} );
		
		//������ʾ���һ�ŵİ�ť
		Button last = new Button( "���һ��" );
		last.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				c.last( pl );
			}
		} );
		
		//���Ƹ���Card����ʾ�İ�ť
		Button third = new Button( "������" );
		third.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				c.show( pl, "������" );
			}
		} );
		
		p.add( previous );
		p.add( next );
		p.add( first );
		p.add( last );
		p.add( third );
		f.add( pl );
		f.add( p, BorderLayout.SOUTH );
		
		//���������ӹرյļ�����
		f.addWindowListener( new WindowAdapter()
		{
			public void windowClosing( WindowEvent e )
			{
				System.out.println("���Դ��ڹر�");
				System.exit( 0 );
			}
		});
		
		f.pack();
		f.setVisible( true );
	}  // end of init()
	
	public static void main( String[] args )
	{
		new CardLayoutTest().init();
	}
}