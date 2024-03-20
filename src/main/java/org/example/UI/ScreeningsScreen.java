package org.example.UI;

import org.example.models.Screening;
import org.example.cases.BookingCase;
import org.example.cases.CinemaCase;
import org.example.cases.MovieCase;
import org.example.cases.ScreeningCase;

import java.util.Scanner;

public class ScreeningsScreen {
    private CinemaCase cinemaCase;


    private BookingCase bookingCase = new BookingCase();
    private MovieCase movieCase;

    private ScreeningCase screeningCase;

    public ScreeningsScreen(CinemaCase cinemaCase, MovieCase movieCase, ScreeningCase screeningCase) {
        this.cinemaCase = cinemaCase;
        this.movieCase = movieCase;
        this.screeningCase = screeningCase;
    }

    public void displayScreen() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nChoose screening:");
            System.out.println("Title | Hall | Date | Booked");
            for(int i = 0; i < cinemaCase.getCurrentCinema().screeningList.size(); i++) {
                System.out.println((i + 1) + ". "
                        + cinemaCase.getCurrentCinema().screeningList.get(i).movie().getTitle() + " | "
                        + cinemaCase.getCurrentCinema().screeningList.get(i).hall().hallNumber() + " | "
                        + cinemaCase.getCurrentCinema().screeningList.get(i).screeningTime().toString() + " | "
                        + cinemaCase.getCurrentCinema().screeningList.get(i).getBooked() + "/"
                        + cinemaCase.getCurrentCinema().screeningList.get(i).hall().seatNumber()
                );
            }
            System.out.println("0. Return.\n");

            int option = scanner.nextInt();
            if(option == 0) {
                return;
            } else if(-1 >= option - 1 || option > cinemaCase.getCurrentCinema().screeningList.size()) {
                System.out.println("Please choose correct option!\n");
            } else {
                bookingCase.setCurrentScreening(cinemaCase.getCurrentCinema().screeningList.get(option - 1));
                bookingCase.setScreeningService(screeningCase);
                bookingCase.setIsFull(isFull(bookingCase.getCurrentScreening()));
                BookingScreen bookingScreen = new BookingScreen(cinemaCase, movieCase, screeningCase, bookingCase);
                bookingScreen.displayScreen();
            }

        }
    }

    public boolean isFull(Screening screening) {
        if(screening.getBooked() >= screening.hall().seatNumber()) return true;
        return false;
    }

    public void displayScreenings(int index) {


    }
}
