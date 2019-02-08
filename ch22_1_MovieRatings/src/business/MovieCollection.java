package business;

import java.util.List;

public class MovieCollection {
    private List<Movie> movies;

    public MovieCollection(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void add() {

    }

}
