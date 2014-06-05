/*
 * @version: 2012.12.8
 * @author: Baicai
 * 
 * Define the Account class with basic services such as deposit
 * and withdraw.
 * 
 */

import java.text.NumberFormat;

public class Account 
{
	private final double RATE = 0.035;
	private long acctNumber;
	private double balance;
	private String name;
	
	//--------------------------------------------------------
	// Set up the account by define the owner, account number, 
	// and the initial balance.
	//--------------------------------------------------------
	public Account(String owner, long account, double initial)
	{
		acctNumber = account;
		balance = initial;
		name = owner;
	}

	//----------------------------------------------------------------------
	//  Deposits the specified amount into the account. Return the new balance.
	//--------------------------------------------------------------------------
	public double deposit(double amount)
	{
		balance += amount;
		return balance;
	}
	
	//--------------------------------------------------------------------
	// Withdraws the specified amount from the account and applies the fee.
	// Return the new balance.
	//---------------------------------------------------------------------
	public double withdraw(double amount, double fee)
	{
		balance = balance - amount - fee;
		if (balance < 0)
		{
			NumberFormat fmt = NumberFormat.getCurrencyInstance();
			System.out.println("You  own the bank: " + fmt.format(balance) + "!");
		}
		return balance;
	}
	
	//-----------------------------------------------------------------------
	// Adds interest to the account and returns the new balance.
	//-----------------------------------------------------------------------
	public double addInterest()
	{
		balance += (balance * RATE);
		return balance;
	}
	
	//----------------------------------------------------------------------
	// Return the current balance of the account.
	//----------------------------------------------------------------------
	public double getBalance()
	{
		return balance;
	}
	
	//-----------------------------------------------------------------------
	//Returns a one-line description of the account as a string.
	//-----------------------------------------------------------------------
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return acctNumber + "\t" + name + "\t" + fmt.format(balance);
	}

	
}
