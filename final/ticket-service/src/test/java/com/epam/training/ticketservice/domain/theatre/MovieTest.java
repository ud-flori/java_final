package com.epam.training.ticketservice.domain.theatre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    @Test
    public void testGetTitleFunction(){
        Movie underTest = new Movie("Interstellar", "sci-fi", 120);

        assertEquals("Interstellar",underTest.getTitle());
    }

    @Test
    public void testGetGenreFunction(){
        Movie underTest = new Movie("Interstellar", "sci-fi", 120);

        assertEquals("sci-fi",underTest.getGenre());
    }

    @Test
    public void testGetLengthFunction(){
        Movie underTest = new Movie("Interstellar", "sci-fi", 120);

        assertEquals(120,underTest.getLength());
    }

}