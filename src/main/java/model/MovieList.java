package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class MovieList {
    private List<Movie> allMovieList;
    private List<Movie> showMovieList;
    private List<Movie> checkedOutMovieList;

    public MovieList(List<Movie> allMovies) {
        this.allMovieList = allMovies;
        this.showMovieList = allMovies;
        this.checkedOutMovieList = new ArrayList<Movie>();
    }

    public List<Movie> getAllMovieList() {
        return allMovieList;
    }

    public List<Movie> getShowMovieList() {
        return showMovieList;
    }

    public List<Movie> getCheckedOutMovieList() {
        return checkedOutMovieList;
    }

    public void setShowMovieList(List<Movie> showMovieList) throws Exception {
        for (Movie Movie : showMovieList) {
            removeMovieFromCheckedOutMovieList(Movie);
        }
    }

    public void setCheckedOutMovieList(List<Movie> checkedOutMovieList) throws Exception {
        for (Movie checkedOutMovie: checkedOutMovieList) {
            removeMovieFromShowMovieList(checkedOutMovie);
        }
    }

    public boolean removeMovieFromShowMovieList(Movie Movie) throws Exception{
        if (this.showMovieList.isEmpty()) {
            return false;
        }
        if (this.checkedOutMovieList.isEmpty()) {
            this.checkedOutMovieList = new ArrayList<Movie>();
        }

        Iterator<Movie> iter = this.showMovieList.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(Movie.getId())) {
                iter.remove();
                this.checkedOutMovieList.add(Movie);
                return true;
            }
        }
        return false;
    }

    public boolean removeMovieFromCheckedOutMovieList(Movie Movie) throws Exception{
        if (this.checkedOutMovieList.isEmpty()) {
            return false;
        }
        if (this.showMovieList.isEmpty()) {
            this.showMovieList = new ArrayList<Movie>();
        }

        Iterator<Movie> iter = this.checkedOutMovieList.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(Movie.getId())) {
                iter.remove();
                this.showMovieList.add(Movie);
                return true;
            }
        }
        return false;
    }
}
