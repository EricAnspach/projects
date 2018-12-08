public class PersonManagerApp {

    public static void main(String[] args) {
    	
    	Console.displayLine("Welcome to the Person Manager\n");
    	
    	String choice = "y";
    	
    	while (choice.equalsIgnoreCase("y")) {
    		String personType = Console.getString("Create customer or employee? (c/e): ", "c", "e");
    		
    		Console.displayLine();
    		String firstName = Console.getString("First name: ");
    		String lastName = Console.getString("Last name: ");
    		String number = null;
    		String personMessage;
    		
    		if (personType.equalsIgnoreCase("c")) {
    			number = Console.getString("Customer number: ");
				Customer customer = new Customer(firstName, lastName, number);
				
				personMessage = 	"\nYou entered a new Customer:\n" +
										"Name: " + customer.getFirst() + " " + customer.getLast() + "\n" +
										"Customer number: " + customer.getCustomerNumber() + "\n";
			} else {
    			number = Console.getSSNString("SSN: ");    			
				Employee employee = new Employee(firstName, lastName, number);
				
				personMessage = 	"\nYou entered a new Employee:\n" +
										"Name: " + employee.getFirst() + " " + employee.getLast() + "\n" +
										"SSN: " + employee.getSsn() + "\n";
			}
    		
			Console.displayLine(personMessage);
    		choice = Console.getString("Continue? (y/n): ", "y", "n");
    		Console.displayLine();
		}
    	
    	
    	



    }

}
