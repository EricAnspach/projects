import java.util.Scanner;

public class FactorialCalculatorApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Factorial Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter an integer that's greater than 0 and less than 40: ");
            long number = sc.nextLong();
            long factorial = 1;

            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("The factorial of " + number + " is " + factorial + ".");
            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }
        sc.close();
    }
}
