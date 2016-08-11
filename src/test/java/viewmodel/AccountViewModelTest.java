package viewmodel;

import model.User;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/26/16.
 */
public class AccountViewModelTest {

    @Test
    public void should_return_empty_string_when_user_is_null() {
        AccountViewModel accountViewModel = new AccountViewModel(null);
        assertThat(accountViewModel.description(), is(""));
    }

    @Test
    public void should_return_right_description_when_user_exit() {
        AccountViewModel accountViewModel = new AccountViewModel(new User("xxx-0001", "Joy", "Test1234", "joy@thoughtworks.com", "15881616205"));

        assertThat(accountViewModel.description(), is("[Library number]: xxx-0001, [name]: Joy, [Email]: joy@thoughtworks.com, [Tel]: 15881616205"));
    }
}
