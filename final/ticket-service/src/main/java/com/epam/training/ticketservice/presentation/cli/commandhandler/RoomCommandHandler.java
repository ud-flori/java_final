package com.epam.training.ticketservice.presentation.cli.commandhandler;

import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class RoomCommandHandler {

    private RoomService roomCommandsService;

    @Autowired
    public RoomCommandHandler(RoomService roomCommandsService) {
        this.roomCommandsService = roomCommandsService;
    }

    @ShellMethod(value = "create room <terem neve> <széksorok száma> <szék oszlopok száma>", key = "create room")
    public void createRoom(String name, int rows, int columns) {
        roomCommandsService.createRoom(name,rows,columns);
    }

    @ShellMethod(value = "Lists all the rooms", key = "list rooms")
    public String listRooms() {
        List<Room> rooms = roomCommandsService.getAllRooms();

        if (rooms.isEmpty()) {
            return "There are no rooms at the moment";
        }

        StringBuilder output = new StringBuilder();
        for (Room r : rooms) {
            output.append(String.format("Room %s with %d seats, %d rows and %d columns\n",
                    r.getName(), r.getRows() * r.getColumns(), r.getRows(), r.getColumns()));
        }

        return output.toString();
    }


    @ShellMethod(value = "update room <terem neve> <széksorok száma> <szék oszlopok száma>", key = "update room")
    public void updateRoom(String name, int rows, int columns) {
        roomCommandsService.updateRoom(name,rows,columns);
    }

    @ShellMethod(value = "delete room <terem neve>", key = "delete room")
    public void deleteRoom(String name) {
        roomCommandsService.deleteRoom(name);
    }
}
