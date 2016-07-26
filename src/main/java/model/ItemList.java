package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/26/16.
 */
public class ItemList {
    private List<Item> allItems;
    private List<Item> showItemList;
    private List<Item> checkedOutItemList;

    public ItemList(List<Item> allItems) {
        this.allItems = allItems;
        this.showItemList = allItems;
        this.checkedOutItemList = new ArrayList<Item>();
    }

    public List<Item> getAllItemList() {
        return allItems;
    }

    public List<Item> getShowItemList() {
        return showItemList;
    }

    public List<Item> getCheckedOutItemList() {
        return checkedOutItemList;
    }

    public void setShowItemList(List<Item> showItemList) throws Exception {
        for (Item Item : showItemList) {
            removeItemFromCheckedOutItemList(Item);
        }
    }

    public void setCheckedOutItemList(List<Item> checkedOutItemList) throws Exception {
        for (Item checkedOutItem: checkedOutItemList) {
            removeItemFromShowItemList(checkedOutItem);
        }
    }

    public boolean removeItemFromShowItemList(Item Item) throws Exception{
        if (this.showItemList.isEmpty()) {
            return false;
        }
        if (this.checkedOutItemList.isEmpty()) {
            this.checkedOutItemList = new ArrayList<Item>();
        }

        Iterator<Item> iter = this.showItemList.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(Item.getId())) {
                iter.remove();
                this.checkedOutItemList.add(Item);
                return true;
            }
        }
        return false;
    }

    public boolean removeItemFromCheckedOutItemList(Item Item) throws Exception{
        if (this.checkedOutItemList.isEmpty()) {
            return false;
        }
        if (this.showItemList.isEmpty()) {
            this.showItemList = new ArrayList<Item>();
        }

        Iterator<Item> iter = this.checkedOutItemList.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(Item.getId())) {
                iter.remove();
                this.showItemList.add(Item);
                return true;
            }
        }
        return false;
    }
}
