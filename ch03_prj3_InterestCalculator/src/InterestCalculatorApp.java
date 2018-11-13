import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {
    public static void main(String[] args) {

        System.out.println("Welcome to the Interest Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        double loanAmount;
        double interestRate;
        double interestAmount;

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter loan amount:   ");
            loanAmount = sc.nextDouble();
            System.out.print("Enter interest rate: ");
            interestRate = sc.nextDouble();

            interestAmount = loanAmount * interestRate;

            loanAmount = new BigDecimal(loanAmount).setScale(2, RoundingMode.HALF_UP).doubleValue();
            interestRate = new BigDecimal(interestRate).setScale(5, RoundingMode.HALF_UP).doubleValue();
            interestAmount = new BigDecimal(interestAmount).setScale(2, RoundingMode.HALF_UP).doubleValue();

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String loanAmountString = currency.format(loanAmount);
            String interestAmountString = currency.format(interestAmount);
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMaximumFractionDigits(3);
            String interestRateString = percent.format(interestRate);

            System.out.println();
            System.out.println("Loan Amount:     " + loanAmountString);
            System.out.println("Interest Rate:   " + interestRateString);
            System.out.println("Interest:        " + interestAmountString);
            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }

    }
}
