package com.prs;

import java.io.ObjectInputStream.GetField;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.ProductDB;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestDB;
import com.prs.business.PurchaseRequestLineItem;
import com.prs.business.PurchaseRequestLineItemDB;
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
		
		while (option != 23) {
			option = Console.getInt("Enter option: ");
			
			switch (option) {
			case 1:
				// list all users
				List<User> users = UserDB.getAll();
				
				for (User user : users) {
					System.out.println(user);
				}
				break;
			case 2:
				// get a user
				int id = Console.getInt("Enter user id: ");
				User user = UserDB.getUserById(id);
				System.out.println(user);
				break;
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
				// list all vendors
				List<Vendor> vendors = VendorDB.getAll();
				
				for (Vendor vendor : vendors) {
					System.out.println(vendor);
				}
				break;
			case 6:
				// get a vendor
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
				// List all products
				List<Product> products = ProductDB.getAll();				
				for (Product product : products) {
					System.out.println(product);
				}
				break;
			case 10:
				// get a product
				int productId = Console.getInt("Enter product id: ");
				Product product = ProductDB.getProductById(productId);
				System.out.println(product);
				break;
			case 11:
				// Add a product
				Product productToAdd = new Product();
            	Console.displayLine("New product...");
            	int vendorId = Console.getInt("Enter vendor id: ");
            	String partNumber = Console.getString("Enter product part number: ");
            	String productName = Console.getString("Enter product name: ");
            	double price = Console.getDouble("Enter price: ");
            	String unit = Console.getString("Enter product unit: ");
            	String photopath = Console.getString("Enter photopath: ");
            	
            	Vendor vendorOfProduct = VendorDB.getVendorById(vendorId);
            
            	productToAdd.setVendor(vendorOfProduct);
            	productToAdd.setPartNumber(partNumber);
            	productToAdd.setName(productName);
            	productToAdd.setPrice(price);
            	productToAdd.setUnit(unit);
            	productToAdd.setPhotoPath(photopath);
								
				if (ProductDB.add(productToAdd)) {
					Console.displayLine("Product " + productName + " added to the database.");
				}
				break;
			case 12:
				// Remove product
				int productIdToRemove = Console.getInt("Enter id of product to remove: ");
				Product productToRemove = ProductDB.getProductById(productIdToRemove);
				ProductDB.delete(productToRemove);			
				break;
			case 13:
				// List all purchase requests
				List<PurchaseRequest> purchaseRequests = PurchaseRequestDB.getAll();				
				for (PurchaseRequest p : purchaseRequests) {
					System.out.println(p);
				}
				break;
			case 14:
				// get a purchase request
				int purchaseRequestId = Console.getInt("Enter purchase request id: ");
				PurchaseRequest purchaseRequest = PurchaseRequestDB.getPurchaseRequestById(purchaseRequestId);
				System.out.println(purchaseRequest);
				// displayTotal(purchaseRequest);
				break;
			case 15:
				// Add a purchase request
				PurchaseRequest purchaseRequestToAdd = new PurchaseRequest();
            	Console.displayLine("New purchase request...");
            	int userId = Console.getInt("Enter user id: ");
            	String description = Console.getString("Enter purchase request description: ");
            	String justification = Console.getString("Enter justification: ");
            	String dateNeededString = Console.getString("Enter date needed (YYYY-MM-DD): ");
            	String deliveryMode = Console.getString("Enter delivery mode: ");
            	
            	User purchaseRequestUser = UserDB.getUserById(userId);
                  	            
            	purchaseRequestToAdd.setUser(purchaseRequestUser);
            	purchaseRequestToAdd.setDescription(description);
            	purchaseRequestToAdd.setJustification(justification);
            	purchaseRequestToAdd.setDateNeeded(LocalDate.parse(dateNeededString));
            	purchaseRequestToAdd.setDeliveryMode(deliveryMode);
            	purchaseRequestToAdd.setStatus("New");
            	purchaseRequestToAdd.setTotal(0.00);
            	purchaseRequestToAdd.setSubmittedDate(LocalDateTime.now());
            	purchaseRequestToAdd.setReasonForRejection("");
								
				if (PurchaseRequestDB.add(purchaseRequestToAdd)) {
					Console.displayLine("Purchase request added to the database.\n");
				}
				break;
			case 16:
				// Remove a purchase request
				int purchaseRequestIdToRemove = Console.getInt("Enter id of purchase request to remove: ");
				PurchaseRequest purchaseRequestToRemove = PurchaseRequestDB.getPurchaseRequestById(purchaseRequestIdToRemove);
				PurchaseRequestDB.delete(purchaseRequestToRemove);	
				break;
			case 17:
				// List all purchase requests line items
				List<PurchaseRequestLineItem> purchaseRequestLineItems = PurchaseRequestLineItemDB.getAll();				
				for (PurchaseRequestLineItem p : purchaseRequestLineItems) {
					System.out.println(p);
				}
				break;
			case 18:
				// get a purchase request line item
				int purchaseRequestLineItemId = Console.getInt("Enter purchase request line item id: ");
				PurchaseRequestLineItem purchaseRequestLineItem = 
						PurchaseRequestLineItemDB.getPurchaseRequestLineItemById(purchaseRequestLineItemId);
				System.out.println(purchaseRequestLineItem);
				PurchaseRequest pRequestOfLI = purchaseRequestLineItem.getPurchaseRequest();
				int pRequestId = pRequestOfLI.getId();
				double purchaseRequestAmount = PurchaseRequestDB.getPurchaseRequestTotal(pRequestId);
				System.out.println("Total cost of purchase request: " + purchaseRequestAmount);
				break;
			case 19:
				// Add a purchase request line item
				PurchaseRequestLineItem purchaseRequestLineItemToAdd = new PurchaseRequestLineItem();
            	Console.displayLine("New purchase request line item...");
            	int purchaseRequestIdForLI = Console.getInt("Enter purchase request id: ");
            	int productIdToAdd = Console.getInt("Enter product id: ");
            	int quantity = Console.getInt("Enter quantity: ");
            	
            	PurchaseRequest purchaseRequestToAddTo = PurchaseRequestDB.getPurchaseRequestById(purchaseRequestIdForLI);
            	Product productToAddToLI = ProductDB.getProductById(productIdToAdd);
                  	            
            	purchaseRequestLineItemToAdd.setPurchaseRequest(purchaseRequestToAddTo);
            	purchaseRequestLineItemToAdd.setProduct(productToAddToLI);
            	purchaseRequestLineItemToAdd.setQuantity(quantity);            
								
				if (PurchaseRequestLineItemDB.add(purchaseRequestLineItemToAdd)) {
					Console.displayLine("Purchase request line item added to the purchase request.\n");
				}
				purchaseRequestAmount = PurchaseRequestDB.getPurchaseRequestTotal(purchaseRequestIdForLI);
				System.out.println("Total cost of purchase request: " + purchaseRequestAmount);
				break;
			case 20:
				// Remove a purchase request line item
				int pRLIIdToRemove = Console.getInt("Enter id of purchase request line item to remove: ");				
				PurchaseRequestLineItem pRLIToRemove = PurchaseRequestLineItemDB.getPurchaseRequestLineItemById(pRLIIdToRemove);
				PurchaseRequest thisPurchaseRequest = pRLIToRemove.getPurchaseRequest();
				PurchaseRequestLineItemDB.delete(pRLIToRemove);
				
				int thisPurchaseRequestId = thisPurchaseRequest.getId();
				purchaseRequestAmount = PurchaseRequestDB.getPurchaseRequestTotal(thisPurchaseRequestId);
				System.out.println("Total cost of purchase request: " + purchaseRequestAmount);
				break;
			case 21:
				// Update user
				Console.displayLine("\nUpdate a User Name...");
				// Enter userID to change
				int idToUpdate = Console.getInt("Enter user id: ");
				// Get User for ID
				User userToUpdate = UserDB.getUserById(idToUpdate);
				// Get input for new userName
				String newUserName = Console.getString("Enter new username: ");
				// set userName to new value
				userToUpdate.setUserName(newUserName);
				// Save new user to id
				if (UserDB.update(userToUpdate)) {
					Console.displayLine("User successfully updated\n");
				}
				break;
			case 22:
				// get all products for a given vendor
				int vid = Console.getInt("Enter vendor id: ");
				List<Product> vendorProducts = ProductDB.getAllProductsByVendorId(vid);
				
				for (Product p : vendorProducts) {
					System.out.println(p);
				}
			case 99:
				displayMenu();
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
		Console.displayLine("10 - Get a product");
		Console.displayLine("11 - Add a product");
		Console.displayLine("12 - Remove a product");
		Console.displayLine("13 - List all purchase requests");
		Console.displayLine("14 - Get a purchase request");
		Console.displayLine("15 - Add a purchase request");
		Console.displayLine("16 - Remove a purchase request");
		Console.displayLine("17 - List all purchase request line items");
		Console.displayLine("18 - Get a purchase request line item");
		Console.displayLine("19 - Add a purchase request line item");
		Console.displayLine("20 - Remove purchase request line item");
		Console.displayLine("21 - Update a user name");
		Console.displayLine("22 - List products by vendor id");
		Console.displayLine("23 - Exit");
		Console.displayLine("99 - Display menu");
	}	
}

