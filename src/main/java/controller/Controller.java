package controller;

import model.Book;
import model.MenuItem;
import tools.ConsoleTool;
import tools.MessageConstrants;
import views.BookListView;
import views.MainView;

import java.util.List;

import static java.lang.System.exit;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class Controller {
    private MessageConstrants msgContrants = new MessageConstrants();
    private MainView mainView = new MainView();
    private BookListView bookListView = new BookListView();

    public void welcome() {
        ConsoleTool.logln(msgContrants.MSG_WELCOME);
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

    private void showBookList(List<Book> bookList) {
        for (Book book: bookList) {
            ConsoleTool.logln(book.description());
        }
    }

    private void showBookListView() {
        showBookList(bookListView.showBookList());
        showMenu(bookListView.menuList());
        ConsoleTool.log(msgContrants.MSG_USER_SELECT_MENU);
    }

    private int userInputInt() {
        return Integer.parseInt(userInputString());
    }

    private String userInputString() {
        return ConsoleTool.inputFromConsole();
    }

    private void  actionForMainMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToBookListView();
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showMainView();
                break;
        }
    }

    private void checkOutBook() throws Exception {
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_CHECKOUT_BOOK);
        String bookId = userInputString();
        if ( bookListView.checkOutBook(bookId)) {
            ConsoleTool.logln(msgContrants.MSG_CHECKED_OUT_SUCCESSFUL);
            routerToBookListView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_BOOK_FOR_CHECKED_OUT);
            checkOutBook();
        }
    }

    private void returnBook() throws Exception {
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_RETURN_BOOK);
        String bookId = userInputString();
        if ( bookListView.returnBook(bookId)) {
            ConsoleTool.logln(msgContrants.MSG_RETURN_BOOK_SUCCESSFUL);
            routerToBookListView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_BOOK_FOR_RETURN);
            returnBook();
        }
    }

    public void actionForBookListMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToMainView();
                break;
            case 2:
                checkOutBook();
                break;
            case 3:
                returnBook();
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showBookListView();
                break;
        }
    }

    public void routerToMainView() throws Exception {
        showMainView();
        int menuOption = userInputInt();
        actionForMainMenuOption(menuOption);
    }

    public void routerToBookListView() throws Exception {
        showBookListView();
        int menuOption = userInputInt();
        actionForBookListMenuOption(menuOption);
    }


    public static void main(String[] args) {
        try {
            new Controller().routerToMainView();
        } catch (Exception e) {
            ConsoleTool.logln(e.toString());
        }
    }
}
