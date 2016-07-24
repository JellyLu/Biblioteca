package model;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class MenuItem {
    public int code;
    public String name;
    public String describe;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public MenuItem(int code, String name) {
        this.code = code;
        this.name = name;
        this.describe = "<" + this.code + ">: " + this.name;
    }
}
