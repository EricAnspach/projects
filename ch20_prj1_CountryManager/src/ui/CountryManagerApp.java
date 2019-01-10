package ui;

import db.CountryDB;
import util.Console;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryManagerApp {

    public static void main(String[] args) {
        CountryDB countryDB = new CountryDB();

        Console.displayLine("Welcome to the Country Manager\n");

        int choice;

        do {

            Console.displayLine("1 - List Countries");
            Console.displayLine("2 - Add a country");
            Console.displayLine("3 - Delete a country");
            Console.displayLine("4 - Exit\n");

            choice = Console.getInt("Enter menu number: ");
            Console.displayLine();

            switch (choice) {
                case 1:
                    // List countries
                    try {
                        ArrayList<String> countries = countryDB.getCountries();
                        for (String c : countries) {
                            Console.displayLine(c);
                        }
                        Console.displayLine();
                    } catch (SQLException e) {
                        Console.displayLine("Exception occurred getting list of countries.");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // Add a country
                	String name = Console.getString("Enter country: ");
                	try {
						if (countryDB.addCountry(name)) {
							Console.displayLine();
							Console.displayLine(name + " has been added.\n");
						}
					} catch (Exception e) {
						Console.displayLine("Exception occurred adding a country.");
						e.printStackTrace();
					}
                    break;
                case 3:
                    // Delete a country
                	name = Console.getString("Enter country to delete: ");
                	try {
						if (countryDB.deleteCountry(name)) {
							Console.displayLine();
							Console.displayLine(name + " has been deleted from list.\n");
						}
					} catch (Exception e) {
						Console.displayLine("Exception occurred trying to delete the country " + name + ".");
						e.printStackTrace();
					}
                    break;
                case 4:
                    break;
            }


        } while (choice != 4);
        Console.displayLine("Goodbye!");
    }
}
