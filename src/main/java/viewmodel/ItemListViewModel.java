package viewmodel;

import model.*;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/27/16.
 */
public class ItemListViewModel {
    private MenuList menu;
    private ItemList itemList;
    private String itemName;

    public ItemListViewModel(MenuList menu, ItemList itemList, String itemName) {
        this.menu = menu;
        this.itemList = itemList;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public List<MenuItem> menuList() {
        return menu.getList();
    }

    public List<Item> showItemList() {
        return itemList.getShowItemList();
    }

    public List<Item> checkedOutItemList() {
        return itemList.getCheckedOutItemList();
    }

    public boolean checkOutItem(String bookId, String userId) throws Exception {
        for (Item item: itemList.getShowItemList()) {
            if (item.getId().equals(bookId)) {
                item.setUserId(userId);
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
                item.setUserId("");
                return itemList.removeItemFromCheckedOutItemList(item);
            }
        }
        return false;
    }
}
