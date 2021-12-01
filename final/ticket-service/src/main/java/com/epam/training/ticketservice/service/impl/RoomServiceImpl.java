package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.RoomDao;
import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


    @Override
    public Flag createRoom(String name, int rows, int columns, String token) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return List.copyOf(roomDao.readAll());
    }

    @Override
    public Flag updateRoom(String name, int rows, int columns, String token) {
        return null;
    }

    @Override
    public Flag deleteRoom(String name, String token) {
        return null;
    }
}
