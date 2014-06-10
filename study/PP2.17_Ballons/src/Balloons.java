/*
 * @version: 2012.12.1
 * author: Baicai
 * 
 * Draw several balloons tied together.
 * 
 */

import javax.swing.JApplet;
import java.awt.*;

public class Balloons extends JApplet
{
	public void paint(Graphics page)
	{
		/*   This is my program
		// Draw the lines
		page.setColor(Color.black);
		page.drawLine(350, 350, 55, 55);
		page.drawLine(350, 350, 300, 185);
		page.drawLine(350, 350, 402, 220);
		page.drawLine(350, 350, 540, 300);
		
		// Draw the balloons
		page.setColor(Color.yellow);
		page.fillOval(35, 35, 30, 30);
		page.setColor(Color.red);
		page.fillOval(285, 170, 30, 30);
		page.setColor(Color.green);
		page.fillOval(385, 205, 30, 30);
		page.setColor(Color.blue);
		page.fillOval(525, 285, 30, 30);
		*/
		
		
		// This is the program given.
		 setBackground (Color.white);

	      // draw the strings
	      page.setColor (Color.black);
	      page.drawLine (45, 95, 100, 300);
	      page.drawLine (90, 100, 100, 300);
	      page.drawLine (60, 100, 100, 300);
	      page.drawLine (122, 85, 100, 300);
	      page.drawLine (145, 115, 100, 300);

	      // draw the balloons
	      page.setColor (Color.blue);
	      page.fillOval (20, 30, 50, 65);
	      page.setColor (Color.yellow);
	      page.fillOval (70, 40, 40, 60);
	      page.setColor (Color.red);
	      page.fillOval (40, 50, 40, 55);
	      page.setColor (Color.green);
	      page.fillOval (100, 30, 45, 55);
	      page.setColor (Color.cyan);
	      page.fillOval (120, 55, 50, 60);
	}

}
