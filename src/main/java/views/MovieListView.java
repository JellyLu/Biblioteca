package views;

import data.LibraryData;
import model.*;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class MovieListView {
    private MenuList menu = new MovieMenuList();
    private ItemList itemList = new ItemList(new LibraryData().MOVIE_LIST);

    public List<MenuItem> menuList() {
        return menu.getList();
    }

    public List<Item> showItemList() {
        return itemList.getShowItemList();
    }

    public List<Item> checkedOutItemList() {
        return itemList.getCheckedOutItemList();
    }

    public boolean checkOutItem(String movieId) throws Exception {
        for (Item item: itemList.getShowItemList()) {
            if (item.getId().equals(movieId)) {
                return itemList.removeItemFromShowItemList(item);
            }
        }
        return false;
    }

    public boolean returnItem(String MovieId) throws Exception {
        List<Item> checkedOutItemList = itemList.getCheckedOutItemList();
        if ( checkedOutItemList == null ) {
            return false;
        }

        for (Item movie: checkedOutItemList) {
            if (movie.getId().equals(MovieId)) {
                return itemList.removeItemFromCheckedOutItemList(movie);
            }
        }
        return false;
    }
}
