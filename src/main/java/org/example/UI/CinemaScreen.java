package org.example.UI;

import org.example.Exceptions.MovieNotFoundException;
import org.example.cases.CinemaCase;
import org.example.cases.MovieCase;
import org.example.cases.ScreeningCase;

import java.util.Scanner;

public class CinemaScreen {
    private CinemaCase cinemaCase;

    private MovieCase movieCase;
    private ScreeningCase screeningCase;

    public CinemaScreen(CinemaCase cinemaCase, MovieCase movieCase, ScreeningCase screeningCase) {
        this.cinemaCase = cinemaCase;
        this.movieCase = movieCase;
        this.screeningCase = screeningCase;
    }
    public void displayScreen() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Choose cinema:");
            for(int i = 0; i < cinemaCase.getCinemaList().size(); i++) {
                System.out.println((i + 1) + ". " + cinemaCase.getCinema(i).name + " / " + cinemaCase.getCinema(i).address);
            }
            System.out.println("3. Find screenings");
            System.out.println("0. Log out.\n");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    return;
                case 3:
                    findMovieDisplay();
                    break;
                default:
                    if(-1 >= option || option > cinemaCase.getCinemaList().size()) {
                        System.out.println("Please choose correct option!\n");
                    } else {
                        cinemaCase.setCurrentCinema(cinemaCase.getCinema(option - 1));
                        MenuScreen menuScreen = new MenuScreen(cinemaCase, movieCase, screeningCase);
                        menuScreen.displayScreen();
                    }
                    break;
            }
        }
    }

    public void findMovieDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in movie title: ");
        String movieTitle = scanner.nextLine();
        try {
            for (String screening : cinemaCase.findScreenings(movieTitle))
            {
                System.out.println(screening);
            }
        } catch (MovieNotFoundException e)
        {
            System.out.println(e);
        }

    }
}
