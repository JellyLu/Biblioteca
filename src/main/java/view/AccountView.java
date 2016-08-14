package view;

import tools.ConsoleTool;
import tools.ShowMenu;
import viewmodel.AccountViewModel;

/**
 * Created by yjlu@thoughtworks.com on 8/14/16.
 */
public class AccountView extends SuperView{
    private AccountViewModel accountViewModel;

    public void bindViewModel(AccountViewModel accountViewModel) {
        this.accountViewModel = accountViewModel;
    }

    public void showAccountView() {
        ConsoleTool.logln(accountViewModel.description());
        ShowMenu.show(accountViewModel.menuList());
        ConsoleTool.log(msgConstants.MSG_USER_SELECT_MENU);
    }

    public AccountViewModel getViewModel() {
        return accountViewModel;
    }
}
