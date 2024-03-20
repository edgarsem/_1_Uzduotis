package org.example.models;

public class Hall {
    private int hallNumber;
    private int seatNumber;

    public Hall(int hallNumber, int seatNumber) {
        this.hallNumber = hallNumber;
        this.seatNumber = seatNumber;
    }

    public int hallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int seatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
