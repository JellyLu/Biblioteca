package view;

import tools.ConsoleTool;
import viewmodel.AccountViewModel;
import viewmodel.LoginViewModel;

/**
 * Created by yjlu@thoughtworks.com on 8/14/16.
 */
public class LoginView extends SuperView {

    private String inputUserName;
    private String inputPassword;
    private LoginViewModel loginViewModel = new LoginViewModel();

    private void userInput() {
        ConsoleTool.logln(msgConstants.MSG_LOGIN);
        ConsoleTool.log(msgConstants.MSG_USER_INPUT_LIBRARY_NUMBER);
        inputUserName = userInputString();
        ConsoleTool.log(msgConstants.MSG_USER_INPUT_PASSWORD);
        inputPassword = userInputString();
    }

    public AccountViewModel welcome() throws Exception {
        ConsoleTool.logln(msgConstants.MSG_WELCOME);
        return routToLoginView();
    }

    private AccountViewModel routToLoginView() throws Exception {
       AccountViewModel accountViewModel = showLoginView();
        while ( accountViewModel == null) {
            accountViewModel = showLoginView();
        }
        return accountViewModel;
    }

    private AccountViewModel showLoginView() throws Exception {
        userInput();
        if (loginViewModel.login(inputUserName, inputPassword)) {
            return new AccountViewModel(loginViewModel.getUser());
        } else {
            ConsoleTool.logln(msgConstants.ERR_LOGIN_FAILED);
        }
        return null;
    }
}
