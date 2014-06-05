/*
 * @version: 2011.11.30
 * @author: Baicai
 * 
 * Demonstrates basic drawing methods and the use of color.
 * 
 */

import javax.swing.JApplet;
import java.awt.*;

public class Snowman extends JApplet
{
	//---------------------------------------------------------
	// Draws a snowman
	//---------------------------------------------------------
	public void paint(Graphics page)
	{
		final int MID = 100;
		final int TOP = 50;
		
		setBackground(Color.lightGray);
		
		page.setColor(Color.cyan);
		page.fillRect(0, 175, 300, 50);  //  ground
		
		page.setColor(Color.yellow);
		page.fillOval(-40, -40, 80, 80);   // the sun
		
		page.setColor(Color.white);
		page.fillOval(MID - 20, TOP, 40, 40); // the head
		page.fillOval(MID - 35, TOP + 35, 70, 50);  // upper torso
		page.fillOval(MID - 50, TOP + 80, 100, 60);  // lower torso
		
		page.setColor(Color.black);  
		page.fillOval(MID - 10, TOP + 10, 5, 5); // left eye
		page.fillOval(MID + 5, TOP + 10, 5, 5);  //right eye
		
		page.drawArc(MID - 7, TOP + 15, 15, 7, 190, 160);  // the mouse
	
		page.drawLine(MID - 20, TOP + 60, MID - 50, TOP + 45);  //  left arm
		page.drawLine(MID + 20, TOP + 60, MID + 55, TOP + 55);  // right arm
				
			
		page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);// brim of hat
		page.fillRect(MID - 15, TOP - 20, 30, 25);   // top of hat
		
	}

}
