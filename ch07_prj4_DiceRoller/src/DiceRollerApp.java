import java.util.Scanner;

public class DiceRollerApp {

    public static void main(String[] args) {



        System.out.println("Welcome to the DIce Roller App!");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nRoll the dice? (y/n): ");
        String choice = sc.next();       

        while (choice.equalsIgnoreCase("y")) {
            Dice dice = new Dice();

            dice.roll();

            System.out.println(dice.printRoll());

            System.out.print("\nRoll again? (y/n): ");
            choice = sc.next();
            System.out.println();
        }

        System.out.print("Bye");
    }

}
