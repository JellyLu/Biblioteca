package controller;

import data.LibraryData;
import model.*;
import tools.ConsoleTool;
import tools.MessageConstants;
import tools.ShowMenu;
import view.LoginView;
import view.MainView;
import viewmodel.*;

import java.util.List;

import static java.lang.System.exit;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class Controller {
    private MessageConstants msgConstants = new MessageConstants();
    private MainView mainView = new MainView();
    private LoginView loginView = new LoginView();

    private ItemListViewModel bookListView = new ItemListViewModel(new BookListMenuList(), new ItemList(new LibraryData().BOOK_LIST), "book");
    private ItemListViewModel movieListView = new ItemListViewModel(new MovieMenuList(), new ItemList(new LibraryData().MOVIE_LIST), "movie");
//    private LoginViewModel loginViewModel = new LoginViewModel();
    private AccountViewModel accountViewModel;


    private String userName = "";
    private String password = "";

    private void showItemList(List<Item> itemList) {
        for (Item item: itemList) {
            ConsoleTool.logln(item.description());
        }
    }

    private void showItemListView(ItemListViewModel itemListViewModel) {
        showItemList(itemListViewModel.showItemList());
        ShowMenu.show(itemListViewModel.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    private void showAccountView() {
        ConsoleTool.logln(accountViewModel.description());
        ShowMenu.show(accountViewModel.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    private int userInputInt() {
        return Integer.parseInt(userInputString());
    }

    private String userInputString() {
        return ConsoleTool.inputFromConsole();
    }

    private void checkOut(ItemListViewModel itemListViewModel) throws Exception {
        if (itemListViewModel.showItemList().isEmpty()) {
            ConsoleTool.logln(msgConstants.MSG_NO_ITEM_TO_CHECK_OUT);
            routerToItemListView(itemListViewModel);
            return;
        }

        String itemName = itemListViewModel.getItemName();
        ConsoleTool.log(msgConstants.MSG_USER_INPUT_FOR_CHECKOUT(itemName));
        String itemId = userInputString();
        if ( itemListViewModel.checkOutItem(itemId, accountViewModel.getUserId())) {
            ConsoleTool.logln(msgConstants.MSG_CHECKED_OUT_SUCCESSFUL(itemName));
            routerToItemListView(itemListViewModel);
        } else {
            ConsoleTool.logln(msgConstants.ERR_INVALID_ITEM_FOR_CHECKED_OUT(itemName));
            checkOut(itemListViewModel);
        }
    }

    private void returnFor(ItemListViewModel itemListViewModel) throws Exception {
        String itemName = itemListViewModel.getItemName();
        if (itemListViewModel.checkedOutItemList().isEmpty()) {
            ConsoleTool.logln(msgConstants.MSG_NO_ITEM_TO_RETURN(itemName));
            routerToItemListView(itemListViewModel);
            return;
        }

        ConsoleTool.log(msgConstants.MSG_USER_INPUT_FOR_RETURN(itemName));
        String itemId = userInputString();
        if ( itemListViewModel.returnItem(itemId)) {
            ConsoleTool.logln(msgConstants.MSG_RETURN_ITEM_SUCCESSFUL(itemName));
            routerToItemListView(itemListViewModel);
        } else {
            ConsoleTool.logln(msgConstants.ERR_INVALID_ITEM_FOR_RETURN(itemName));
            returnFor(itemListViewModel);
        }
    }

    private void  actionForMainMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToItemListView(bookListView);
                break;
            case 2:
                routerToItemListView(movieListView);
                break;
            case 3:
                routToAccountView();
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                mainView.showMainView();
                break;
        }
    }

    private void actionForItemListMenuOption(ItemListViewModel itemListViewModel, int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToMainView();
                break;
            case 2:
                checkOut(itemListViewModel);
                break;
            case 3:
                returnFor(itemListViewModel);
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                showItemListView(itemListViewModel);
                break;
        }
    }

    private void actionForAccountMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToMainView();
                break;
            case 2:
                routerToItemListView(bookListView);
                break;
            case 3:
                routerToItemListView(movieListView);
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                showAccountView();
                break;
        }
    }

    public void routerToMainView() throws Exception {
        mainView.showMainView();
        int menuOption = userInputInt();
        actionForMainMenuOption(menuOption);
    }

    public void routerToItemListView(ItemListViewModel itemListViewModel) throws Exception {
        showItemListView(itemListViewModel);
        int menuOption = userInputInt();
        actionForItemListMenuOption(itemListViewModel, menuOption);
    }

    public void routToAccountView() throws Exception {
        showAccountView();
        int menuOption = userInputInt();
        actionForAccountMenuOption(menuOption);
    }

    public void startSystem() throws Exception {
        accountViewModel = loginView.welcome();
        routerToMainView();
    }

    public static void main(String[] args) {
        try {
            new Controller().startSystem();
        } catch (Exception e) {
            ConsoleTool.logln(e.toString());
        }
    }
}
