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

    public List<Item> chechedOutItemList() {
        return itemList.getCheckedOutItemList();
    }

    public boolean checkOutMovie(String movieId) throws Exception {
        for (Item movie: itemList.getShowItemList()) {
            if (movie.getId().equals(movieId)) {
                return itemList.removeItemFromShowItemList(movie);
            }
        }
        return false;
    }

    public boolean returnMovie(String MovieId) throws Exception {
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
