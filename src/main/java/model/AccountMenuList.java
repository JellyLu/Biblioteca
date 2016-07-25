package model;

import java.util.ArrayList;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class AccountMenuList extends MenuList {
    public AccountMenuList() {
        this.list = new ArrayList<MenuItem>(){{
            add(new MenuItem(1, "Main Menu"));
            add(new MenuItem(2, "Book List"));
            add(new MenuItem(3, "Movie List"));
            add(new MenuItem(0, "quit"));
        }};
    }
}
