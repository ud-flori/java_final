package com.epam.training.ticketservice.presentation.cli.commandhandler;

import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class MovieCommandHandlerTest {

    private MovieService movieService;
    private MovieCommandHandler underTest;

    @BeforeEach
    void setUp() {
        movieService = Mockito.mock(MovieService.class);
        underTest = new MovieCommandHandler(movieService);
    }

    @Test
    void testGetAllRoomsReturnsExactMessageWhenThereAreNoRooms() {
        given(movieService.listMovies()).willReturn(List.of());

        String result = underTest.listMovies();

        assertEquals("There are no movies at the moment", result);
    }

    @Test
    void testGetAllRoomsReturnsFormattedRoomsWhenThereAreRooms() {
        given(movieService.listMovies()).willReturn(List.of(
                new Movie("Interstellar", "sci-fi", 120)
        ));

        String result = underTest.listMovies();

        assertEquals("Interstellar (sci-fi, 120 minutes)\n", result);
    }

}