package ch09_prj2_AccountBalanceCalculator;

public class CheckingAccount extends Account {
	double monthlyFee;

	public CheckingAccount(double Fee) {		
		monthlyFee = Fee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double Fee) {
		this.monthlyFee = Fee;
	}
	
	public void subtractMonthlyFee () {
		setBalance(getBalance() - monthlyFee);
	}
}
