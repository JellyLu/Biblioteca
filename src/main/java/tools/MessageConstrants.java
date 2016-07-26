package tools;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public final class MessageConstrants {
    public final String MSG_WELCOME = "======Welcome to Biblioteca!======";
    public final String MSG_LOGIN = "======Please Login the Library======";
    public final String MSG_CHECKED_OUT_SUCCESSFUL(String itemName) {
        return "======Thank you! Enjoy the " + itemName + "!======";
    }

    public final String MSG_RETURN_ITEM_SUCCESSFUL(String itemName) {
        return "======Thank you for returning the " + itemName +".======";
    }

    public final String MSG_USER_SELECT_MENU = "======Please input the menu id: ";
    public final String MSG_USER_INPUT_LIBRARY_NUMBER = "======Please input your Library Number: ";
    public final String MSG_USER_INPUT_PASSWORD = "======Please input your password: ";
    public final String MSG_USER_INPUT_FOR_CHECKOUT(String itemName) {
        return "======Please input the id of the " + itemName + " you want to Checkout: ";
    }

    public final String MSG_USER_INPUT_FOR_RETURN(String itemName) {
        return "======Please input the id of the " + itemName + " you want to return: ";
    }

    public final String MSG_NO_ITEM_TO_RETURN(String itemName) {
        return "======You don't have any " + itemName + " to return.======";
    }

    public final String MSG_NO_ITEM_TO_CHECK_OUT = "======The library is empty, wait for return.======";


    public final String ERR_INVALID_MENU_OPTION = "======Select a valid option!======";
    public final String ERR_INVALID_ITEM_FOR_CHECKED_OUT(String itemName) {
        return "======That " + itemName + " is not available.======";
    }

    public final String ERR_INVALID_ITEM_FOR_RETURN(String itemName) {
        return "======That is not a valid " + itemName +" to return.======";
    }

    public final String ERR_LOGIN_FAILED = "======Library number not exist or password wrong! ======";

}
