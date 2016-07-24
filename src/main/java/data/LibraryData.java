package data;

import model.Book;

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

}

