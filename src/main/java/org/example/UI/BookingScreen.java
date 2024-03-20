package org.example.UI;

import org.example.Exceptions.BookingEmptyException;
import org.example.Exceptions.BookingFullException;
import org.example.cases.BookingCase;
import org.example.cases.CinemaCase;
import org.example.cases.MovieCase;
import org.example.cases.ScreeningCase;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BookingScreen {

    private CinemaCase cinemaCase;
    private MovieCase movieCase;
    private ScreeningCase screeningCase;
    private BookingCase bookingCase;

    public BookingScreen(CinemaCase cinemaCase, MovieCase movieCase, ScreeningCase screeningCase, BookingCase bookingCase) {
        this.cinemaCase = cinemaCase;
        this.movieCase = movieCase;
        this.screeningCase = screeningCase;
        this.bookingCase = bookingCase;
    }
    public void displayScreen() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nChoose screening:");
            System.out.println("Title | Hall | Date | Booked | Cost");
            System.out.println(
                    bookingCase.getCurrentScreening().movie().getTitle() + " | "
            + bookingCase.getCurrentScreening().hall().hallNumber() + " | "
                            + bookingCase.getCurrentScreening().screeningTime().toString() + " | "
                            + bookingCase.getCurrentScreening().getBooked() + " | "
                            + bookingCase.getCurrentScreening().getCost()
            );
            if(bookingCase.getIsFull()) {
                System.out.println("The hall is full!");
            } else {
                System.out.println("Ticket amount: " + bookingCase.getTicketAmount());
                System.out.println("Full cost: " + bookingCase.getFullCost());
                System.out.println("1.Add ticked");
                System.out.println("2.Remove ticked");
                System.out.println("3.Book");
            }
            System.out.println("0. Return\n");

            int option = scanner.nextInt();
            if(!bookingCase.getIsFull()) {
                switch (option) {
                    case 0:
                        return;
                    case 1:
                        bookingCase.addTicked();
                        break;
                    case 2:
                        bookingCase.subtractTicket();
                        break;
                    case 3:
                        try {
                            bookingCase.bookMovie();
                            bookingMovieDisplay();
                            return;
                        } catch (BookingFullException | BookingEmptyException e) {
                            System.out.println(e);
                        }
                        break;
                    default:
                        System.out.println("Please choose correct option!\n");
                        break;
                }
            } else {
                if (option != 0) {
                        System.out.println("Please choose correct option!\n");
                }
                else {
                    return;
                }
            }

        }
    }

    public void bookingMovieDisplay() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.println("");
            System.out.println("+------------+");
            System.out.println("|            |");
            System.out.println("|+----------+|");
            System.out.print("||");
            for(int j = 0; j <= i; j++)
            {
                System.out.print("0");
            }
            for(int j = 9 - i; j > 0; j--)
            {
                System.out.print(" ");
            }
            System.out.println("||");
            System.out.println("|+----------+|");
            System.out.println("|            |");
            System.out.println("+------------+");
        }

    }


}