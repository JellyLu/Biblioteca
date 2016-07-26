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

    public List<Item> chechedOutItemList() {
        return itemList.getCheckedOutItemList();
    }

    public boolean checkOutBook(String bookId) throws Exception {
        for (Item book: itemList.getShowItemList()) {
            if (book.getId().equals(bookId)) {
              return itemList.removeItemFromShowItemList(book);
            }
        }
        return false;
    }

    public boolean returnBook(String bookId) throws Exception {
        List<Item> checkedOutItemList = itemList.getCheckedOutItemList();
        if ( checkedOutItemList == null ) {
            return false;
        }

        for (Item book: checkedOutItemList) {
            if (book.getId().equals(bookId)) {
                return itemList.removeItemFromCheckedOutItemList(book);
            }
        }
        return false;
    }
}
