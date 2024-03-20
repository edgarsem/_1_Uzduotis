package org.example.cases;

import org.example.models.Actor;
import org.example.models.Movie;
import org.example.models.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieCase {
    private List<Movie> movieList = new ArrayList<>();


    public MovieCase() {
        initData();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public Movie getMovie(int index) {
        return movieList.get(index);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void sortMoviesByTitle() {
        Collections.sort(movieList, Movie.movieByTitle);
    }

    public void sortMoviesByLength() {
        Collections.sort(movieList, Movie.movieByLength);
    }

    public void sortMoviesByReleaseDate() {
        Collections.sort(movieList, Movie.movieByDate);
    }

    public void sortMoviesByRating() {
        Collections.sort(movieList, Movie.movieByRating);
    }

    private void initData() {
        Actor actor1 = new Actor("Emily", "Jean \"Emma\"", "Stone", LocalDateTime.of(
                1988, 11, 6, 12, 0, 0, 0)
        );
        Actor actor2 = new Actor("Mark", "Alan", "Ruffalo", LocalDateTime.of(
                1967, 11, 22, 12, 0, 0, 0)
        );

        Actor actor3 = new Actor("Charles", "Michael", "Melton", LocalDateTime.of(
                1991, 1, 4, 12, 0, 0, 0)
        );
        Actor actor4 = new Actor("Natalie", "", "Portman", LocalDateTime.of(
                1981, 6, 2, 12, 0, 0, 0)
        );
        Actor actor5 = new Actor("Julie", "Anne \"Julianne\"", "Moore", LocalDateTime.of(
                1960, 12, 3, 12, 0, 0, 0)
        );

        Actor actor6 = new Actor("Paul", "Edward Valentine", "Giamatti", LocalDateTime.of(
                1967, 7, 6, 12, 0, 0, 0)
        );
        Actor actor7 = new Actor("Dominic", "", "Sessa", LocalDateTime.of(
                2002, 10, 25, 12, 0, 0, 0)
        );
        Actor actor8 = new Actor("Da'Vine", "Joy", "Randolph", LocalDateTime.of(
                1986, 5, 21, 12, 0, 0, 0)
        );

        Role<String, Actor> role1 = new Role<>("Bella Baxter", actor1);
        Role<String, Actor> role2 = new Role<>("Duncan Wedderburn", actor2);

        Role<String, Actor> role3 = new Role<>("Joe Yoo", actor3);
        Role<String, Actor> role4 = new Role<>("Elizabeth", actor4);
        Role<String, Actor> role5 = new Role<>("Gracie", actor5);

        Role<String, Actor> role6 = new Role<>("Paul Hunham", actor6);
        Role<String, Actor> role7 = new Role<>("Angus Tully", actor7);
        Role<String, Actor> role8 = new Role<>("Mary Lamb", actor8);

        Movie movie1 = new Movie("Poor Things", 142, 8.4, 2023,
                List.of(
                        role1,
                        role2
                )
        );

        Movie movie2 = new Movie("May December", 117, 6.9, 2023,
                List.of(
                        role3,
                        role4,
                        role5
                )
        );

        Movie movie3 = new Movie("The Holdovers", 133, 8, 2023,
                List.of(
                        role6,
                        role7,
                        role8
                )
        );

        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
    }
}
