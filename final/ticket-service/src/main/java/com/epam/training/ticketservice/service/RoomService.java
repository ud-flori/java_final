package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.service.impl.Flag;

import java.util.List;

public interface RoomService {

    Flag createRoom(String name, int rows, int columns, String token);

    List<Room> getAllRooms();

    Flag updateRoom(String name, int rows, int columns, String token);

    Flag deleteRoom(String name, String token);
}
