import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.ArrayList;

public class WizardInventoryApp {

    public static void main(String[] args) {

        int maxItems = 4;
        ArrayList<String> items = new ArrayList<>(maxItems);

        Console.displayLine("The Wizard Inventory game\n");

        items.add("wooden staff");
        items.add("wizard hat");
        items.add("cloth shoes");

        Console.displayLine("COMMAND MENU");
        Console.displayLine("show - Show all items");
        Console.displayLine("grab - Grab an item");
        Console.displayLine("edit - Edit an item");
        Console.displayLine("drop - Drop an item");
        Console.displayLine("exit - Exit program\n");

        String command = "";

        do {
            command = Console.getString("Command: ");
            int number;

            switch (command) {
                case "show":
                    for (int i = 0; i < items.size(); i++) {
                        Console.displayLine((i+1) + ". " + items.get(i));
                    }
                    Console.displayLine();
                    break;
                case "grab":
                    if (items.size() >= maxItems) {
                        Console.displayLine("You can't carry any more items. Drop something first.\n");
                    } else {
                        String grabbedItem = Console.getString("Name: ");
                        items.add(grabbedItem);
                        Console.displayLine(grabbedItem + " was added.\n");
                    }
                    break;
                case "edit":
                    number = Console.getInt("Number: ", 0, (items.size() + 1));
                    String updatedName = Console.getString("Updated name: ");
                    items.set((number - 1), updatedName);
                    Console.displayLine("Item number " + number + " was updated.\n");
                    break;
                case "drop":
                    number = Console.getInt("Number: ", 0, (items.size() + 1));
                    String droppedItem = items.remove(number - 1);
                    Console.displayLine(droppedItem + " was dropped.\n");
                    break;
                case "exit":
                    break;
            }

        } while (!command.equalsIgnoreCase("exit"));

        System.out.println("Bye!");
    }
}
