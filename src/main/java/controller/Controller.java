package controller;

import data.LibraryData;
import model.*;
import tools.ConsoleTool;
import tools.MessageConstants;
import tools.ShowMenu;
import view.*;
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
    private AccountView accountView = new AccountView();
    private ItemView bookListView = new ItemView();
    private ItemView movieListView = new ItemView();

    private ItemListViewModel bookListViewModel = new ItemListViewModel(new BookListMenuList(), new ItemList(new LibraryData().BOOK_LIST), "book");
    private ItemListViewModel movieListViewModel = new ItemListViewModel(new MovieMenuList(), new ItemList(new LibraryData().MOVIE_LIST), "movie");

    private void  actionForMainMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routeToItemListView(bookListView);
                break;
            case 2:
                routeToItemListView(movieListView);
                break;
            case 3:
                routeToAccountView();
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                mainView.showMainView();
                break;
        }
    }

    private void actionForItemListMenuOption(ItemView itemView, int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routeToMainView();
                break;
            case 2:
                while( !itemView.checkOut(accountView.getViewModel()) ) {}
                routeToItemListView(itemView);
                break;
            case 3:
                while( !itemView.returnFor() ) {}
                routeToItemListView(itemView);
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                itemView.showItemListView();
                break;
        }
    }

    private void actionForAccountMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routeToMainView();
                break;
            case 2:
                routeToItemListView(bookListView);
                break;
            case 3:
                routeToItemListView(movieListView);
                break;
            default:
                ConsoleTool.logln(msgConstants.ERR_INVALID_MENU_OPTION);
                routeToAccountView();
                break;
        }
    }

    public void routeToMainView() throws Exception {
        mainView.showMainView();
        int menuOption = mainView.userInputInt();
        actionForMainMenuOption(menuOption);
    }

    public void routeToItemListView(ItemView itemView) throws Exception {
        itemView.showItemListView();
        int menuOption = itemView.userInputInt();
        actionForItemListMenuOption(itemView, menuOption);
    }

    public void routeToAccountView() throws Exception {
        accountView.showAccountView();
        int menuOption = accountView.userInputInt();
        actionForAccountMenuOption(menuOption);
    }

    public void startSystem() throws Exception {
        AccountViewModel accountViewModel = loginView.welcome();
        accountView.bindViewModel(accountViewModel);
        bookListView.bindViewModel(bookListViewModel);
        movieListView.bindViewModel(movieListViewModel);
        routeToMainView();
    }

    public static void main(String[] args) {
        try {
            new Controller().startSystem();
        } catch (Exception e) {
            ConsoleTool.logln(e.toString());
        }
    }
}
