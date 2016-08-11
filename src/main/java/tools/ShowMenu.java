package tools;

import model.MenuItem;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 8/11/16.
 */
public class ShowMenu {
    public static void show(List<MenuItem> menuItemList) {
        for (MenuItem item: menuItemList) {
            ConsoleTool.logln(item.describe);
        }
    }
}
