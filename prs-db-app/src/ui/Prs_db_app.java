package ui;

import db.UserDB;
import business.User;
import util.Console;

import java.util.List;

public class Prs_db_app {

    public static void main(String[] args) {
        UserDB userDB = new UserDB();

        Console.displayLine("PRS Database App\n");
        int option;

        do {
            Console.displayLine("\nMenu");
            Console.displayLine("1 - List all Users");
            Console.displayLine("2 - Add a User");
            Console.displayLine("3 - Get a User");
//            Console.displayLine("4 - Delete a User");
            Console.displayLine("4 - Exit\n");

            option = Console.getInt("Enter option: ", 0, 4);

            switch (option) {
                case 1:
                    //List all users
                    try {
                        List<User> users = userDB.getAll();
                        for (User u : users) {
                            Console.displayLine(u.toString());
                        }
                    } catch (Exception e){
                        Console.displayLine("Exception occurred while getting list of Users");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // Add a user
                	Console.displayLine("New user...");
                	String userName = Console.getString("Enter username: ");
                	String password = Console.getString("Enter password: ");
                	String firstName = Console.getString("Enter first name: ");
                	String lastName = Console.getString("Enter last name: ");
                	String phoneNumber = Console.getString("Enter phone number: ");
                	String email = Console.getString("Enter email address: ");
                	try {
                    	if (userDB.addUser(userName, password, firstName, lastName, phoneNumber, email)) {
    						System.out.println("User " + userName + " successfully added.");
    					}
					} catch (Exception e) {
						Console.displayLine("Exception occurred adding user: " + userName + ".");
						e.printStackTrace();
					}

                    break;
                case 3:
                	// get a user
                	Console.displayLine("Get information for a user...");
                	int id = Console.getInt("Enter the id of the user: ");
                	try {
						User u = userDB.get(id);
						System.out.println(u.toString());
					} catch (Exception e) {
						Console.displayLine("Exception occurred getting information for ID " + id + ".");
						e.printStackTrace();
					}
                default:
                    break;
            }



        } while (option != 3);
        Console.displayLine("\nExiting PRS Application");
    }

}
