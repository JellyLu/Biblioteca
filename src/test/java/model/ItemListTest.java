package model;

import data.LibraryData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/26/16.
 */
public class ItemListTest {
    private ItemList list;

    @Before
    public void setUp() {
        List<Item> allItems = new LibraryData().BOOK_LIST;
        list = new ItemList(allItems);
    }

    @Test
    public void should_return_5_when_the_library_has_5_Items() throws Exception {
        List<Item> allItemList = list.getAllItemList();
        assertThat(allItemList.size(), is(5));
    }

    @Test
    public void should_return_5_when_no_checked_out_Items() throws Exception {
        List<Item> showItemList = list.getShowItemList();
        assertThat(showItemList.size(), is(5));
    }

    @Test
    public void should_return_true_when_checked_out_one_Item_successsful() throws Exception {
        Item Item = new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003);

        assertThat(list.removeItemFromShowItemList(Item), is(true));
        List<Item> showItemList = list.getShowItemList();
        assertThat(showItemList.size(), is(4));
        assertThat(showItemList.get(0).getId(), is("B_0001"));
        assertThat(showItemList.get(1).getId(), is("B_0002"));
        assertThat(showItemList.get(2).getId(), is("B_0004"));
        assertThat(showItemList.get(3).getId(), is("B_0005"));
        assertThat(list.getCheckedOutItemList().size(), is(1));
        assertThat(list.getCheckedOutItemList().get(0).getId(), is("B_0003"));
    }

    @Test
    public void should_return_false_when_checked_out_one_Item_failed() throws Exception {
        Item Item = new Book("B_0006", "Test", "Failed", 2016);

        assertThat(list.removeItemFromShowItemList(Item), is(false));
        List<Item> showItemList = list.getShowItemList();
        assertThat(showItemList.size(), is(5));
        assertThat(showItemList.get(0).getId(), is("B_0001"));
        assertThat(showItemList.get(1).getId(), is("B_0002"));
        assertThat(showItemList.get(2).getId(), is("B_0003"));
        assertThat(showItemList.get(3).getId(), is("B_0004"));
        assertThat(showItemList.get(4).getId(), is("B_0005"));
        assertThat(list.getCheckedOutItemList().size(), is(0));
    }

    @Test
    public void should_return_true_when_return_one_Item_successful() throws Exception {
        Item Item1 = new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003);
        Item Item2 = new Book("B_0005", "Effective Java", "Joshua Bloch", 2001);
        list.setCheckedOutItemList(new ArrayList<Item>(){{
            add(Item1);
            add(Item2);
        }});

        assertThat(list.removeItemFromCheckedOutItemList(Item1), is(true));
        List<Item> showItemList = list.getShowItemList();
        assertThat(showItemList.size(), is(4));
        assertThat(showItemList.get(0).getId(), is("B_0001"));
        assertThat(showItemList.get(1).getId(), is("B_0002"));
        assertThat(showItemList.get(2).getId(), is("B_0004"));
        assertThat(showItemList.get(3).getId(), is("B_0003"));
        assertThat(list.getCheckedOutItemList().size(), is(1));
        assertThat(list.getCheckedOutItemList().get(0).getId(), is("B_0005"));
    }

    @Test
    public void should_return_false_when_return_one_Item_failed() throws Exception {
        Item Item1 = new Book("B_0003", "Test-Driven Development by Example", "Kent Beck", 2003);
        Item Item2 = new Book("B_0005", "Effective Java", "Joshua Bloch", 2001);
        list.setCheckedOutItemList(new ArrayList<Item>(){{
            add(Item1);
            add(Item2);
        }});

        Item Item = new Book("B_0006", "Test", "Failed", 2016);
        assertThat(list.removeItemFromCheckedOutItemList(Item), is(false));
        List<Item> showItemList = list.getShowItemList();
        assertThat(showItemList.size(), is(3));
        assertThat(showItemList.get(0).getId(), is("B_0001"));
        assertThat(showItemList.get(1).getId(), is("B_0002"));
        assertThat(showItemList.get(2).getId(), is("B_0004"));
        assertThat(list.getCheckedOutItemList().size(), is(2));
        assertThat(list.getCheckedOutItemList().get(0).getId(), is("B_0003"));
        assertThat(list.getCheckedOutItemList().get(1).getId(), is("B_0005"));
    }
}
