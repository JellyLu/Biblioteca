package model;

import java.util.ArrayList;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class MainMenuList extends MenuList {
    public MainMenuList() {
        this.list = new ArrayList<MenuItem>(){{
            add(new MenuItem(1, "Book List"));
            add(new MenuItem(0, "quit"));
        }};
    }
}
