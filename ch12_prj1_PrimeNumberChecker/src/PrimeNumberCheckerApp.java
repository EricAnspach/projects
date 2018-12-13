import java.util.ArrayList;

public class PrimeNumberCheckerApp {

    public static void main(String[] args) {

        Console.displayLine("Prime Number Checker\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            int number = Console.getInt("Please enter an integer between 1 and 5000: ", 1, 5000);

            ArrayList<Integer> factors = new ArrayList<>();

            for (int i = 2; i <= (number/2); i++) {
                if (number % i == 0) {
                    factors.add(i);
                }
            }

            if (factors.size() == 0) {
                Console.displayLine(number + " is a prime number.\n");
            } else {
                int factorSize = factors.size();
                String factorList = "1 ";

                for (int i = 0; i < factorSize; i++) {
                    factorList += factors.remove(0) + " ";
                }

                factorSize += 2;
                factorList += number;

                Console.displayLine(number + " is NOT a prime number.");
                Console.displayLine("It has " + factorSize + " factors: " + factorList + "\n");
            }

            choice = Console.getString("Try again? (y/n): ", "y", "n");
            Console.displayLine();
        }

        Console.displayLine("Bye!");
    }

}
