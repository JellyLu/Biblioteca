package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class MenuList {
    public List<MenuItem> list;

    public MenuList() {
        this.list = new ArrayList<MenuItem>() {};
    }

    public List<MenuItem> getList() {
        return list;
    }
}
