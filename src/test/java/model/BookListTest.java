package model;

import data.LibraryData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class BookListTest {
    private List<Book> allBooks = new LibraryData().BOOK_LIST;

    @Test
    public void should_return_5_when_the_library_has_5_books() throws Exception {
        List<Book> list = new BookList(allBooks).getAllBookList();
        assertThat(list.size(), is(5));
    }

    @Test
    public void should_return_5_when_no_checked_out_books() throws Exception {
        List<Book> list = new BookList(allBooks).getShowBookList();
        assertThat(list.size(), is(5));
    }

    @Test
    public void should_return_true_when_checked_out_one_book_successsful() throws Exception {
        BookList list = new BookList(allBooks);
        Book book = new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003);

        assertThat(list.removeBookFromShowBookList(book), is(true));
        List<Book> showBookList = list.getShowBookList();
        assertThat(showBookList.size(), is(4));
        assertThat(showBookList.get(0).getId(), is("B_0001"));
        assertThat(showBookList.get(1).getId(), is("B_0002"));
        assertThat(showBookList.get(2).getId(), is("B_0004"));
        assertThat(showBookList.get(3).getId(), is("B_0005"));
        assertThat(list.getCheckedOutBookList().size(), is(1));
        assertThat(list.getCheckedOutBookList().get(0).getId(), is("B_0003"));
    }

    @Test
    public void should_return_false_when_checked_out_one_book_failed() throws Exception {
        BookList list = new BookList(allBooks);
        Book book = new Book("B_0006", "Test", "Failed", 2016);

        assertThat(list.removeBookFromShowBookList(book), is(false));
        List<Book> showBookList = list.getShowBookList();
        assertThat(showBookList.size(), is(5));
        assertThat(showBookList.get(0).getId(), is("B_0001"));
        assertThat(showBookList.get(1).getId(), is("B_0002"));
        assertThat(showBookList.get(2).getId(), is("B_0003"));
        assertThat(showBookList.get(3).getId(), is("B_0004"));
        assertThat(showBookList.get(4).getId(), is("B_0005"));
        assertThat(list.getCheckedOutBookList().size(), is(0));
    }

    @Test
    public void should_return_true_when_return_one_book_successful() throws Exception {
        BookList list = new BookList(allBooks);
        Book book1 = new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003);
        Book book2 = new Book("B_0005", "Effective Java", "Joshua Bloch", 2001);
        list.setCheckedOutBookList(new ArrayList<Book>(){{
            add(book1);
            add(book2);
        }});

        assertThat(list.removeBookFromCheckedOutBookList(book1), is(true));
        List<Book> showBookList = list.getShowBookList();
        assertThat(showBookList.size(), is(4));
        assertThat(showBookList.get(0).getId(), is("B_0001"));
        assertThat(showBookList.get(1).getId(), is("B_0002"));
        assertThat(showBookList.get(2).getId(), is("B_0004"));
        assertThat(showBookList.get(3).getId(), is("B_0003"));
        assertThat(list.getCheckedOutBookList().size(), is(1));
        assertThat(list.getCheckedOutBookList().get(0).getId(), is("B_0005"));
    }

    @Test
    public void should_return_false_when_return_one_book_failed() throws Exception {
        BookList list = new BookList(allBooks);
        Book book1 = new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003);
        Book book2 = new Book("B_0005", "Effective Java", "Joshua Bloch", 2001);
        list.setCheckedOutBookList(new ArrayList<Book>(){{
            add(book1);
            add(book2);
        }});

        Book book = new Book("B_0006", "Test", "Failed", 2016);
        assertThat(list.removeBookFromCheckedOutBookList(book), is(false));
        List<Book> showBookList = list.getShowBookList();
        assertThat(showBookList.size(), is(3));
        assertThat(showBookList.get(0).getId(), is("B_0001"));
        assertThat(showBookList.get(1).getId(), is("B_0002"));
        assertThat(showBookList.get(2).getId(), is("B_0004"));
        assertThat(list.getCheckedOutBookList().size(), is(2));
        assertThat(list.getCheckedOutBookList().get(0).getId(), is("B_0003"));
        assertThat(list.getCheckedOutBookList().get(1).getId(), is("B_0005"));
    }
}

