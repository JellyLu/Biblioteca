package model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class UserTest {
    @Test
    public void should_return_right_description(){
        User user = new User("xxx-xxxx", "Test User Name", "Test1234", "a@bc.com", "13990293098");
        assertThat(user.description(), is("[Library number]: xxx-xxxx, [name]: Test User Name, [Email]: a@bc.com, [Tel]: 13990293098"));
    }
}
