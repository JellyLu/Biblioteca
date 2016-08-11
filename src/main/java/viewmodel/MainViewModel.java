package viewmodel;

import model.MainMenuList;
import model.MenuItem;
import model.MenuList;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class MainViewModel {
    private MenuList menu = new MainMenuList();

    public List<MenuItem> menuList() {
        return menu.getList();
    }
}
