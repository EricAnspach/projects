import java.util.ArrayList;

public class MovieListApp {

    public static void main(String[] args) {
        String choice = "y";
        ArrayList<Movie> movies = MovieIO.getMovies();
        ArrayList<String> categories = new ArrayList<>();

        categories.add("drama");
        categories.add("musical");
        categories.add("scifi");
        categories.add("horror");
        categories.add("comedy");
        categories.add("animated");

        Console.displayLine("The Movie List application\n");
        Console.displayLine("Choose from " + movies.size() + " movies");

        String categoryString = "Categories: ";

        for (int i = 0; i < (categories.size() - 1); i++) {
            categoryString += categories.get(i) + " | ";
        }
        categoryString += categories.get(categories.size() - 1);

        Console.displayLine(categoryString + "\n");

        while (choice.equalsIgnoreCase("y")) {

            String category = Console.getString("Enter a category: ");

            for (Movie movie : movies) {
                if (category.equalsIgnoreCase(movie.getCategory())) {
                    Console.displayLine(movie.getTitle());
                }
            }

            Console.displayLine();
            choice = Console.getString("Continue: (y/n): ", "y", "n");
            Console.displayLine();
        }
        Console.displayLine("Bye!");
    }

}
