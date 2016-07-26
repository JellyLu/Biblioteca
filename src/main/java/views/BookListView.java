package views;

import data.LibraryData;
import model.*;
import tools.ConsoleTool;
import tools.MessageConstrants;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class BookListView {
    private MenuList menu = new BookListMenuList();
    private ItemList itemList = new ItemList(new LibraryData().BOOK_LIST);

    public List<MenuItem> menuList() {
        return menu.getList();
    }

    public List<Item> showItemList() {
        return itemList.getShowItemList();
    }

    public List<Item> checkedOutItemList() {
        return itemList.getCheckedOutItemList();
    }

    public boolean checkOutItem(String bookId) throws Exception {
        for (Item item: itemList.getShowItemList()) {
            if (item.getId().equals(bookId)) {
              return itemList.removeItemFromShowItemList(item);
            }
        }
        return false;
    }

    public boolean returnItem(String bookId) throws Exception {
        List<Item> checkedOutItemList = itemList.getCheckedOutItemList();
        if ( checkedOutItemList == null ) {
            return false;
        }

        for (Item item: checkedOutItemList) {
            if (item.getId().equals(bookId)) {
                return itemList.removeItemFromCheckedOutItemList(item);
            }
        }
        return false;
    }
}
