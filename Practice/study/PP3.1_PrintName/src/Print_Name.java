/*
 * @version: 2112.12.7
 * @author: Baicai
 * 
 * Make the user to imput his name, and then display a string
 * make up with his first name and a number within 10 to 99.
 * 
 */

import java.util.Scanner;
import java.util.Random;

public class Print_Name 
{
	public static void main(String[] args)
	{
		String first_name;
		String last_name;
		String last_namefive;
		int num;
		char ch;
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		System.out.print("Enter your first name: ");
		first_name = scan.nextLine();
		System.out.print("Enter your last name: ");
		last_name = scan.nextLine();
		
		ch = first_name.charAt(0);
		num = ran.nextInt(90) + 10;
		
		int length;
		length = last_name.length();
		if(length >= 5)
		{
			last_namefive = last_name.substring(0, 4);
		}
		else
		{
			last_namefive = last_name;
		}
		
		System.out.println("Your ID: " + ch + last_namefive + num);
		
		
	}

}
