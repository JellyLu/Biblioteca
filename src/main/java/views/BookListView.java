package views;

import data.LibraryData;
import model.*;
import tools.ConsoleTool;
import tools.MessageConstrants;

import java.util.List;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class BookListView {
    private MenuList menu = new BookListMenuList();
    private BookList bookList = new BookList(new LibraryData().BOOK_LIST);

    public List<MenuItem> menuList() {
        return menu.list;
    }

    public List<Book> showBookList() {
        return bookList.getShowBookList();
    }

    public List<Book> chechedOutBookList() {
        return bookList.getCheckedOutBookList();
    }

    public boolean checkOutBook(String bookId) throws Exception {
        for (Book book: bookList.getShowBookList()) {
            if (book.getId().equals(bookId)) {
              return bookList.removeBookFromShowBookList(book);
            }
        }
        return false;
    }

    public boolean returnBook(String bookId) throws Exception {
        List<Book> checkedOutBookList = bookList.getCheckedOutBookList();
        if ( checkedOutBookList == null ) {
            return false;
        }

        for (Book book: bookList.getCheckedOutBookList()) {
            if (book.getId().equals(bookId)) {
                return bookList.removeBookFromCheckedOutBookList(book);
            }
        }
        return false;
    }
}
