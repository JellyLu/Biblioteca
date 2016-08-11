package view;

import model.MenuItem;
import tools.ConsoleTool;
import tools.ShowMenu;
import viewmodel.MainViewModel;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 8/11/16.
 */
public class MainView extends SuperView {
    private MainViewModel mainViewModel = new MainViewModel();

     public void showMainView() {
         ShowMenu.show(mainViewModel.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

}
