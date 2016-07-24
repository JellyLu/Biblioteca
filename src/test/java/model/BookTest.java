package model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class BookTest {

    @Test
    public void should_return_right_description(){
        Book book = new Book("B_0006", "Test Book Name", "YJ", 2016);
        assertThat(book.description(), is("id: B_0006, bookName: Test Book Name, author: YJ, publish year: 2016"));
    }
}
