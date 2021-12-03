package com.epam.training.ticketservice.presentation.cli.commandhandler;

import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RoomCommandHandlerTest {

    private RoomService roomService;
    private RoomCommandHandler underTest;

    @BeforeEach
    void setUp() {
        roomService = Mockito.mock(RoomService.class);
        underTest = new RoomCommandHandler(roomService);
    }

    @Test
    void testGetAllRoomsReturnsExactMessageWhenThereAreNoRooms() {
        given(roomService.getAllRooms()).willReturn(List.of());

        String result = underTest.listRooms();

        assertEquals("There are no rooms at the moment", result);
    }

    @Test
    void testGetAllRoomsReturnsFormattedRoomsWhenThereAreRooms() {
        given(roomService.getAllRooms()).willReturn(List.of(
                new Room("garázs", 2, 5)
        ));

        String result = underTest.listRooms();

        assertEquals("Room garázs with 10 seats, 2 rows and 5 columns\n", result);
    }

}