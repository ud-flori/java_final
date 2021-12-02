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
    }


    @Override
    public void createRoom(String name, int rows, int columns) {
        if(admin.isSignedIn()){
            roomDao.createRoom(new Room(name, rows, columns));
        }
    }

    @Override
    public List<Room> getAllRooms() {
        return List.copyOf(roomDao.readAll());
    }

    @Override
    public void updateRoom(String name, int rows, int columns) {
        if(admin.isSignedIn()){
            roomDao.updateRoom(new Room(name, rows, columns));
        }
    }

    @Override
    public void deleteRoom(String name) {
        if(admin.isSignedIn()){
            roomDao.deleteRoom(name);
        }
    }
}
