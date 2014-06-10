/*
 * @version: 2012.12.6
 * @author: Baicai
 * 
 * Demonstrates and displays the primary appliction frame.
 * 
 */

import java.awt.*;
import javax.swing.*;

public class LabelDemo 
{
	//--------------------------------------------------------
	//Place the picture in different position.
	//--------------------------------------------------------
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Label Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("hot.gif");
		
		JLabel lab1, lab2, lab3;
		
		lab1 = new JLabel("hot.gif", icon, SwingConstants.CENTER);
		
		lab2 = new JLabel("hot.gif", icon, SwingConstants.CENTER);
		lab2.setHorizontalTextPosition(SwingConstants.LEFT);
		lab2.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		lab3 = new JLabel("hot.gif", icon, SwingConstants.CENTER);
		lab3.setHorizontalTextPosition(SwingConstants.CENTER);
		lab3.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(200, 480));
		primary.add(lab1);
		primary.add(lab2);
		primary.add(lab3);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}

}
