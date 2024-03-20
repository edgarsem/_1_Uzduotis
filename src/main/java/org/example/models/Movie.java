package org.example.models;

import org.example.Annotations.DescriptionAnnotation;
import org.example.Annotations.MovieEntity;

import java.util.Comparator;
import java.util.List;

@MovieEntity(name = "Movie")
public class Movie implements Comparable<Movie> {
    @DescriptionAnnotation(description = "This is the title of movie", date = "2024-02-14")
    private String title;
    @DescriptionAnnotation(description = "This is the length of the movie(in minutes).", date = "2024-02-14")
    private int length;
    @DescriptionAnnotation(description = "This is the rating of the movie", date = "2024-02-14")
    private double rating;
    @DescriptionAnnotation(description = "This is the release date of the movie.", date = "2024-02-14")
    private int releaseYear;
    @DescriptionAnnotation(description = "This is the cast of the movie", date = "2024-02-14")
    private List<Role<String, Actor>> cast;


    public Movie(String title, int length, double rating, int releaseYear, List<Role<String, Actor>> cast) {
        this.title = title;
        this.length = length;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Role<String, Actor>> getCast() {
        return cast;
    }

    public void setCast(List<Role<String, Actor>> cast) {
        this.cast = cast;
    }

    @Override
    public int compareTo(Movie o) {
        if(this.length == o.length)
            return 0;
        else if(this.length < o.length)
            return  1;
        else
            return -1;
    }

    @DescriptionAnnotation(description = "This method sorts by title.", date = "2024-02-14")
    public static Comparator<Movie> movieByTitle = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    @DescriptionAnnotation(description = "This method sorts by rating.", date = "2024-02-14")
    public static Comparator<Movie> movieByRating = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.getRating(), o2.getRating());
        }
    };

    @DescriptionAnnotation(description = "This method sorts by release date.", date = "2024-02-14")
    public static Comparator<Movie> movieByDate = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Integer.compare(o1.getReleaseYear(), o2.getReleaseYear());
        }
    };

    @DescriptionAnnotation(description = "This method sorts by movie length.", date = "2024-02-14")
    public static Comparator<Movie> movieByLength = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Integer.compare(o1.getLength(), o2.getLength());
        }
    };
}
