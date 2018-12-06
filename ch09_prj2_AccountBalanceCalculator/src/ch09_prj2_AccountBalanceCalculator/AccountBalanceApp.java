package ch09_prj2_AccountBalanceCalculator;

import java.text.NumberFormat;

public class AccountBalanceApp {

    public static void main(String[] args) {

        CheckingAccount checkingAccount = new CheckingAccount(1.00);
        SavingsAccount savingsAccount = new SavingsAccount(0.01);

        checkingAccount.setBalance(1000.00);
        savingsAccount.setBalance(1000.00);

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        Console.displayLine("Welcome to the Account application\n");
        Console.displayLine("Starting Balances");
        displayBalances(checkingAccount, savingsAccount);
        Console.displayLine();
        Console.displayLine("Enter the transactions for the month\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            String transactionType = Console.getString("Withdrawal or deposit? (w/d): ", "w", "d");
            String accountType = Console.getString("Checking or savings? (c/s): ", "c", "s");
            double amount = Console.getDouble("Amount? ");

//            if (transactionType.equalsIgnoreCase("w")) {
//                amount = Console.getWithdrawalDouble("Amount? ");
//            } else {
//                amount = Console.getDouble("Amount? ");
//            }
            Console.displayLine();

            // code to perform transaction
            Account account = null;
            if (accountType.equalsIgnoreCase("c")) {
                account = checkingAccount;
            } else {
                account = savingsAccount;
            }

            if (transactionType.equalsIgnoreCase("w")) {
                if (amount > account.getBalance()) {
                    Console.displayLine("Amount entered exceeds account balance.\nPlease enter a valid amount.\n");
                } else {
                    account.withdraw(amount);
                }
            } else {
                account.deposit(amount);
            }

            choice = Console.getString("Continue? (y/n): ", "y", "n");
            Console.displayLine();
        }

        // apply interest and fees
        checkingAccount.subtractMonthlyFee();
        savingsAccount.setMonthlyIntPayment(savingsAccount.getBalance(), savingsAccount.getMonthlyIntRate());
        savingsAccount.applyPaymentToBalance();


        Console.displayLine("\nMonthly Payments and Fees");
        Console.displayLine("Checking Fee:                " + currency.format(checkingAccount.getMonthlyFee()));
        Console.displayLine("Savings Interest Payment:    " + currency.format(savingsAccount.getMonthlyIntPayment()));
        Console.displayLine();
        Console.displayLine("Final Balances");
        displayBalances(checkingAccount, savingsAccount);


    }

    private static void displayBalances(CheckingAccount ca, SavingsAccount sa) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Console.displayLine("Checking: " + currency.format(ca.getBalance()));
        Console.displayLine("Savings:  " + currency.format(sa.getBalance()));
    }

}
