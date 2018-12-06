package ch09_prj2_AccountBalanceCalculator;

public class CheckingAccount extends Account {
	double monthlyFee;

	public CheckingAccount(double fee) {
		monthlyFee = fee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}
	
	public void subtractMonthlyFee () {
		setBalance(getBalance() - monthlyFee);
	}
}
