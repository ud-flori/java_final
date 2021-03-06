package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.RoomDao;
import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao;
    private AdminAccount admin;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao, AdminAccount admin) {
        this.roomDao = roomDao;
        this.admin = admin;
    }


    @Override
    public boolean createRoom(String name, int rows, int columns) {
        if (admin.isSignedIn()) {
            roomDao.createRoom(new Room(name, rows, columns));
            return true;
        }
        return false;
    }

    @Override
    public List<Room> getAllRooms() {
        return List.copyOf(roomDao.readAll());
    }

    @Override
    public boolean updateRoom(String name, int rows, int columns) {
        if (admin.isSignedIn()) {
            roomDao.updateRoom(new Room(name, rows, columns));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String name) {
        if (admin.isSignedIn()) {
            roomDao.deleteRoom(name);
            return true;
        }
        return false;
    }
}
