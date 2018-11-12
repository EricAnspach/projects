import java.util.Scanner;

public class TravelTimeCalculatorApp {
    public static void main(String[] args) {

        System.out.println("Welcome to the Travel Time Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        double miles;
        double mph;
        int hours;
        double hoursModulus;
        int minutes;

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter miles:          ");
            miles = sc.nextDouble();
            System.out.print("Enter miles per hour: ");
            mph = sc.nextDouble();

            hours = (int)(miles/mph);
            hoursModulus = (miles % mph)/mph;
            minutes = (int)(hoursModulus*60);

            System.out.println();
            System.out.println("Estimated travel time");
            System.out.println("---------------------");
            System.out.println("Hours:   " + hours);
            System.out.println("Minutes: " + minutes);
            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }

    }
}
