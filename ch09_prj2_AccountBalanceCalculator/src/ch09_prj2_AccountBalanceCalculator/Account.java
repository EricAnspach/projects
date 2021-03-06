package ch09_prj2_AccountBalanceCalculator;

public class Account implements Depositable, Withdrawable, Balanceable {
	private double balance;
	
	public Account() {
		
	}

	public Account(double b) {
		balance = b;
	}

	@Override
	public double getBalance() {		
		return balance;
	}

	@Override
	public void setBalance(double amount) {
		balance = amount;		
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}
}
