package model;

import org.junit.Test;
import views.AccountView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/26/16.
 */
public class AccountViewTest {

    @Test
    public void should_return_empty_string_when_user_is_null() {
        AccountView accountView = new AccountView(null);
        assertThat(accountView.description(), is(""));
    }

    @Test
    public void should_return_right_description_when_user_exit() {
        AccountView accountView = new AccountView(new User("xxx-0001", "Joy", "Test1234", "joy@thoughtworks.com", "15881616205"));

        assertThat(accountView.description(), is("[Library number]: xxx-0001, [name]: Joy, [Email]: joy@thoughtworks.com, [Tel]: 15881616205"));
    }
}
