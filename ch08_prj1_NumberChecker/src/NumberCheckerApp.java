public class NumberCheckerApp {

    public static void main(String[] args) {

        MyConsole myConsole = new MyConsole();
        String choice = "y";

        myConsole.displayLine("Welcome to the Odd/Even Checker!");

        while (choice.equalsIgnoreCase("y")) {

            int number = myConsole.getInt("\nEnter an integer: ");

            checkNumber(number);

            choice = myConsole.getString("Continue? (y/n): ", "y", "n");
        }

    }

    private static void checkNumber(int number) {
        if (number % 2 == 0) {
            System.out.println("The number " + number + " is even.");
        } else {
            System.out.println("The number " + number + " is odd.");
        }
        System.out.println();
    }
}
