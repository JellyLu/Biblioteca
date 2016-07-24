package model;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class MenuItemTest {
    @Test
    public void should_return_describe_combine_by_code_and_name(){
        MenuItem item = new MenuItem(2, "quit");
        assertThat(item.describe, is("2: quit"));
        assertThat(item.code, is(2));
        assertThat(item.name, is("quit"));
    }
}
