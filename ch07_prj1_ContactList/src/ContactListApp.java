public class ContactListApp {

    public static void main(String[] args) {

        Console.displayLine("Welcome to the Contact List Application\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            String firstName = Console.getString("Enter first name: ");
            String lastName = Console.getString("Enter last name:  ");
            String email = Console.getString("Enter email:      ");
            String phone = Console.getString("Enter phone:      ");

            Contact contact = new Contact();

            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setEmail(email);
            contact.setPhone(phone);

            Console.displayLine();
            Console.displayLine("------------------------------------------------");
            Console.displayLine("---- Current Contact ---------------------------");
            Console.displayLine("------------------------------------------------");
            Console.displayLine("Name:          " + contact.getFirstName() + " " + contact.getLastName());
            Console.displayLine("Email Address: " + contact.getEmail());
            Console.displayLine("Phone number:  " + contact.getPhone());
            Console.displayLine("------------------------------------------------");
            Console.displayLine();
            choice = Console.getString("Continue? (y/n): ", "y", "n");
            Console.displayLine();
        }
    }
}
