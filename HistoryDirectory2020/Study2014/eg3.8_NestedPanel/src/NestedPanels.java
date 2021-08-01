/*
 * @version: 212.12.6
 * @author: Baicai
 * 
 * Demonstrates a basic component hierarchy.
 * 
 */

import java.awt.*;
import javax.swing.*;

public class NestedPanels 
{
	//--------------------------------------------------------------------
	//Presents two panels in a frame.
	//--------------------------------------------------------------------
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Nested Panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel primary = new JPanel();
		primary.setBackground(Color.blue);
		
		//Set up the first panel 
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(150, 100));
		panel1.setBackground(Color.yellow);
		JLabel label1 = new JLabel("ONE");
		panel1.add(label1);
		
		//Set up second panel
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.green);
		panel2.setPreferredSize(new Dimension(150, 100));
		JLabel label2 = new JLabel("TWO");
		panel2.add(label2);
		
		primary.add(panel1);
		primary.add(panel2);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}

}
