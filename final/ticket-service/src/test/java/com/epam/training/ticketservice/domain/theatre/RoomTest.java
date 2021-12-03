package com.epam.training.ticketservice.domain.theatre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RoomTest {

    @Test
    public void testGetNameFunction(){
        Room underTest = new Room("Bestroom", 10, 10);

        assertEquals("Bestroom",underTest.getName());
    }

    @Test
    public void testGetRowFunction(){
        Room underTest = new Room("Bestroom", 10, 10);

        assertEquals(10,underTest.getRows());
    }

    @Test
    public void testGetColumnFunction(){
        Room underTest = new Room("Bestroom", 10, 10);

        assertEquals(10,underTest.getColumns());
    }

}