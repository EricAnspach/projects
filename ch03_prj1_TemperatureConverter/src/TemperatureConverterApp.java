import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Temperature Converter");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        double fahrenheitDegrees;
        double celciusDegrees;

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter degrees in Fahrenheit: ");
            fahrenheitDegrees = sc.nextDouble();

            celciusDegrees = (fahrenheitDegrees - 32) * 5/9;

//            celciusDegrees = (double) Math.round(celciusDegrees * 100)/100;

            NumberFormat celciusNumber = NumberFormat.getNumberInstance();
            celciusNumber.setMaximumFractionDigits(2);
            String celciusString = celciusNumber.format(celciusDegrees);

//                  Use of Math class to round double variable displays
//                  zero behind decimal point when temperature is a whole number
//            System.out.println("Degrees in Celcius: " + celciusDegrees);
            System.out.println("Degrees in Celcius: " + celciusString);
            System.out.println();
            System.out.print("Continue: (y/n): ");
            choice = sc.next();

        }

    }
}
