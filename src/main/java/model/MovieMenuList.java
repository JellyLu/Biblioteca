package model;

import java.util.ArrayList;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class MovieMenuList extends MenuList {
    public MovieMenuList() {
        this.list = new ArrayList<MenuItem>(){{
            add(new MenuItem(1, "Main Menu"));
            add(new MenuItem(2, "Checkout a Movie"));
            add(new MenuItem(3, "Return a Movie"));
            add(new MenuItem(0, "quit"));
        }};
    }
}
