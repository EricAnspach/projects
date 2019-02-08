package ui;

import business.Movie;
import business.MovieCollection;
import util.Console;

public class MovieRatingsApp {

    public static void main(String[] args) {

        // create collection object to hold movies
        MovieCollection movies = new MovieCollection();

        // add some starting data to make testing easier
        movies.add(new Movie("Wonder Woman", 2017, 4.1));
        movies.add(new Movie("Clash of the Titans", 2010, 2.6));
        movies.add(new Movie("Citizen Kane", 1941, 4.9));

        Console.displayLine("Welcome to the Movie Ratings Application");
        int option;

        do {
            printMenu();
            option = Console.getInt("Choose a menu option: ", 1, 6);

            switch (option) {
                case 1:
                    int numberToEnter = Console.getInt("How many movies do you wish to enter? ", 1, 10);

                    // for loop to collect movie data from user input
                    // and add to list
                    break;
                case 2:
                    // View top rated movies
                    break;
                case 3:
                    // View most recent movies
                    break;
                case 4:
                    // View all movies
                    break;
                case 5:
                    // View ratings
                    break;
                default:
                    break;
            }

        } while (option !=6);

        Console.displayLine("Goodbye!");
    }

    private static void printMenu() {
        Console.displayLine("\n-----------------------");
        Console.displayLine("What do you want to do?");
        Console.displayLine("-----------------------");
        Console.displayLine("1 - Enter a movie");
        Console.displayLine("2 - View top rated movies");
        Console.displayLine("3 - View most recent movies");
        Console.displayLine("4 - View all movies");
        Console.displayLine("5 - View ratings");
        Console.displayLine("6 - Quit application\n");
    }
}
