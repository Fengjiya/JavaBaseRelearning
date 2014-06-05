/*
 * @version: 2012.12.7
 * @author: Baicai
 * 
 * Draw the Olympic logo in five colors.
 * 
 */

import java.awt.*;
import javax.swing.JApplet;

public class OlympicRings extends JApplet
{
	public void paint(Graphics page)
	{
		final int BASEX = 1;
		final int BASEY = 1;
		final int DIAMETER = 60;
		
		setBackground(Color.lightGray);
		
		//the first blue ring.
		page.setColor(Color.blue);
		page.drawOval(BASEX, BASEY, DIAMETER, DIAMETER);
		
		//the second yellow ring.
		page.setColor(Color.yellow);
		page.drawOval(BASEX + 70, BASEY, DIAMETER, DIAMETER);
		
		//the third black ring.
		page.setColor(Color.black);
		page.drawOval(BASEX + 140, BASEY, DIAMETER, DIAMETER);
		
		//the forth green ring.
		page.setColor(Color.green);
		page.drawOval(BASEX + 35, BASEY + DIAMETER / 2, DIAMETER, DIAMETER);
		
		//the fifth red ring.
		page.setColor(Color.red);
		page.drawOval(BASEX + 105, BASEY + DIAMETER / 2, DIAMETER, DIAMETER);
	}

}
