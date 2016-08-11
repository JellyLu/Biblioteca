package viewmodel;

import data.LibraryData;
import model.User;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class LoginViewModel {
    private User user;

    private User getUserById(String userId) {
        List<User> data = new LibraryData().USER_LIST;
        for (User user: data) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private boolean checkUserPassword(String userId, String pwd) {
        User u = getUserById(userId);
        if (u == null) { return false; }
        return u.getPassword().equals(pwd);
    }

    public boolean login(String userId, String pwd) {
        if (checkUserPassword(userId, pwd)) {
            user = getUserById(userId);
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }
}
