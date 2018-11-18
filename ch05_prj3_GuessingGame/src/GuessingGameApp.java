import java.util.Scanner;

public class GuessingGameApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");

        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            System.out.println("\nI'm thinking of a number from 1 to 100.");
            System.out.println("Try to guess it.");
            int number = (int)(Math.random() * 100) + 1;
            int guess = 0;
            int max = 100;
            int min = 1;

            int tries = checkGuess(sc, number, guess, min, max);

            System.out.println(getFinishMessage(tries));

            choice = getString(sc, "\nTry again? (y/n): ", "y", "n");
        }

        System.out.println("Bye! Come back soon!");
    }

    public static String getFinishMessage(int tries) {

        String message = "You got it in " + tries + " tries.\n";

        if (tries <= 3) {
            message += "Great work! You are a mathmatical wizard!";
        } else if (tries <= 7) {
            message += "Not too bad! You've got some potential.";
        } else {
            message += "What took you so long? Maybe you should take some lessons.";
        }
        return message;
    }

    public static int checkGuess(Scanner sc, int number, int guess, int min, int max) {
        int tries = 0;

        do {
            guess = getIntWithinRange(sc, "\nEnter number: ", min, max);
            String message = "";

            if (guess < number) {
                if (guess < number - 10) {
                    message += "Way too low!";
                } else {
                	message += "Too low!";
                }
            } else if (guess > number) {
                if (guess > number + 10) {
                	message += "Way too high!";
                } else {
                	message += "Too high!";
                }
            }
            
            System.out.println(message);
            tries++;
        } while (guess != number);

        return tries;
    }

    public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.println("Error! Number must be greater than " + (min - 1) + ".");
            } else if (i > max) {
                System.out.println("Error! Number must be less than " + (max + 1) + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Please enter an integer.");
            }
            sc.nextLine();
        }
        return i;
    }

    public static String getString(Scanner sc, String prompt, String s1, String s2) {
        String s = "";
        System.out.print(prompt);

        boolean isValid = false;
        while (!isValid) {
            s = sc.next();
            if(s.equalsIgnoreCase(s1) || s.equalsIgnoreCase(s2)) {
                isValid = true;
            } else {
                System.out.print("Error! Please enter y or n. Try again: ");
            }
            sc.nextLine();
        }
        return s;
    }
}
