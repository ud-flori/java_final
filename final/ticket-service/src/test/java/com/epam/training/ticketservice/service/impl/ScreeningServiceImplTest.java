package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.dao.ScreeningDao;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;


class ScreeningServiceImplTest {

    private MovieDao movieDao;
    private ScreeningServiceImpl underTest;
    private AdminAccount admin;
    private ScreeningDao screeningDao;
    private MovieService movieCommandsService;
    private RoomService roomCommandsService;


    @BeforeEach
    void setUp(){
        screeningDao = Mockito.mock(ScreeningDao.class);
        movieCommandsService = Mockito.mock(MovieService.class);
        roomCommandsService = Mockito.mock(RoomService.class);
        admin = new AdminAccount();
        underTest = new ScreeningServiceImpl(screeningDao,admin,movieCommandsService,roomCommandsService);
    }




    @Test
    void testCreateScreeningWhenAdminSignedIn() throws ParseException {
        admin.signIn("admin","admin");

        String result = underTest.createScreening("Interstellar","Elm Street",
                "2021-12-30 15:00");

        assertEquals("",result);
    }

    @Test
    void testCreateScreeningWhenAdminSignedOut() throws ParseException {
        admin.signOut();

        String result = underTest.createScreening("Interstellar","Elm Street",
                "2021-12-30 15:00");

        assertEquals("Screening has not created.", result);
    }

    @Test
    void testListScreeningsWhenItsEmpty(){
        assertTrue(underTest.getAllScreenings().isEmpty());
    }

    @Test
    void testDeleteScreeningWhenAdminSignedOut() throws ParseException {
        admin.signOut();

        boolean result = underTest.deleteScreening("Interstellar", "Elm street", "2021-03-12 15:00");

        assertFalse(result);
    }

    @Test
    void testDeleteMovieWhenAdminSignedIn() throws ParseException {
        admin.signIn("admin","admin");

        boolean result = underTest.deleteScreening("Interstellar", "Elm street", "2021-03-12 15:00");

        assertTrue(result);
    }


}
