/*
 * @version: 2012.11.30
 * @author: Baicai
 * 
 * Demonstrates a basic applet.
 * 
 */

import javax.swing.JApplet;
import java.awt.*;

public class Einstein extends JApplet
{
	//-------------------------------------------------------------
	// Draws a quotation by Albert Einstein among some shapes.
	//-------------------------------------------------------------
	public void paint(Graphics page)
	{
		page.drawRect(50, 50, 40, 40);
		page.drawRect(60, 80, 200, 40);
		page.drawOval(75, 65, 20, 20);
		page.drawLine(30, 60, 80, 90);
		
		page.drawString("Out of clutter, find simplicity.", 110, 70);
		page.drawString("--Albert Einstein", 130, 100);
		
	}

}
