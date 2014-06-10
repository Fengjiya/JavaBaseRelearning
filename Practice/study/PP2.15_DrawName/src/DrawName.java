/*
 * @version: 2012.12.1
 * @author: Baicai
 * 
 * To draw your name in a Web browser.
 * 
 */

import javax.swing.JApplet;
import java.awt.*;

public class DrawName  extends JApplet
{
	//------------------------------------------
	//  Draw your name.
	//------------------------------------------
	public void paint(Graphics page)
	{
		setBackground(Color.lightGray);
		
		page.setColor(Color.black);
		page.drawString("Fengjiya", 50, 50);
		
	}

}
