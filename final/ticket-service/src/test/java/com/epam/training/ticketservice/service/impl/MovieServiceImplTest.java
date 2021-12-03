package com.epam.training.ticketservice.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doCallRealMethod;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.dao.impl.MovieDaoImpl;
import com.epam.training.ticketservice.dao.repository.MovieRepository;
import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

class MovieServiceImplTest {

    private MovieDao movieDao;
    private MovieServiceImpl underTest;
    private AdminAccount admin;

    @BeforeEach
    void setUp(){
        movieDao = Mockito.mock(MovieDao.class);
        admin = new AdminAccount();
        underTest = new MovieServiceImpl(movieDao,admin);
    }




    @Test
    void testCreateMovieWhenAdminSignedIn() {
        admin.signIn("admin","admin");

        boolean result = underTest.createMovie("Interstellar","sci-fi", 120);

        assertTrue(result);

    }

    @Test
    void testCreateMovieWhenAdminSignedOut(){
        admin.signOut();

        boolean result = underTest.createMovie("Interstellar","sci-fi", 120);

        assertFalse(result);
    }

    @Test
    void testListMoviesWhenItsEmpty(){
        assertTrue(underTest.listMovies().isEmpty());
    }

    @Test
    void testUpdateMovieWhenAdminSignedOut(){
        admin.signOut();

        assertFalse(underTest.updateMovie("Interstellar", "horror", 150));
    }

    @Test
    void testUpdateMovieWhenAdminSignedIn(){
        admin.signIn("admin","admin");

        assertTrue(underTest.updateMovie("Interstellar","horror", 120));
    }

    @Test
    void testDeleteMovieWhenAdminSignedOut(){
        admin.signOut();

        assertFalse(underTest.deleteMovie("Interstellar"));
    }

    @Test
    void testDeleteMovieWhenAdminSignedIn(){
        admin.signIn("admin","admin");

        assertTrue(underTest.deleteMovie("Interstellar"));
    }

}
