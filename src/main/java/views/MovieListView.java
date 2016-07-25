package views;

import data.LibraryData;
import model.*;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class MovieListView {
    private MenuList menu = new MovieMenuList();
    private MovieList MovieList = new MovieList(new LibraryData().MOVIE_LIST);

    public List<MenuItem> menuList() {
        return menu.list;
    }

    public List<Movie> showMovieList() {
        return MovieList.getShowMovieList();
    }

    public List<Movie> chechedOutMovieList() {
        return MovieList.getCheckedOutMovieList();
    }

    public boolean checkOutMovie(String MovieId) throws Exception {
        for (Movie Movie: MovieList.getShowMovieList()) {
            if (Movie.getId().equals(MovieId)) {
                return MovieList.removeMovieFromShowMovieList(Movie);
            }
        }
        return false;
    }

    public boolean returnMovie(String MovieId) throws Exception {
        List<Movie> checkedOutMovieList = MovieList.getCheckedOutMovieList();
        if ( checkedOutMovieList == null ) {
            return false;
        }

        for (Movie Movie: MovieList.getCheckedOutMovieList()) {
            if (Movie.getId().equals(MovieId)) {
                return MovieList.removeMovieFromCheckedOutMovieList(Movie);
            }
        }
        return false;
    }
}
