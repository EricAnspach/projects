public class GuessingGameApp {

    public static void main(String[] args) {

        Console.displayLine("Welcome to the Guess the Number Game");
        Console.displayLine("++++++++++++++++++++++++++++++++++++");

        String choice = "y";
        int max = 100;
        int min = 1;

        while (choice.equalsIgnoreCase("y")) {

            Game game = new Game();

            Console.displayLine("\nI'm thinking of a number from " + min + " to " + max + ".");
            game.setNumber((int)(Math.random() * 100) + 1);

            Console.displayLine("Try to guess it.");

            int tries = game.checkGuess(min, max);

            Console.displayLine(game.getFinishMessage(tries));

            choice = Console.getString("\nTry again? (y/n): ", "y", "n");
        }

        Console.displayLine("Bye! Come back soon!");
    }



//    public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
//        int i = 0;
//        boolean isValid = false;
//        while (!isValid) {
//            i = getInt(sc, prompt);
//            if (i < min) {
//                System.out.println("Error! Number must be greater than " + (min - 1) + ".");
//            } else if (i > max) {
//                System.out.println("Error! Number must be less than " + (max + 1) + ".");
//            } else {
//                isValid = true;
//            }
//        }
//        return i;
//    }
//
//    public static int getInt(Scanner sc, String prompt) {
//        int i = 0;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print(prompt);
//            if (sc.hasNextInt()) {
//                i = sc.nextInt();
//                isValid = true;
//            } else {
//                System.out.println("Error! Please enter an integer.");
//            }
//            sc.nextLine();
//        }
//        return i;
//    }
//
//    public static String getString(Scanner sc, String prompt, String s1, String s2) {
//        String s = "";
//        System.out.print(prompt);
//
//        boolean isValid = false;
//        while (!isValid) {
//            s = sc.next();
//            if(s.equalsIgnoreCase(s1) || s.equalsIgnoreCase(s2)) {
//                isValid = true;
//            } else {
//                System.out.print("Error! Please enter y or n. Try again: ");
//            }
//            sc.nextLine();
//        }
//        return s;
//    }
}
