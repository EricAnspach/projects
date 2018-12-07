package ch09_prj3_ConsoleTester;

import java.io.Console;

public class UserIOTestApp {

	public static void main(String[] args) {
		
		ConsoleIO consoleIO = new ConsoleIO();

		System.out.println("Welcome to the Console Tester Application");
		System.out.println();
		System.out.println("Int Test");		
		consoleIO.getInt("Enter an integer between -100 and 100: ", -100, 100);
		
		System.out.println("\nDouble Test");
		consoleIO.getDouble("Enter any number between -100 and 100: ", -100, 100);
		
		System.out.println("\nRequired String Test");
		consoleIO.getString("Enter your email address: ");
		
		System.out.println("\nString Choice Test");
		consoleIO.getString("Select one (x/y): ", "x", "y");

	}

}
