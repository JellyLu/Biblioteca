package model;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class Movie {
    private String id;
    private String name;
    private String director;
    private int year;
    private int rating = 0;

    public Movie(String id, String name, String director, int year, int rating) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public Movie(String id, String name, String director, int year) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public String description() {
       return  "[id]: " + id + ", [name]: " + name + ", "
               + "[director]: " + director + ", [year]: " + year + ", [rating]: " + rating;
    }
}
