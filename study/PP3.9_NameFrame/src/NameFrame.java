/*
 * @version: 2012.12.7
 * @author: Baicai
 * 
 * Make a frame containing two labels with your first and last name.
 * 
 */

import java.awt.*;
import javax.swing.*;

public class NameFrame 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Name label");
		JPanel primary = new JPanel();
		
		JLabel lab1 = new JLabel("Cai");
		JLabel lab2 = new JLabel("Pinglan");
		
		primary.add(lab1);
		primary.add(lab2);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}

}
