import javax.print.attribute.standard.NumberUp;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

    public static void main(String[] args) {

        System.out.println("Tip Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        BigDecimal cost = new BigDecimal("0");
        BigDecimal tipAmount = new BigDecimal("0");
        BigDecimal totalAmount = new BigDecimal("0");

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Cost of meal: ");
            cost = sc.nextBigDecimal();

            for (double i = 0.15; i < 0.30; i += 0.05) {
                System.out.println();
                System.out.println(percent.format(i));
                BigDecimal tipPercent = new BigDecimal(i);
                tipAmount = cost.multiply(tipPercent);
                totalAmount = cost.add(tipAmount);
                System.out.println("Tip Amount:   " + currency.format(tipAmount));
                System.out.println("Total Amount: " + currency.format(totalAmount));
            }


            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }
        sc.close();
    }
}
