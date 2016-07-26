package model;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public final class Book implements Item {
    private String id;
    private String bookName;
    private String author;
    private int year;
    private String userId;

    public Book(String id, String bookName, String author, int year) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.userId = "";
    }

    public String getUserId() {
        return userId;
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

    @Override
    public String getId() {
        return id;
    }

    public String description() {
        return "[id]: " + id + ", [bookName]: " + bookName + ", [author]: " + author + ", [publish year]: " + year;
    }
}

