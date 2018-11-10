import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args) {

        System.out.println("Welcome to the Letter Grade Converter");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        String letterGrade;
        int grade;

        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter a numerical grade: ");
            grade = sc.nextInt();

            if (grade > 87) {
                letterGrade = "A";
            } else if (grade > 79) {
                letterGrade = "B";
            } else if (grade > 67) {
                letterGrade = "C";
            } else if (grade > 59) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }

            System.out.println("Letter grade: " + letterGrade);
            System.out.println("");
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println("");
        }
    }
}
