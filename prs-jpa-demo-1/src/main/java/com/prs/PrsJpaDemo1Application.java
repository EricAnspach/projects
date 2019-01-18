package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.ProductDB;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestDB;
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
		
		while (option != 11) {
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
			case 3:
				// add user
				User userToAdd = new User();
            	Console.displayLine("New user...");
            	String userName = Console.getString("Enter username: ");
            	String password = Console.getString("Enter password: ");
            	String firstName = Console.getString("Enter first name: ");
            	String lastName = Console.getString("Enter last name: ");
            	String phoneNumber = Console.getString("Enter phone number: ");
            	String email = Console.getString("Enter email address: ");
            	
            	userToAdd.setUserName(userName);
            	userToAdd.setPassword(password);
            	userToAdd.setFirstName(firstName);
            	userToAdd.setLastName(lastName);
            	userToAdd.setPhoneNumber(phoneNumber);
            	userToAdd.setEmail(email);         	         	
								
				if (UserDB.add(userToAdd)) {
					Console.displayLine("User " + userName + " added to the database.");
				}
				break;
			case 4:
				// remove user
				int idToRemove = Console.getInt("Enter id of user to remove: ");
				User userToRemove = UserDB.getUserById(idToRemove);
				UserDB.delete(userToRemove);			
				break;
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
			case 7:
				// Add vendor
				Vendor vendorToAdd = new Vendor();
            	Console.displayLine("New vendor...");
            	String code = Console.getString("Enter vendor code: ");
            	String name = Console.getString("Enter name: ");
            	String address = Console.getString("Enter street address: ");
            	String city = Console.getString("Enter city: ");
            	String state = Console.getString("Enter state: ");
            	String zip = Console.getString("Enter zip code: ");
             	String vendorPhone = Console.getString("Enter phone number: ");
            	String vendorEmail = Console.getString("Enter email address: ");
            	
            	vendorToAdd.setCode(code);
            	vendorToAdd.setName(name);
            	vendorToAdd.setAddress(address);
            	vendorToAdd.setCity(city);
            	vendorToAdd.setState(state);
            	vendorToAdd.setZip(zip);
            	vendorToAdd.setPhoneNumber(vendorPhone);
            	vendorToAdd.setEmail(vendorEmail);                  	         	
								
				if (VendorDB.add(vendorToAdd)) {
					Console.displayLine("Vendor " + name + " added to the database.");
				}
				break;
			case 8:
				// Remove vendor
				int vendorIdToRemove = Console.getInt("Enter id of vendor to remove: ");
				Vendor vendorToRemove = VendorDB.getVendorById(vendorIdToRemove);
				VendorDB.delete(vendorToRemove);			
				break;
			case 9:
				// Get all products
				List<Product> products = ProductDB.getAll();				
				for (Product product : products) {
					System.out.println(product);
				}
				break;
			case 10:
				// Get all purchase requests
				List<PurchaseRequest> purchaseRequests = PurchaseRequestDB.getAll();				
				for (PurchaseRequest p : purchaseRequests) {
					System.out.println(p);
				}
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
		Console.displayLine("3 - Add user");
		Console.displayLine("4 - Remove user");
		Console.displayLine("5 - List vendors");
		Console.displayLine("6 - Get a vendor");
		Console.displayLine("7 - Add vendor");
		Console.displayLine("8 - Remove vendor");
		Console.displayLine("9 - List all products");
		Console.displayLine("10 - List all purchase requests");
		Console.displayLine("11 - Exit");
	}	
}

