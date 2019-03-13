package ui;

import business.Animal;
import util.Console;

import java.util.ArrayList;
import java.util.List;

public class AnimalListApp {

    public static void main(String[] args) {

        Console.displayLine("Welcome to the Animal List");
        String choice = "y";
        List<Animal> animals = new ArrayList<>();

        while (choice.equalsIgnoreCase("y")) {

            Console.displayLine("\nType of animal:");
            Console.displayLine("1 - Dog");
            Console.displayLine("2 - Cat");
            Console.displayLine("3 - Turtle");

            int type = Console.getInt("\nChoose type: ", 1,3);
            String name = Console.getString("Enter animal's name: ");
            choice = Console.getString("\nContinue? (y/n): ");



        }

        Console.displayLine("\nAnd now let's hear the animals speak");
        Console.displayLine("------------------------------------");


    }

}
