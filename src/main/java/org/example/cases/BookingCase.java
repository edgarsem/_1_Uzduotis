package org.example.cases;

import org.example.Exceptions.BookingEmptyException;
import org.example.Exceptions.BookingFullException;
import org.example.models.Screening;

public class BookingCase {
    private ScreeningCase screeningCase;
    private Screening currentScreening;
    private boolean isFull;
    private int tickedAmount = 0;
    private double fullCost = 0;

    public BookingCase() {
    }

    public BookingCase(Screening currentScreening, ScreeningCase screeningCase, boolean isFull) {
        this.currentScreening = currentScreening;
        this.screeningCase = screeningCase;
        this.isFull = isFull;
    }

    public void setCurrentScreening(Screening currentScreening) {
        this.currentScreening = currentScreening;
    }

    public void setScreeningService(ScreeningCase screeningCase) {
        this.screeningCase = screeningCase;
    }

    public Screening getCurrentScreening() {
        return currentScreening;
    }

    public void setIsFull(boolean isFull)
    {
        this.isFull = isFull;
    }

    public void addTicked() {
        tickedAmount++;
        fullCost += currentScreening.getCost();
    }

    public void subtractTicket() {
        if(tickedAmount > 0) {
            tickedAmount--;
            fullCost -= currentScreening.getCost();
        }
    }

    public int getTicketAmount() {
        return tickedAmount;
    }

    public double getFullCost() {
        return fullCost;
    }



    public void bookMovie() {
        if(tickedAmount == 0)
        {
            throw new BookingEmptyException("Your ticket cart is empty!");
        }
        else {
            for (Screening screening : screeningCase.getScreeningList()) {
                if (screening.equals(getCurrentScreening())) {
                    if (currentScreening.getBooked() + tickedAmount > currentScreening.hall().seatNumber()) {
                        throw new BookingFullException("Not enough available seats!");
                    } else {
                        screening.setBooked(screening.getBooked() + 1);
                    }
                }
            }
        }
    }

    public boolean getIsFull()
    {
        return isFull;
    }

}
