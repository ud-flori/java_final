package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.dao.RoomDao;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceImplTest {

    private RoomDao roomDao;
    private RoomServiceImpl underTest;
    private AdminAccount admin;

    @BeforeEach
    void setUp(){
        roomDao = Mockito.mock(RoomDao.class);
        admin = new AdminAccount();
        underTest = new RoomServiceImpl(roomDao,admin);
    }




    @Test
    void testCreateRoomWhenAdminSignedIn() {
        admin.signIn("admin","admin");

        boolean result = underTest.createRoom("Elm street",13, 13);

        assertTrue(result);

    }

    @Test
    void testCreateRoomWhenAdminSignedOut(){
        admin.signOut();

        boolean result = underTest.createRoom("Elm street",13, 13);

        assertFalse(result);
    }

    @Test
    void testListRoomsWhenItsEmpty(){
        assertTrue(underTest.getAllRooms().isEmpty());
    }

    @Test
    void testUpdateRoomWhenAdminSignedOut(){
        admin.signOut();

        assertFalse(underTest.updateRoom("Elm street",13, 13));
    }

    @Test
    void testUpdateRoomWhenAdminSignedIn(){
        admin.signIn("admin","admin");

        assertTrue(underTest.updateRoom("Elm street",13, 13));
    }

    @Test
    void testDeleteMovieWhenAdminSignedOut(){
        admin.signOut();

        assertFalse(underTest.deleteRoom("Elm street"));
    }

    @Test
    void testDeleteMovieWhenAdminSignedIn(){
        admin.signIn("admin","admin");

        assertTrue(underTest.deleteRoom("Elm street"));
    }

}