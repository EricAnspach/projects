package ui;

import business.Customer;
import db.CustomerDB;
import util.Console;

import java.sql.SQLException;
import java.util.List;

public class CustomerManagerApp {

	public static void main(String[] args) {
		CustomerDB customerDB = new CustomerDB();
		Console.displayLine("Welcome to the Customer Manager");
		
		displayMenu();
		
		boolean runLoop = true;
		
		while (runLoop) {
			String option = Console.getString("\nEnter a command: ");
			
			if (option.equalsIgnoreCase("list")) {
				// List all customers
				try {
					List<Customer> customers = customerDB.getCustomers();
						Console.displayLine("\nCUSTOMER LIST");
						for (Customer c : customers) {
							Console.displayLine(c.getEmail() + "\t\t" +
												c.getFirstName() + "\t\t" +
												c.getLastName());			
						}
				} catch (SQLException s) {
					Console.displayLine("Exception occurred getting list of customers.");
					s.printStackTrace();
				}
			} else if (option.equalsIgnoreCase("add")) {
				// Add a customer
				Console.displayLine();
				String email = Console.getString("Enter customer email address: ");
				String firstName = Console.getString("Enter first name: ");
				String lastName = Console.getString("Enter last name: ");
				Console.displayLine();

				try {
					if (customerDB.addCustomer(firstName, lastName, email)) {						
						Console.displayLine(firstName + " " + lastName + " was added to the database.");
					}
 				} catch (SQLException s) {
					Console.displayLine("Exception occurred while attempting to add " +
										firstName + " " + lastName + " to the database.");
					s.printStackTrace();
				}

			} else if (option.equalsIgnoreCase("update")) {
				// Update a customer
				String email = Console.getString("\nEnter email for customer to update: ");
				// getCustomer() in try catch block
				try {
					Customer customer = customerDB.getCustomer(email);
					try {
						String firstName = Console.getString("Enter first name: ");
						String lastName = Console.getString("Enter last name: ");
						Console.displayLine();
						if (customerDB.updateCustomer(email, firstName, lastName)) {							
							Console.displayLine("Record for " + firstName + " " + lastName +
									" has been updated.");
						}
					} catch (SQLException s) {
						Console.displayLine("\nException occurred while attempting to update customer1.");
						s.printStackTrace();
					}
				} catch (SQLException s) {
					Console.displayLine("\nException occurred while attempting to update customer.");
					s.printStackTrace();
				}

				
			} else if (option.equalsIgnoreCase("del")) {
				// Delete a customer
				String email = Console.getString("\nEnter email for customer to delete: ");
				Console.displayLine();
				// getCustomer() in try catch block
				try {
					Customer customer = customerDB.getCustomer(email);
					try {
						if (customerDB.deleteCustomer(email)) {							
							Console.displayLine(customer.getFirstName() + " " + customer.getLastName() +
									" was deleted from the database.");
						}
					} catch (SQLException s) {
						Console.displayLine("\nException occurred while attempting to delete customer.");
						s.printStackTrace();
					}
				} catch (SQLException s) {
					Console.displayLine("\nException occurred while attempting to delete customer.");
					s.printStackTrace();
				}


			} else if (option.equalsIgnoreCase("exit")) {
				runLoop = false;
			} else {
				displayMenu();
			}
			
		}
		
		Console.displayLine("\nBye!");
	}
	
	public static void displayMenu() {
		Console.displayLine("\nCOMMAND MENU\n" + 
							"list     - List all customers\n" +
							"add      - Add a customer\n" +
							"update   - Update a customer\n" +
							"del      - Delete a customer\n" + 
							"help     - Show this menu\n" +
							"exit     - Exit this application");		
	}

}
