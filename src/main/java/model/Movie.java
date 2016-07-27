package model;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class Movie implements Item {
    private String id;
    private String name;
    private String director;
    private int year;
    private double rating = 0;
    private String userId = "";

    public Movie(String id, String name, String director, int year, double rating) {
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

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
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

    public double getRating() {
        return rating;
    }

    public String description() {
       return  "[id]: " + id + ", [name]: " + name + ", "
               + "[director]: " + director + ", [year]: " + year + ", [rating]: " + rating;
    }
}
