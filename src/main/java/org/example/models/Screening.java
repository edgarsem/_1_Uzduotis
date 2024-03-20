package org.example.models;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private LocalDateTime screeningTime;
    private Hall hall;
    private int booked;
    private double cost;

    public Screening(Movie movie, LocalDateTime screeningTime, Hall hall, int booked, double cost) {
        this.movie = movie;
        this.screeningTime = screeningTime;
        this.hall = hall;
        this.booked = booked;
        this.cost = cost;
    }

    public Movie movie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime screeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(LocalDateTime screeningTime) {
        this.screeningTime = screeningTime;
    }

    public Hall hall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public int getBooked() { return booked; }
    public void setBooked(int booked) {
        this.booked = booked;
    }
    public double getCost() { return cost; }
    public void setCost(double cost) {
        this.cost = cost;
    }
}
