package controller;

import data.LibraryData;
import model.*;
import tools.ConsoleTool;
import tools.MessageConstants;
import views.*;

import java.util.List;

import static java.lang.System.exit;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class Controller {
    private MessageConstants msgConstants = new MessageConstants();
    private MainView mainView = new MainView();
    private ItemListView bookListView = new ItemListView(new BookListMenuList(), new ItemList(new LibraryData().BOOK_LIST), "book");
    private ItemListView movieListView = new ItemListView(new MovieMenuList(), new ItemList(new LibraryData().MOVIE_LIST), "movie");
    private LoginView loginView = new LoginView();
    private AccountView accountView;

    private String userName = "";
    private String password = "";

    private void welcome() throws Exception {
        ConsoleTool.logln(msgConstants.MSG_WELCOME);
        routToLoginView();
    }

    private void showMenu(List<MenuItem> menuItemList) {
        for (MenuItem item: menuItemList) {
            ConsoleTool.logln(item.describe);
        }
    }

    private void showMainView() {
        showMenu(mainView.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    private void showItemList(List<Item> itemList) {
        for (Item item: itemList) {
            ConsoleTool.logln(item.description());
        }
    }

    private void showItemListView(ItemListView itemListView) {
        showItemList(itemListView.showItemList());
        showMenu(itemListView.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    private void showLoginView() {
        ConsoleTool.logln(msgConstants.MSG_LOGIN);
        ConsoleTool.log(msgConstants.MSG_USER_INPUT_LIBRARY_NUMBER);
        userName = userInputString();
        ConsoleTool.log(msgConstants.MSG_USER_INPUT_PASSWORD);
        password = userInputString();
    }

    private void showAccountView() {
        ConsoleTool.logln(accountView.description());
        showMenu(accountView.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    private int userInputInt() {
        return Integer.parseInt(userInputString());
    }

    private String userInputString() {
        return ConsoleTool.inputFromConsole();
    }

    private void checkOut(ItemListView itemListView) throws Exception {
        if (itemListView.showItemList().isEmpty()) {
            ConsoleTool.logln(msgConstants.MSG_NO_ITEM_TO_CHECK_OUT);
            routerToItemListView(itemListView);
            return;
        }

        String itemName = itemListView.getItemName();
        ConsoleTool.log(msgConstants.MSG_USER_INPUT_FOR_CHECKOUT(itemName));
        String itemId = userInputString();
        if ( itemListView.checkOutItem(itemId, accountView.getUserId())) {
            ConsoleTool.logln(msgConstants.MSG_CHECKED_OUT_SUCCESSFUL(itemName));
            routerToItemListView(itemListView);
        } else {
            ConsoleTool.logln(msgConstants.ERR_INVALID_ITEM_FOR_CHECKED_OUT(itemName));
            checkOut(itemListView);
        }
    }

    private void returnFor(ItemListView itemListView) throws Exception {
        String itemName = itemListView.getItemName();
        if (itemListView.checkedOutItemList().isEmpty()) {
            ConsoleTool.logln(msgConstants.MSG_NO_ITEM_TO_RETURN(itemName));
            routerToItemListView(itemListView);
            return;
        }

        ConsoleTool.log(msgConstants.MSG_USER_INPUT_FOR_RETURN(itemName));
        String itemId = userInputString();
        if ( itemListView.returnItem(itemId)) {
            ConsoleTool.logln(msgConstants.MSG_RETURN_ITEM_SUCCESSFUL(itemName));
            routerToItemListView(itemListView);
        } else {
            ConsoleTool.logln(msgConstants.ERR_INVALID_ITEM_FOR_RETURN(itemName));
            returnFor(itemListView);
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
                showMainView();
                break;
        }
    }

    private void actionForItemListMenuOption(ItemListView itemListView, int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToMainView();
                break;
            case 2:
                checkOut(itemListView);
                break;
            case 3:
                returnFor(itemListView);
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                showItemListView(itemListView);
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

    private void routToLoginView() throws Exception {
        showLoginView();
        if (loginView.login(userName, password)) {
            accountView = new AccountView(loginView.getUser());
            routerToMainView();
        } else {
            ConsoleTool.logln(msgConstants.ERR_LOGIN_FAILED);
            routToLoginView();
        }
    }

    public void routerToMainView() throws Exception {
        showMainView();
        int menuOption = userInputInt();
        actionForMainMenuOption(menuOption);
    }

    public void routerToItemListView(ItemListView itemListView) throws Exception {
        showItemListView(itemListView);
        int menuOption = userInputInt();
        actionForItemListMenuOption(itemListView, menuOption);
    }

    public void routToAccountView() throws Exception {
        showAccountView();
        int menuOption = userInputInt();
        actionForAccountMenuOption(menuOption);
    }

    public static void main(String[] args) {
        try {
            new Controller().welcome();
        } catch (Exception e) {
            ConsoleTool.logln(e.toString());
        }
    }
}
