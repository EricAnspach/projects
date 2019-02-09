package business;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieCollection {
    private List<Movie> movieList;

    public MovieCollection() {
        movieList = new ArrayList<>();
    }

    public MovieCollection(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovies() {
        return movieList;
    }

    public void add(Movie movie) {
        movieList.add(movie);
    }

    public List<Movie> filterMovies(Predicate<Movie> condition) {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie m : movieList) {
            if (condition.test(m)) {
                filteredMovies.add(m);
            }
        }
        return filteredMovies;
    }

    public double getLowestRating() {
        return movieList.stream().map(m -> m.getRating()).reduce(5.0, (a, b) -> Math.min(a, b));
    }

    public double getHighestRating() {
        return movieList.stream().map(m -> m.getRating()).reduce(0.0, (a, b) -> Math.max(a, b));
    }

    public double getAverageRating() {
        List<Double> ratings = movieList.stream().map(m -> m.getRating()).collect(Collectors.toList());
        double totalRatings = 0.0;
        for (double r : ratings) {
            totalRatings += r;
        }
        return totalRatings / ratings.size();
    }

    public int getSize() {
        return movieList.size();
    }
}
