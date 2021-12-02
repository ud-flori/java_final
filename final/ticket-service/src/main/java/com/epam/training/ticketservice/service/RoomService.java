package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Room;

import java.util.List;

public interface RoomService {

    void createRoom(String name, int rows, int columns);

    List<Room> getAllRooms();

    void updateRoom(String name, int rows, int columns);

    void deleteRoom(String name);
}
