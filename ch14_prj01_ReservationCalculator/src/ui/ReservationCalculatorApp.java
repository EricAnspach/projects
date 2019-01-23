package ui;

import util.Console;

public class ReservationCalculatorApp {

    public static void main(String[] args) {

        Console.displayLine("Reservation Calculator\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            int arrivalMonth = Console.getInt("Enter the arrival month (1-12): ", 1, 12);
            int arrivalDay = Console.getInt("Enter the arrival day (1-31): ", 1, 31);
            int arrivalYear = Console.getInt("Enter the arrival year");

            int departureMonth = Console.getInt("\nEnter the departure month (1-12): ", 1, 12);
            int departureDay = Console.getInt("Enter the departure day (1-31): ", 1, 31);
            int departureYear = Console.getInt("Enter the departure year");



            choice = Console.getString("Continue (y/n): ", "y", "n");
        }

        Console.displayLine("Bye!");
    }
}
