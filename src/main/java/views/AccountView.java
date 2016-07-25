package views;

import model.AccountMenuList;
import model.MenuItem;
import model.MenuList;
import model.User;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class AccountView {
    private User user;
    private MenuList menuList = new AccountMenuList();

    public List<MenuItem> menuList() {
        return menuList.getList();
    }

    public AccountView(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String description() {
        if (user == null) return "";
        return user.description();
    }
}
