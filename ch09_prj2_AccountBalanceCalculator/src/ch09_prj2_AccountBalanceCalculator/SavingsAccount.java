package ch09_prj2_AccountBalanceCalculator;

public class SavingsAccount extends Account {
	double monthlyIntRate;
	double monthlyIntPayment;
	
	public SavingsAccount(double rate) {
		monthlyIntRate = rate;
	}

	public double getMonthlyIntRate() {
		return monthlyIntRate;
	}

	public void setMonthlyIntPayment(double balance, double rate) {
		monthlyIntPayment = balance * rate;
	}

	public double getMonthlyIntPayment() {
		return monthlyIntPayment;
	}
	
	public void applyPaymentToBalance() {
		setBalance(getBalance() + getMonthlyIntPayment());
	}
}
