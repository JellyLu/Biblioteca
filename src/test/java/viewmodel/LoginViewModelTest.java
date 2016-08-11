package viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class LoginViewModelTest {
    private LoginViewModel loginViewModel;
    @Before
    public void setUp() {
        loginViewModel = new LoginViewModel();
    }

    @Test
    public void should_return_true_when_userId_exist_and_password_right() {
        boolean isLogin = loginViewModel.login("xxx-0001", "Test1234");

        assertThat(isLogin, is(true));
    }

    @Test
    public void should_return_false_when_userId_exist_and_password_wrong() {
        boolean isLogin = loginViewModel.login("xxx-0001", "1234Test");

        assertThat(isLogin, is(false));
    }

    @Test
    public void should_return_true_when_userId_not_exist() {
        boolean isLogin = loginViewModel.login("xxx-xxxx", "Test1234");

        assertThat(isLogin, is(false));
    }
}
