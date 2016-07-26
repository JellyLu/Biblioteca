package controller;

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
    private BookListView bookListView = new BookListView();
    private MovieListView movieListView = new MovieListView();
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

    private void showBookList(List<Item> bookList) {
        for (Item book: bookList) {
            ConsoleTool.logln(book.description());
        }
    }

    private void showBookListView() {
        showBookList(bookListView.showItemList());
        showMenu(bookListView.menuList());
        ConsoleTool.log(msgContrants.MSG_USER_SELECT_MENU);
    }

    private void showMovieList(List<Item> movieList) {
        for (Item movie: movieList) {
            ConsoleTool.logln(movie.description());
        }
    }

    private void showMovieListView() {
        showMovieList(movieListView.showItemList());
        showMenu(movieListView.menuList());
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

    private void checkOutBook() throws Exception {
        if (bookListView.showItemList().isEmpty()) {
            ConsoleTool.logln(msgContrants.MSG_NO_ITEM_TO_CHECK_OUT);
            routerToBookListView();
            return;
        }
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_CHECKOUT("book"));
        String bookId = userInputString();
        if ( bookListView.checkOutBook(bookId)) {
            ConsoleTool.logln(msgContrants.MSG_CHECKED_OUT_SUCCESSFUL("book"));
            routerToBookListView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_ITEM_FOR_CHECKED_OUT("book"));
            checkOutBook();
        }
    }

    private void returnBook() throws Exception {
        if (bookListView.chechedOutItemList().isEmpty()) {
            ConsoleTool.logln(msgContrants.MSG_NO_ITEM_TO_RETURN("book"));
            routerToBookListView();
            return;
        }
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_RETURN("book"));
        String bookId = userInputString();
        if ( bookListView.returnBook(bookId)) {
            ConsoleTool.logln(msgContrants.MSG_RETURN_ITEM_SUCCESSFUL("book"));
            routerToBookListView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_ITEM_FOR_RETURN("book"));
            returnBook();
        }
    }

    private void checkOutMovie() throws Exception {
        if (movieListView.showItemList().isEmpty()) {
            ConsoleTool.logln(msgContrants.MSG_NO_ITEM_TO_CHECK_OUT);
            routerToMovieListView();
            return;
        }
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_CHECKOUT("movie"));
        String movieId = userInputString();
        if ( movieListView.checkOutMovie(movieId)) {
            ConsoleTool.logln(msgContrants.MSG_CHECKED_OUT_SUCCESSFUL("movie"));
            routerToMovieListView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_ITEM_FOR_CHECKED_OUT("movie"));
            checkOutMovie();
        }
    }

    private void returnMovie() throws Exception {
        if (movieListView.chechedOutItemList().isEmpty()) {
            ConsoleTool.logln(msgContrants.MSG_NO_ITEM_TO_RETURN("movie"));
            routerToMovieListView();
            return;
        }
        ConsoleTool.log(msgContrants.MSG_USER_INPUT_FOR_RETURN("movie"));
        String movieId = userInputString();
        if ( movieListView.returnMovie(movieId)) {
            ConsoleTool.logln(msgContrants.MSG_RETURN_ITEM_SUCCESSFUL("movie"));
            routerToMovieListView();
        } else {
            ConsoleTool.logln(msgContrants.ERR_INVALID_ITEM_FOR_RETURN("movie"));
            returnMovie();
        }
    }

    private void  actionForMainMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToBookListView();
                break;
            case 2:
                routerToMovieListView();
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

    private void actionForBookListMenuOption(int index) throws Exception {
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

    private void actionForMovieListMenuOption(int index) throws Exception {
        switch (index) {
            case 0:
                exit(0);
                break;
            case 1:
                routerToMainView();
                break;
            case 2:
                checkOutMovie();
                break;
            case 3:
                returnMovie();
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showMovieListView();
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
                routerToBookListView();
                break;
            case 3:
                routerToMovieListView();
                break;
            default:
                ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
                showBookListView();
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

    public void routerToBookListView() throws Exception {
        showBookListView();
        int menuOption = userInputInt();
        actionForBookListMenuOption(menuOption);
    }

    public void routerToMovieListView() throws Exception {
        showMovieListView();
        int menuOption = userInputInt();
        actionForMovieListMenuOption(menuOption);
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
