package model;

import org.junit.Before;
import org.junit.Test;
import views.LoginView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class LoginViewTest {
    private LoginView loginView;
    @Before
    public void setUp() {
        loginView = new LoginView();
    }

    @Test
    public void should_return_true_when_userId_exist_and_password_right() {
        boolean isLogin = loginView.login("xxx-0001", "Test1234");

        assertThat(isLogin, is(true));
    }

    @Test
    public void should_return_false_when_userId_exist_and_password_wrong() {
        boolean isLogin = loginView.login("xxx-0001", "1234Test");

        assertThat(isLogin, is(false));
    }

    @Test
    public void should_return_true_when_userId_not_exist() {
        boolean isLogin = loginView.login("xxx-xxxx", "Test1234");

        assertThat(isLogin, is(false));
    }

    @Test
    public void should_return_empty_string_when_user_not_login() {
        assertThat(loginView.description(), is(""));
    }

    @Test
    public void should_return_right_description_when_user_login() {
        loginView.login("xxx-0001", "Test1234");

        assertThat(loginView.description(), is("[Library number]: xxx-0001, [name]: Joy, [Email]: joy@thougtworks.com, [Tel]: 15881616205"));
    }
}
