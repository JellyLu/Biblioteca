package views;

import model.MainMenuList;
import model.MenuItem;
import model.MenuList;
import tools.ConsoleTool;
import tools.MessageConstrants;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class MainView {
    private MenuList menu = new MainMenuList();
    private MessageConstrants msgConstants = new MessageConstrants();

    public void showMainView() {
        for (MenuItem item: menu.list) {
            ConsoleTool.logln(item.describe);
        }
    }

    public List<MenuItem> menuList() {
        return menu.list;
    }
}
