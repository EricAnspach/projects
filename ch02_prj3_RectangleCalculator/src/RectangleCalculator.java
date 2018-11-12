import java.util.Scanner;

public class RectangleCalculator {

	public static void main(String[] args) {

        System.out.println("Welcome to the Area and Perimeter Calculator");

        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("");
            System.out.print("Enter length: ");
            double length = sc.nextDouble();
            System.out.print("Enter width:  ");
            double width = sc.nextDouble();

            double area = width * length;
            double perimeter = 2 * width + 2 * length;

            System.out.println("Area:         " + area);
            System.out.println("Perimeter:    " + perimeter);
            System.out.println("");
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }



	}

}
