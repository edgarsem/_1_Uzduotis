package org.example;

import org.example.UI.CinemaScreen;
import org.example.cases.CinemaCase;
import org.example.cases.MovieCase;
import org.example.cases.ScreeningCase;

public class Main {
    private static MovieCase movieCase = new MovieCase();
    private static ScreeningCase screeningCase = new ScreeningCase(movieCase);
    private static CinemaCase cinemaCase = new CinemaCase(screeningCase);
    public static void main(String[] args) throws InterruptedException {
        CinemaScreen cinemaScreen = new CinemaScreen(cinemaCase, movieCase, screeningCase);
        cinemaScreen.displayScreen();
    }
}