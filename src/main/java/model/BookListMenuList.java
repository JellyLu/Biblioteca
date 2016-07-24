package model;

import java.util.ArrayList;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class BookListMenuList extends MenuList {
    public BookListMenuList() {
        this.list = new ArrayList<MenuItem>(){{
            add(new MenuItem(1, "Main Menu"));
            add(new MenuItem(2, "Checkout a Book"));
            add(new MenuItem(3, "Return a Book"));
            add(new MenuItem(0, "quit"));
        }};
    }
}
