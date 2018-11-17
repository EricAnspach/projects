import java.util.Scanner;

public class DiceRollerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dice Roller");
        System.out.println();
        System.out.print("Roll the dice? (y/n): ");
        String choice = sc.next();

        while (choice.equalsIgnoreCase("y")) {

            System.out.println(rollDice());
            choice = askToContinue(sc);
        }
    }

    public static String rollDice() {
        int die1 = (int)(Math.random() * 6) + 1;
        int die2 = (int)(Math.random() * 6) + 1;

        return getTotalMessage(die1, die2);
    }

    public static String getTotalMessage(int die1, int die2) {
        String message = "\n";
        message += "Die 1: " + die1 + "\n";
        message += "Die 2: " + die2 + "\n";
        message += "Total: " + (die1 + die2) + "\n";

        if (die1 == 1 && die2 == 1) {
            message += "Snake eyes!\n";
        } else if (die1 == 6 && die2 == 6) {
            message += "Boxcars!\n";
        }
        return message;
    }

    public static String askToContinue(Scanner sc) {
        System.out.print("Roll again? (y/n): ");
        String choice = sc.next();
        return choice;
    }

}
