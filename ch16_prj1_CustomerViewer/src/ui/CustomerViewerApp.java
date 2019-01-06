package ui;

import business.Customer;
import db.CustomerDB;
import db.NoSuchCustomerException;
import util.Console;

import java.io.IOException;

public class CustomerViewerApp {

    public static void main(String[] args) {

        // CustomerDB customerDB = new CustomerDB();

        Console.displayLine("Customer Viewer\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            int customerNumber = Console.getInt("\nEnter a customer number: ");
            Console.displayLine();

            Customer customer = CustomerDB.getCustomer(customerNumber);

            Console.displayLine(customer.getNameAndAddress());

            choice = Console.getString("\nDisplay another customer? (y/n): ", "y", "n");
        }

        Console.displayLine("\nBye!");
    }
}
