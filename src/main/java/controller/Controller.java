package controller;

import data.LibraryData;
import model.*;
import tools.ConsoleTool;
import tools.MessageConstrants;
import views.*;

import java.util.List;

import static java.lang.System.exit;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class Controller {
    private MessageConstrants msgContrants = new MessageConstrants();
    private MainView mainView = new MainView();
    private ItemListView bookListView = new ItemListView(new BookListMenuList(), new ItemList(new LibraryData().BOOK_LIST));
    private ItemListView movieListView = new ItemListView(new MovieMenuList(), new ItemList(new LibraryData().MOVIE_LIST));
    private LoginView loginView = new LoginView();
    private AccountView accountView;

    private String userName = "";
    private String password = "";

    private void welcome() throws Exception {
        ConsoleTool.logln(msgContrants.MSG_WELCOME);
        routToLoginView();
    }

    private void showMenu(List<MenuItem> menuItemList) {
        for (MenuItem item: menuItemList) {
            ConsoleTool.logln(item.describe);
        }
    }

    private void showMainView() {
        showMenu(mainView.menuList());
        ConsoleTool.log(msgContrants.MSG_USER_SELECT_MENU);
    }

    private void showItemList(List<Item> itemList) {
        for (Item item: itemList) {
            ConsoleTool.logln(item.description());
        }
    }

    private void showItemListView(ItemListView itemListView) {
        showItemList(itemListView.showItemList());
        showMenu(itemListView.menuList());
        ConsoleTool.log(msgContrants.MSG_USER_SELECT_MENU);
    }

    private void showLoginView() {
        ConsoleTool.logln(msgContrants.MSG_LOGIN);
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_LIBRARY_NUMBER);
        userName = userInputString();
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_PASSWORD);
        password = userInputString();
    }

    private void showAccountView() {
        ConsoleTool.logln(accountView.description());
        showMenu(accountView.menuList());
        ConsoleTool.log(msgContrants.MSG_USER_SELECT_MENU);
    }

    private int userInputInt() {
        return Integer.parseInt(userInputString());
    }

    private String userInputString() {
        return ConsoleTool.inputFromConsole();
    }

    private void checkOut(ItemListView itemListView, String itemName) throws Exception {
        if (itemListView.showItemList().isEmpty()) {
            ConsoleTool.logln(msgContrants.MSG_NO_ITEM_TO_CHECK_OUT);
            routerToItemListView(itemListView, itemName);
            return;
        }
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_CHECKOUT(itemName));
        String itemId = userInputString();
        if ( bookListView.checkOutItem(itemId)) {
            ConsoleTool.logln(msgContrants.MSG_CHECKED_OUT_SUCCESSFUL(itemName));
            routerToItemListView(itemListView, itemName);
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_ITEM_FOR_CHECKED_OUT(itemName));
            checkOut(itemListView, itemName);
        }
    }

    private void returnFor(ItemListView itemListView, String itemName) throws Exception {
        if (bookListView.checkedOutItemList().isEmpty()) {
            ConsoleTool.logln(msgContrants.MSG_NO_ITEM_TO_RETURN(itemName));
            routerToItemListView(itemListView, itemName);
            return;
        }
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_RETURN(itemName));
        String bookId = userInputString();
        if ( bookListView.returnItem(bookId)) {
            ConsoleTool.logln(msgContrants.MSG_RETURN_ITEM_SUCCESSFUL(itemName));
            routerToItemListView(itemListView, itemName);
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_ITEM_FOR_RETURN(itemName));
            returnFor(itemListView, itemName);
        }
    }

    private void  actionForMainMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToItemListView(bookListView, "book");
                break;
            case 2:
                routerToItemListView(movieListView, "movie");
                break;
            case 3:
                routToAccountView();
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showMainView();
                break;
        }
    }

    private void actionForItemListMenuOption(ItemListView itemListView, String itemName, int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToMainView();
                break;
            case 2:
                checkOut(itemListView, itemName);
                break;
            case 3:
                returnFor(itemListView, itemName);
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showItemListView(bookListView);
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
                routerToItemListView(bookListView, "book");
                break;
            case 3:
                routerToItemListView(movieListView, "movie");
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showItemListView(bookListView);
                break;
        }
    }

    private void routToLoginView() throws Exception {
        showLoginView();
        if (loginView.login(userName, password)) {
            accountView = new AccountView(loginView.getUser());
            routerToMainView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_LOGIN_FAILED);
            routToLoginView();
        }
    }

    public void routerToMainView() throws Exception {
        showMainView();
        int menuOption = userInputInt();
        actionForMainMenuOption(menuOption);
    }

    public void routerToItemListView(ItemListView itemListView, String itemName) throws Exception {
        showItemListView(itemListView);
        int menuOption = userInputInt();
        actionForItemListMenuOption(itemListView, itemName, menuOption);
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
