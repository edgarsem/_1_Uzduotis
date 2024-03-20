package org.example.UI;

import org.example.cases.CinemaCase;
import org.example.cases.MovieCase;
import org.example.cases.ScreeningCase;

import java.util.Scanner;

public class MenuScreen {
    private CinemaCase cinemaCase;
    private MovieCase movieCase;
    private ScreeningCase screeningCase;
    public MenuScreen(CinemaCase cinemaCase, MovieCase movieCase, ScreeningCase screeningCase) {
        this.cinemaCase = cinemaCase;
        this.movieCase = movieCase;
        this.screeningCase = screeningCase;
    }
    public void displayScreen() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("\033[H\033[2J");
            System.out.println("----------------{" + cinemaCase.getCurrentCinema().name + "}----------------");

            System.out.println("Choose cinema:");
            System.out.println("1. Movie list");
            System.out.println("2. Screenings list");
            System.out.println("0. Return");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    MovieScreen movieScreen = new MovieScreen(movieCase);
                    movieScreen.displayScreen();
                    break;
                case 2:

                    ScreeningsScreen screeningsScreen = new ScreeningsScreen(cinemaCase, movieCase, screeningCase);
                    screeningsScreen.displayScreen();
                    break;
                default:
                    System.out.println("Please choose correct option!\n");
                case 0:
                    return;
            }

        }
    }
}
