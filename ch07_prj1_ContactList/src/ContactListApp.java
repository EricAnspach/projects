public class ContactListApp {

    public static void main(String[] args) {

        Console.displayLine("Welcome to the Contact List Application\n");

        String choice = "y";


        while (choice.equalsIgnoreCase("y")) {


            choice = Console.getString("Continue? (y/n): ", "y", "n");
        }


    }
}
