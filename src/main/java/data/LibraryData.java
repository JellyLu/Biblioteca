package data;

import model.Book;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public final class LibraryData {
    public final List<Book> BOOK_LIST = Arrays.asList(
            new Book("B_0001", "Clean Code", "Robert Cecil Martin", 2008),
            new Book("B_0002", "Refactoring", "Martin Fowler", 1999),
            new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003),
            new Book("B_0004", "Thinking in Java", "Bruce Eckel", 1998),
            new Book("B_0005", "Effective Java", "Joshua Bloch", 2001)
    );
}

