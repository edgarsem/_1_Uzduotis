package org.example.UI;

import org.example.models.Actor;
import org.example.models.Role;
import org.example.cases.MovieCase;

import java.util.Scanner;

public class MovieScreen {
    private MovieCase movieCase;

    public MovieScreen(MovieCase movieCase) {
        this.movieCase = movieCase;
    }
    public void displayScreen() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n1.Sort by title");
            System.out.println("2.Sort by length");
            System.out.println("3.Sort by rating");
            System.out.println("4.Sort by release year");
            System.out.println("------------------------------");
            System.out.println("Choose movie:");
            for(int i = 5; i < movieCase.getMovieList().size() + 5; i++) {
                System.out.println(
                        i + ". " + movieCase.getMovie(i - 5).getTitle() + " "
                        + movieCase.getMovie(i - 5).getLength() + " min. "
                        + movieCase.getMovie(i - 5).getRating() + " "
                        + movieCase.getMovie(i - 5).getReleaseYear()
                );
            }
            System.out.println("0. Return.\n");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    movieCase.sortMoviesByTitle();
                    break;
                case 2:
                    movieCase.sortMoviesByLength();
                    break;
                case 3:
                    movieCase.sortMoviesByRating();
                    break;
                case 4:
                    movieCase.sortMoviesByReleaseDate();
                    break;
                case 0:
                    return;
                default:
                    if(-1 >= option || option > movieCase.getMovieList().size() + 5) {
                        System.out.println("Please choose correct option!\n");
                    } else {
                        displayMovieData(option - 5);
                    }
                    break;
            }
        }
    }

    public void displayMovieData(int index) {
        System.out.println("\nTitle: " + movieCase.getMovie(index).getTitle());
        System.out.println("Length: " + movieCase.getMovie(index).getLength() + " minutes");
        System.out.println("Release Year: " + movieCase.getMovie(index).getReleaseYear());
        System.out.println("Rating: " + movieCase.getMovie(index).getRating());
        System.out.println("Cast:");
        for(Role<String, Actor> role : movieCase.getMovie(index).getCast()) {
            System.out.println(
                    role.getSecond().name()
                            + " " + role.getSecond().middleName()
                            + " " + role.getSecond().lastName()
                            + " as " + role.getFirst()
            );
        }

    }
}
