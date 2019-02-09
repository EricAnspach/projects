package ui;

import business.Movie;
import business.MovieCollection;
import util.Console;

import java.text.NumberFormat;
import java.time.LocalDate;

public class MovieRatingsApp {

    public static void main(String[] args) {

        // create collection object to hold movies
        MovieCollection movies = new MovieCollection();

        // add some starting data to make testing easier
        movies.add(new Movie("Wonder Woman", 2017, 4.1));
        movies.add(new Movie("Clash of the Titans", 2010, 2.6));
        movies.add(new Movie("Citizen Kane", 1941, 4.9));

        Console.displayLine("Welcome to the Movie Ratings Application\n");
        int option;

        do {
            printMenu();
            option = Console.getInt("Choose a menu option: ", 1, 6);
            Console.displayLine();

            switch (option) {
                case 1:
                    int numberToEnter = Console.getInt("How many movies do you wish to enter? ", 1, 10);
                    Console.displayLine();

                    // for loop to collect movie data from user input and add to list
                    for (int i = 0; i < numberToEnter; i++) {
                        Console.displayLine("Movie #" + (i+1));
                        Console.displayLine("----------");
                        String title = Console.getString("Enter title: ");
                        int year = Console.getInt("Enter year: ");
                        double rating = Console.getDouble("Enter rating between 1 and 5 (decimals OK): ");
                        Console.displayLine();

                        Movie movie = new Movie(title, year, rating);
                        movies.add(movie);
                    }
                    break;
                case 2:
                    // View top rated movies - use filter to get those with 4.0 and higher rating
                    Console.displayLine("Movies rated 4.0 or higher");
                    Console.displayLine("--------------------------");

                    movies.getMovies().stream()
                            .filter(m -> m.getRating() >= 4.0)
                            .forEach(m -> System.out.println(
                                    m.getTitle() + " (" +
                                    m.getYear() + ") Rating: " +
                                    m.getRating()));
                    Console.displayLine();
                    break;
                case 3:
                    // View most recent movies
                    Console.displayLine("Movies from last 10 years");
                    Console.displayLine("-------------------------");

                    LocalDate currentDate = LocalDate.now();
                    int tenYearsAgo = currentDate.getYear() - 10;

                    movies.getMovies().stream()
                            .filter(m -> m.getYear() > tenYearsAgo)
                            .forEach(m -> System.out.println(
                                    m.getTitle() + " (" +
                                            m.getYear() + ") Rating: " +
                                            m.getRating()));
                    Console.displayLine();
                    break;
                case 4:
                    // View all movies - enhanced for loop to view all movies
                    Console.displayLine("All movies");
                    Console.displayLine("--------------");

                    movies.getMovies().stream()
                            .forEach(m -> System.out.println(
                                    m.getTitle() + " (" +
                                            m.getYear() + ") Rating: " +
                                            m.getRating()));
                    Console.displayLine();
                    break;
                case 5:
                    // View ratings - use map and reduce to get the movie ratings
                    // List<Movie> allMovies = movies.getMovies();

                    Console.displayLine("Movie rating data");
                    Console.displayLine("-----------------");
                    Console.displayLine("Number of movies: " + movies.getSize());
                    Console.displayLine("Lowest Rating:    " + movies.getLowestRating());
                    Console.displayLine("Highest Rating:   " + movies.getHighestRating());

                    NumberFormat number = NumberFormat.getNumberInstance();
                    number.setMaximumFractionDigits(1);
                    String avgString = number.format(movies.getAverageRating());
                    Console.displayLine("Average rating:   " + avgString);
                    Console.displayLine();
                    break;
                default:
                    break;
            }

        } while (option !=6);

        Console.displayLine("Goodbye!");
    }

    private static void printMenu() {
        Console.displayLine("-----------------------");
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
