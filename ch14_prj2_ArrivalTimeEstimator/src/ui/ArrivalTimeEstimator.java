package ui;

import util.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ArrivalTimeEstimator {

    public static void main(String[] args) {
        String choice = "y";

        Console.displayLine("Arrival Time Estimator\n");

        while (choice.equalsIgnoreCase("y")) {

            String dateEntered = Console.getString("Departure date (YYYY-MM-DD): ");
            String  timeEntered = Console.getString("Departure time (HH:MM): ");
            int numberOfMiles = Console.getInt("Number of miles: ");
            int mph = Console.getInt("Miles per hour: ");

            String dateTimeEntered = dateEntered + "T" + timeEntered;
            LocalDateTime departureDateTime = LocalDateTime.parse(dateTimeEntered);

            int travelHours = numberOfMiles/mph;
            int travelMinutes = numberOfMiles % mph;

            LocalDateTime arrivalDateTime = departureDateTime.plusHours(travelHours).plusMinutes(travelMinutes);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            String arrivalDateFormatted = dateFormatter.format(arrivalDateTime);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
            String arrivalTimeFormatted = timeFormatter.format(arrivalDateTime);

            Console.displayLine("\nEstimated travel time");
            Console.displayLine("Hours: " + travelHours);
            Console.displayLine("Minutes: " + travelMinutes);
            Console.displayLine("Estimated date of arrival: " + arrivalDateFormatted);
            Console.displayLine("Estimated time of arrival: " + arrivalTimeFormatted);

            choice = Console.getString("\nContinue? (y/n): ", "y", "n");
            Console.displayLine();
        }
        Console.displayLine("Bye!");
    }
}
