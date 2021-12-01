package com.epam.training.ticketservice.domain.theatre;

import java.util.Calendar;

public final class Screening {

    private Movie movie;

    private Room room;

    private Calendar startDateAndTime;

    public Screening(Movie movie, Room room, Calendar startDateAndTime) {
        this.movie = movie;
        this.room = room;
        this.startDateAndTime = startDateAndTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public Calendar getStartDateAndTime() {
        return startDateAndTime;
    }
}
