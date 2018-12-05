package ch09_prj2_AccountBalanceCalculator;

public class AccountBalanceApp {

	public static void main(String[] args) {
		
		CheckingAccount checkingAccount = new CheckingAccount(1.00);
		SavingsAccount savingsAccount = new SavingsAccount(0.01);
		
		checkingAccount.setBalance(1000.00);
		savingsAccount.setBalance(1000.00);
		
		Console.displayLine("Welcome to the Account application\n");
		Console.displayLine("Starting Balances");
		displayBalances(checkingAccount, savingsAccount);
		Console.displayLine();
		Console.displayLine("Enter the transactions for the month\n");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			 String transactionType = Console.getString("Withdrawel or deposit? (w/d): ", "w", "d");
			 String accountType = Console.getString("Checking or savings? (c/s): ", "c", "s");
			 double amount = Console.getDouble("Amount?");
			 
			 // code to perform transaction
			 Account account = null;
			 if (accountType.equalsIgnoreCase("c")) {
				account = checkingAccount;
			}
			 
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
		
		// apply interest and fees
		
		Console.displayLine("\nMonthly Payments and Fees");
		Console.displayLine("Checking Fee:                " + checkingAccount.getMonthlyFee());
		Console.displayLine("Savings Interest Payment:    " + savingsAccount.getMonthlyPayment());
		Console.displayLine();
		Console.displayLine("Final Balances");
		displayBalances(checkingAccount, savingsAccount);
		

	}
	
	private static void displayBalances(CheckingAccount ca, SavingsAccount sa) {
		Console.displayLine("Checking: " + ca.getBalance());
		Console.displayLine("Savings:  " + sa.getBalance());
	}

}
