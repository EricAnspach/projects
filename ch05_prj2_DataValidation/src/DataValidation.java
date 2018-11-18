import java.util.Scanner;

public class DataValidation {

    public static void main(String[] args) {

        System.out.println("Welcome to the Area and Perimeter Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("");
            double length = getDoubleWithinRange(sc, "Enter length: ", 0, 1000000);
            double width = getDoubleWithinRange(sc, "Enter width:  ", 0, 1000000);

            double area = width * length;
            double perimeter = 2 * width + 2 * length;

            System.out.println("Area:         " + area);
            System.out.println("Perimeter:    " + perimeter);
            System.out.println("");
            choice = getString(sc, "Continue? (y/n): ", "y", "n");
        }
    }

    public static double getDouble(Scanner sc, String prompt) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDoubleWithinRange(Scanner sc, String prompt,
                                              double min, double max) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(sc, prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
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
