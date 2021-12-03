package com.epam.training.ticketservice.domain.theatre;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningInformationTest {

    private ScreeningInformation underTest = new ScreeningInformation("Interstellar", "Roomone",
    new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2021-12-30 15:00"));

    ScreeningInformationTest() throws ParseException {
    }


    @Test
    void testGetMovieTitleFunction() throws ParseException {
        assertEquals("Interstellar", underTest.getMovieTitle());
    }

    @Test
    void testGetRoomNameFunction() throws ParseException {
        assertEquals("Roomone", underTest.getRoomName());
    }

    @Test
    void testGetStartDateAndTimeFunction() throws ParseException {
        assertNotNull(underTest.getStartDateAndTime());
    }
}