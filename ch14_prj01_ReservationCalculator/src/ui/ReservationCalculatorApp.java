package ui;

import business.Reservation;
import util.Console;

import java.time.LocalDate;

public class ReservationCalculatorApp {

    public static void main(String[] args) {

        Console.displayLine("Reservation Calculator\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            int arrivalMonth = Console.getInt("Enter the arrival month (1-12): ", 1, 12);
            int arrivalDay = Console.getInt("Enter the arrival day (1-31): ", 1, 31);
            int arrivalYear = Console.getInt("Enter the arrival year: ");

            int departureMonth = Console.getInt("\nEnter the departure month (1-12): ", 1, 12);
            int departureDay = Console.getInt("Enter the departure day (1-31): ", 1, 31);
            int departureYear = Console.getInt("Enter the departure year: ");

            LocalDate arrivalDate = LocalDate.of(arrivalYear, arrivalMonth, arrivalDay);
            LocalDate departureDate = LocalDate.of(departureYear, departureMonth, departureDay);

            Reservation reservation = new Reservation(arrivalDate, departureDate);

            Console.displayLine("\nArrival Date: " + reservation.getArrivalDateFormatted());
            Console.displayLine("Departure Date: " + reservation.getDepartureDateFormatted());
            Console.displayLine("Price: " + reservation.getPricePerNightFormatted() + " per night");
            Console.displayLine("Total Price: " + reservation.getTotalPriceFormatted()
                                    + " for " + reservation.getNumberOfNights() + " nights");


            choice = Console.getString("\nContinue (y/n): ", "y", "n");
            Console.displayLine();
        }

        Console.displayLine("Bye!");
    }
}
