package com.epam.training.ticketservice.domain.theatre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    private Movie movie;
    private Room room;
    private Date date;


    @BeforeEach
    public void setUp() throws ParseException {
        movie = new Movie("Interstellar", "sci-fi", 120);
        room = new Room("Theroom", 5, 5);
        date =new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2021-12-30 15:00");

    }

    @Test
    public void testConstructor() {
        Screening underTest = new Screening(movie,room,date);
        assertNotNull(underTest);

    }


    @Test
    public void testGetMovieFunction(){
        Screening underTest = new Screening(movie,room,date);

        assertEquals("Interstellar",underTest.getMovie().getTitle());
    }

    @Test
    public void testGetRoomFunction(){
        Screening underTest = new Screening(movie,room,date);

        assertEquals("Theroom",underTest.getRoom().getName());
    }

    @Test
    void testGetStartDateAndTimeFunction() throws ParseException {
        Screening underTest = new Screening(movie, room, date);

        Date date = underTest.getStartDateAndTime();

        assertNotNull(date);
    }
}