package com.epam.training.ticketservice.dao.impl;

import com.epam.training.ticketservice.dao.RoomDao;
import com.epam.training.ticketservice.dao.repository.RoomRepository;
import com.epam.training.ticketservice.dao.repository.entity.RoomEntity;
import com.epam.training.ticketservice.domain.theatre.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class RoomDaoImpl implements RoomDao {

    private RoomRepository roomRepository;

    @Autowired
    public RoomDaoImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void createRoom(Room room) {
        roomRepository.save(new RoomEntity(
                room.getName(),
                room.getRows(),
                room.getColumns()
        ));
    }

    @Override
    public Collection<Room> readAll() {
        return StreamSupport.stream(roomRepository.findAll().spliterator(),false)
                .map(entity -> new Room(
                        entity.getName(),
                        entity.getRows(),
                        entity.getColumns()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateRoom(Room room) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(room.getName());
        roomEntity.ifPresent(entity -> {
            entity.setRows(room.getRows());
            entity.setColumns(room.getColumns());
            roomRepository.save(entity);
        });
    }

    @Override
    public void deleteRoom(String name) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(name);
        roomEntity.ifPresent(entity -> roomRepository.delete(entity));
    }
}
