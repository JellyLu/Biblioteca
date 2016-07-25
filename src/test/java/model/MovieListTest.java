package model;

import data.LibraryData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class MovieListTest {
    private MovieList list;

    @Before
    public void setUp() {
        List<Movie> allMovies = new LibraryData().MOVIE_LIST;
        list = new MovieList(allMovies); 
    }


    @Test
    public void should_return_5_when_the_library_has_5_Movies() throws Exception {
        List<Movie> allMovieList = list.getAllMovieList();
        assertThat(allMovieList.size(), is(5));
    }

    @Test
    public void should_return_5_when_no_checked_out_Movies() throws Exception {
        List<Movie> showMovieList = list.getShowMovieList();
        assertThat(showMovieList.size(), is(5));
    }

    @Test
    public void should_return_true_when_checked_out_one_Movie_successsful() throws Exception {
        Movie Movie = new Movie("M_3000", "The Lord of the Rings: The Return of the King", " Peter Jackson", 2003, 8.9);

        assertThat(list.removeMovieFromShowMovieList(Movie), is(true));
        List<Movie> showMovieList = list.getShowMovieList();
        assertThat(showMovieList.size(), is(4));
        assertThat(showMovieList.get(0).getId(), is("M_1000"));
        assertThat(showMovieList.get(1).getId(), is("M_2000"));
        assertThat(showMovieList.get(2).getId(), is("M_4000"));
        assertThat(showMovieList.get(3).getId(), is("M_5000"));
        assertThat(list.getCheckedOutMovieList().size(), is(1));
        assertThat(list.getCheckedOutMovieList().get(0).getId(), is("M_3000"));
    }

    @Test
    public void should_return_false_when_checked_out_one_Movie_failed() throws Exception {
        Movie Movie = new Movie("M_6000", "Test Movie Name", "Director Lu", 2016, 9.9);

        assertThat(list.removeMovieFromShowMovieList(Movie), is(false));
        List<Movie> showMovieList = list.getShowMovieList();
        assertThat(showMovieList.size(), is(5));
        assertThat(showMovieList.get(0).getId(), is("M_1000"));
        assertThat(showMovieList.get(1).getId(), is("M_2000"));
        assertThat(showMovieList.get(2).getId(), is("M_3000"));
        assertThat(showMovieList.get(3).getId(), is("M_4000"));
        assertThat(showMovieList.get(4).getId(), is("M_5000"));
        assertThat(list.getCheckedOutMovieList().size(), is(0));
    }

    @Test
    public void should_return_true_when_return_one_Movie_successful() throws Exception {
        Movie Movie1 = new Movie("M_3000", "The Lord of the Rings: The Return of the King", " Peter Jackson", 2003, 8.9);
        Movie Movie2 = new Movie("M_5000", "Saving Private Ryan", "Steven Spielberg", 1998, 8.6);
        list.setCheckedOutMovieList(new ArrayList<Movie>(){{
            add(Movie1);
            add(Movie2);
        }});

        assertThat(list.removeMovieFromCheckedOutMovieList(Movie1), is(true));
        List<Movie> showMovieList = list.getShowMovieList();
        assertThat(showMovieList.size(), is(4));
        assertThat(showMovieList.get(0).getId(), is("M_1000"));
        assertThat(showMovieList.get(1).getId(), is("M_2000"));
        assertThat(showMovieList.get(2).getId(), is("M_4000"));
        assertThat(showMovieList.get(3).getId(), is("M_3000"));
        assertThat(list.getCheckedOutMovieList().size(), is(1));
        assertThat(list.getCheckedOutMovieList().get(0).getId(), is("M_5000"));
    }

    @Test
    public void should_return_false_when_return_one_Movie_failed() throws Exception {
        Movie Movie1 = new Movie("M_3000", "The Lord of the Rings: The Return of the King", " Peter Jackson", 2003, 8.9);
        Movie Movie2 = new Movie("M_5000", "Saving Private Ryan", "Steven Spielberg", 1998, 8.6);
        list.setCheckedOutMovieList(new ArrayList<Movie>(){{
            add(Movie1);
            add(Movie2);
        }});

        Movie Movie = new Movie("B_0006", "Test", "Failed", 2016);
        assertThat(list.removeMovieFromCheckedOutMovieList(Movie), is(false));
        List<Movie> showMovieList = list.getShowMovieList();
        assertThat(showMovieList.size(), is(3));
        assertThat(showMovieList.get(0).getId(), is("M_1000"));
        assertThat(showMovieList.get(1).getId(), is("M_2000"));
        assertThat(showMovieList.get(2).getId(), is("M_4000"));
        assertThat(list.getCheckedOutMovieList().size(), is(2));
        assertThat(list.getCheckedOutMovieList().get(0).getId(), is("M_3000"));
        assertThat(list.getCheckedOutMovieList().get(1).getId(), is("M_5000"));
    }
}
