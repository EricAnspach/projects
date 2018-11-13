import java.util.Scanner;

public class ChangeCalculatorApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Change Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        int cents, quarters, dimes, nickels, pennies;

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter number of cents (0-99): ");
            cents = sc.nextInt();

            quarters = (int)(cents/25);
            cents = cents % 25;

            dimes = (int)(cents/10);
            cents = cents % 10;

            nickels = (int)(cents/5);
            pennies = cents % 5;

            System.out.println();
            System.out.println("Quarters: " + quarters);
            System.out.println("Dimes:    " + dimes);
            System.out.println("Nickels:  " + nickels);
            System.out.println("Pennies   " + pennies);
            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }

    }

}
