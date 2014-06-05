/*
 * @version: 2012.128
 * @author: Baicai
 * 
 * Demonstrates the creation and use of multiple Account objects.
 * 
 */

public class Transactions 
{
	//----------------------------------------------------------------
	//  Create a bank account and requests various services.
	//----------------------------------------------------------------
	public static void main(String[] args)
	{
		Account acct1 = new Account("Caipinglan", 41231345, 156.3);
		Account acct2 = new Account("Fengjiya", 45623135, 2336);
		Account acct3 = new Account("Pianglnacai", 24645123, 5465);
	
		acct1.deposit(223.2);
		
		double fengBalance = acct2.deposit(500.21);
		System.out.println("Feng balance after deposit: " + fengBalance);
		
		System.out.println("Feng balance after withdraw: " +
		                    acct2.withdraw(123.12, 12.3));
		
		acct1.addInterest();
		acct2.addInterest();
		acct3.addInterest();
		
		System.out.println();
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
		
		
	}

}
