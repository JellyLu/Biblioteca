package data;

import model.Book;
import model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public final class LibraryData {
    public final List<Book> BOOK_LIST =  new ArrayList<Book>(){{
        add(new Book("B_0001", "Clean Code", "Robert Cecil Martin", 2008));
        add(new Book("B_0002", "Refactoring", "Martin Fowler", 1999));
        add(new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003));
        add(new Book("B_0004", "Thinking in Java", "Bruce Eckel", 1998));
        add(new Book("B_0005", "Effective Java", "Joshua Bloch", 2001));
    }};

    public final List<Movie> MOVIE_LIST = new ArrayList<Movie>(){{
        add(new Movie("M_1000", "The Godfather", "Francis Ford Coppola", 1972, 9.2));
        add(new Movie("M_2000", "Forrest Gump", "Robert Zemeckis", 1994, 8.8));
        add(new Movie("M_3000", "The Lord of the Rings: The Return of the King", " Peter Jackson", 2003, 8.9));
        add(new Movie("M_4000", "Titanic", "James Cameron", 1997, 7.7));
        add(new Movie("M_5000", "Saving Private Ryan", "Steven Spielberg", 1998, 8.6));
    }};
}

