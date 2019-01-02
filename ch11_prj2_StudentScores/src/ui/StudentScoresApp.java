package ui;

import business.Student;
import util.Console;

import java.util.Arrays;

public class StudentScoresApp {

    public static void main(String[] args) {

        Console.displayLine("The Student Scores Application");

        int totalStudents = Console.getInt("\nNumber of students: ", 0, 500);

        Student[] students = new Student[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            Console.displayLine("\nSTUDENT " + (i + 1));

            Student student = new Student();
            // get user input for student attributes
            String lastName = Console.getString("Last Name: ");
            student.setLastName(lastName);
            String firstName = Console.getString("First Name: ");
            student.setFirstName(firstName);
            int score = Console.getInt("Score: ", 0, 100);
            student.setScore(score);

            students[i] = student;
        }

        Arrays.sort(students);

        Console.displayLine("\nSUMMARY");

        // enhanced for loop to display students
        for (Student s : students) {
            Console.displayLine(s.getLastName() + ", " + s.getFirstName() + ": " + s.getScore());
        }

    }
}
