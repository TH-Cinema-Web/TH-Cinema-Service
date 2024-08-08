package com.example.casem3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private int id;
    private Movie movie;
    private LocalDate date;
    private LocalTime time;
    private int seats;

    public Ticket(Movie movie, LocalDate date, LocalTime time, int seats) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.seats = seats;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
