import java.util.Scanner;

public class TableOfPowersApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Squares and Cubes Table");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        int number = 0;

        while (choice.equalsIgnoreCase("y")) {

            System.out.println();
            System.out.print("Enter an integer: ");
            number = sc.nextInt();

            System.out.println();
            System.out.println("Number\tSquared\tCubed");
            System.out.println("======\t=======\t=====");

            for (int i = 1; i <= number; i++) {
                System.out.println(i + "\t\t" +
                        (i * i) + "\t\t"+
                        (i * i * i)
                );
            }

            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }
    }
}
