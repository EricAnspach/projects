package ui;

import business.Student;
import util.Console;

public class StudentScoresApp {

    public static void main(String[] args) {

        Console.displayLine("The Student Scores Application");

        int totalStudents = Console.getInt("Number of students: ", 0, 500);

        Student[] students = new Student[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            Student student = new Student();

            // get user input for student attributes

            students[i] = student;
        }

        Console.displayLine("\nSUMMARY");

        // enhanced for loop to display students

    }
}
