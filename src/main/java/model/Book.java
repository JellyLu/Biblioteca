package model;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public final class Book {
    private String id;
    private String bookName;
    private String author;
    private int year;

    public Book(String id, String bookName, String author, int year) {
        this.id = id;
        this.bookName = bookName;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}

