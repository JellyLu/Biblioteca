package view;

import model.Item;
import tools.ConsoleTool;
import tools.ShowMenu;
import viewmodel.AccountViewModel;
import viewmodel.ItemListViewModel;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 8/14/16.
 */
public class ItemView extends SuperView{
    private ItemListViewModel itemListViewModel;

    public void bindViewModel(ItemListViewModel itemListViewModel) {
        this.itemListViewModel = itemListViewModel;
    }

    private void showItemList(List<Item> itemList) {
        for (Item item: itemList) {
            ConsoleTool.logln(item.description());
        }
    }

    public void showItemListView() {
        showItemList(itemListViewModel.showItemList());
        ShowMenu.show(itemListViewModel.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    private boolean canReturn(String itemName) {
        if (itemListViewModel.unableReturn()) {
            ConsoleTool.logln(msgConstants.MSG_NO_ITEM_TO_RETURN(itemName));
            return false;
        }
        return true;
    }

    private boolean canCheckOut() {
        if (itemListViewModel.unableCheckOut()) {
            ConsoleTool.logln(msgConstants.MSG_NO_ITEM_TO_CHECK_OUT);
            return false;
        }
        return true;
    }

    public boolean checkOut(AccountViewModel accountViewModel) throws Exception {
        if( canCheckOut() ) {
            String itemName = itemListViewModel.getItemName();
            ConsoleTool.log(msgConstants.MSG_USER_INPUT_FOR_CHECKOUT(itemName));
            String itemId = userInputString();
            if (itemListViewModel.checkOutItem(itemId, accountViewModel.getUserId())) {
                ConsoleTool.logln(msgConstants.MSG_CHECKED_OUT_SUCCESSFUL(itemName));
                return true;
            } else {
                ConsoleTool.logln(msgConstants.ERR_INVALID_ITEM_FOR_CHECKED_OUT(itemName));
                return false;
            }
        }
        return false;
    }

    public boolean returnFor() throws Exception {
        String itemName = itemListViewModel.getItemName();
        if ( canReturn(itemName) ) {
            ConsoleTool.log(msgConstants.MSG_USER_INPUT_FOR_RETURN(itemName));
            String itemId = userInputString();
            if ( itemListViewModel.returnItem(itemId)) {
                ConsoleTool.logln(msgConstants.MSG_RETURN_ITEM_SUCCESSFUL(itemName));
                return true;
            } else {
                ConsoleTool.logln(msgConstants.ERR_INVALID_ITEM_FOR_RETURN(itemName));
                return false;
            }
        }
        return false;
    }
}
