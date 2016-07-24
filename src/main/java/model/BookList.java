package model;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class BookList {
    private List<Book> allBookList;
    private List<Book> showBookList;
    private List<Book> checkedOutBookList;

    public BookList(List<Book> allBooks) {
        this.allBookList = allBooks;
        this.showBookList = allBooks;
        this.checkedOutBookList = new ArrayList<Book>();
    }

    public List<Book> getAllBookList() {
        return allBookList;
    }

    public List<Book> getShowBookList() {
        return showBookList;
    }

    public List<Book> getCheckedOutBookList() {
        return checkedOutBookList;
    }

    public void setShowBookList(List<Book> showBookList) throws Exception {
        for (Book book : showBookList) {
            removeBookFromCheckedOutBookList(book);
        }
    }

    public void setCheckedOutBookList(List<Book> checkedOutBookList) throws Exception {
        for (Book checkedOutBook: checkedOutBookList) {
            removeBookFromShowBookList(checkedOutBook);
        }
    }

    public boolean removeBookFromShowBookList(Book book) throws Exception{
        Iterator<Book> iter = this.showBookList.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(book.getId())) {
                iter.remove();
                this.checkedOutBookList.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean removeBookFromCheckedOutBookList(Book book) throws Exception{
        Iterator<Book> iter = this.checkedOutBookList.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(book.getId())) {
                iter.remove();
                this.showBookList.add(book);
                return true;
            }
        }
        return false;
    }
}
