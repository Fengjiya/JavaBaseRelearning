/*
 * @version: 2012.12.7
 * @arthor: Baicai
 * 
 * To display your name and the shadow beside it.
 * 
 */

import javax.swing.JApplet;
import java.awt.*;

public class ShadowName extends JApplet
{
	public void paint(Graphics page)
	{
		
		setBackground(Color.yellow);
		 
		
		//To draw your name.
		page.setColor(Color.black);
		page.drawString("Mr Cai", 50, 50);
		
		//To draw the shadow.
		page.setColor(Color.lightGray);
		page.drawString("Mr Cai", 52, 49);
		
		
		

	    
	}

}
