package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.User;
import com.prs.business.UserDB;
import com.prs.business.Vendor;
import com.prs.business.VendorDB;
import com.prs.util.Console;

@SpringBootApplication
public class PrsJpaDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemo1Application.class, args);
//		UserDB userDB = new UserDB();
		
		System.out.println("Hello Springboot world\n");
		displayMenu();
		int option = 0;
		
		while (option != 9) {
			option = Console.getInt("Enter option: ");
			
			switch (option) {
			case 1:
				// get all users
				List<User> users = UserDB.getAll();
				
				for (User user : users) {
					System.out.println(user);
				}
				break;
			case 2:
				// get user
				int id = Console.getInt("Enter user id: ");
				User user = UserDB.getUserById(id);
				System.out.println(user);
			case 5:
				// get all vendors
				List<Vendor> vendors = VendorDB.getAll();
				
				for (Vendor vendor : vendors) {
					System.out.println(vendor);
				}
				break;
			case 6:
				// get vendor
				id = Console.getInt("Enter vendor id: ");
				Vendor vendor = VendorDB.getVendorById(id);
				System.out.println(vendor);
				break;
			default:
				break;
			}
			
		}
		Console.displayLine("Bye!");
	}

	private static void displayMenu() {
		Console.displayLine("Options");
		Console.displayLine("1 - List users");
		Console.displayLine("2 - Get a user");
		Console.displayLine("5 - List vendors");
		Console.displayLine("6 - Get a vendor");
		Console.displayLine("9 - Exit");
	}	
}

