package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

class MovieServiceImplTest {

    private MovieDao movieDao;
    private UserValidator userValidator;
    private MovieServiceImpl underTest;

    @BeforeEach
    void setUp() {
        movieDao = Mockito.mock(MovieDao.class);
        userValidator = Mockito.mock(UserValidator.class);
        underTest = new MovieServiceImpl(movieDao, userValidator);
    }

    @Test
    void testCreateMovieReturnsSuccessfulBasicCommandResponse() {
        BasicCommandResponse result = underTest.createMovie("doesn't", "matter", 99, "token");

        assertTrue(result.isSuccessful());
    }

    @Test
    void testCreateMovieReturnsErrorMessageInBasicCommandResponseWhenTheUserISUnauthorized() throws AccessDeniedException {
        doThrow(AccessDeniedException.class).when(userValidator).authorizeAdmin("invalid token");
        BasicCommandResponse result = underTest.createMovie("doesn't", "matter", 99, "invalid token");

        assertFalse(result.isSuccessful());
    }

    @Test
    void testGetAllMoviesReturnsEmptyListWhenThereAreNoMovies() {
        Collection<Movie> coll = new ArrayList<>();
        given(movieDao.readAll()).willReturn(coll);

        assertNotNull(underTest.getAllMovies());
    }

    @Test
    void testUpdateMovieReturnsSuccessfulBasicCommandResponseWhenRunsSuccessfully() {
        BasicCommandResponse result = underTest.updateMovie("doesn't", "matter", 99, "token");

        assertTrue(result.isSuccessful());
    }

    @Test
    void testUpdateMovieReturnsErrorMessageInBasicCommandResponseWhenTheUserISUnauthorized() throws AccessDeniedException {
        doThrow(AccessDeniedException.class).when(userValidator).authorizeAdmin("invalid token");
        BasicCommandResponse result = underTest.updateMovie("doesn't", "matter", 99, "invalid token");

        assertFalse(result.isSuccessful());
    }

    @Test
    void testDeleteMovieReturnsSuccessfulBasicCommandResponseWhenRunsSuccessfully() {
        BasicCommandResponse result = underTest.deleteMovie("doesn't", "token");

        assertTrue(result.isSuccessful());
    }

    @Test
    void testDeleteMovieReturnsErrorMessageInBasicCommandResponseWhenTheUserISUnauthorized() throws AccessDeniedException {
        doThrow(AccessDeniedException.class).when(userValidator).authorizeAdmin("invalid token");
        BasicCommandResponse result = underTest.deleteMovie("doesn't","invalid token");

        assertFalse(result.isSuccessful());
    }
}