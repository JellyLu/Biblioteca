package model;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import views.UserAccountView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class UserAccountViewTest {
    private UserAccountView userAccountView;
    @Before
    public void setUp() {
        userAccountView = new UserAccountView();
    }

    @Test
    public void should_return_true_when_userId_exist_and_password_right() {
        boolean isLogin = userAccountView.login("xxx-0001", "Test1234");

        assertThat(isLogin, is(true));
    }

    @Test
    public void should_return_false_when_userId_exist_and_password_wrong() {
        boolean isLogin = userAccountView.login("xxx-0001", "1234Test");

        assertThat(isLogin, is(false));
    }

    @Test
    public void should_return_true_when_userId_not_exist() {
        boolean isLogin = userAccountView.login("xxx-xxxx", "Test1234");

        assertThat(isLogin, is(false));
    }

    @Test
    public void should_return_empty_string_when_user_not_login() {
        assertThat(userAccountView.description(), is(""));
    }

    @Test
    public void should_return_right_description_when_user_login() {
        userAccountView.login("xxx-0001", "Test1234");

        assertThat(userAccountView.description(), is("[Library number]: xxx-0001, [name]: Joy, [Email]: joy@thougtworks.com, [Tel]: 15881616205"));
    }
}
