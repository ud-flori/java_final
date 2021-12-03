package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Room;

import java.util.List;

public interface RoomService {

    boolean createRoom(String name, int rows, int columns);

    List<Room> getAllRooms();

    boolean updateRoom(String name, int rows, int columns);

    boolean deleteRoom(String name);
}
