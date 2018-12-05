package ch09_prj2_AccountBalanceCalculator;

public class SavingsAccount extends Account {
	double monthlyRate;
	double monthlyIntPayment;
	
	public SavingsAccount(double rate) {
		monthlyRate = rate;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public double getMonthlyPayment() {
		return monthlyIntPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyIntPayment = monthlyPayment;
	}
	
	public void applyPaymentToBalance() {
		setMonthlyPayment(getMonthlyPayment() * monthlyRate);
		setBalance(getBalance() + monthlyIntPayment);
	}
}
