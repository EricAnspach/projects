import java.util.Scanner;

public class CommonDivisorFinder {

    public static void main(String[] args) {

        System.out.println("Greatest Common Divisor Finder");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        int x, y, z, divisor;

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter first number: ");
            x = sc.nextInt();
            System.out.print("Enter second number: ");
            y = sc.nextInt();

            while (x > 0) {

                if (x < y) {
                    while (x <= y) {
                        y = y - x;
                    }
                } else {
                    z = x;
                    x = y;
                    y = z;
                }
            }

            divisor = y;

            System.out.println("Greatest common divisor: " + divisor);
            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }
        sc.close();
    }


}
