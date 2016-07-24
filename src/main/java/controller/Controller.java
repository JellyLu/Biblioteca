package controller;

import tools.ConsoleTool;
import tools.MessageConstrants;
import views.MainView;

import static java.awt.SystemColor.menu;
import static java.lang.System.exit;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class Controller {
    private MessageConstrants msgContrants = new MessageConstrants();
    private MainView mainView = new MainView();

    public void welcome() {
        ConsoleTool.logln(msgContrants.MSG_WELCOME);
    }

    private void showMainView() {
        mainView.showMainView();
        ConsoleTool.log(msgContrants.MSG_USER_SELECT_MENU);
    }

    private int userInput() {
        return Integer.parseInt(ConsoleTool.inputFromConsole());
    }

    private void  actionForMainMenuOption(int index) {
        if (index >= mainView.menuList().size() ) {
            ConsoleTool.logln(msgContrants.ERR_INVALID_MENU_OPTION);
            showMainView();
        }

        switch (index) {
            case 0:
                exit(0);
            case 1:
                ConsoleTool.logln("go to BookList View");
        }
    }

    public void routerToMainView() {
        showMainView();
        int n = userInput();
        actionForMainMenuOption(n);
    }


    public static void main(String[] args) {
        new Controller().routerToMainView();
    }
}
