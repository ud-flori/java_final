package com.epam.training.ticketservice.presentation.cli.commandhandler;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class RoomCommandHandler {

    @ShellMethod(value = "create room <terem neve> <széksorok száma> <szék oszlopok száma>", key = "create room")
    public String createRoom(String name, int rows, int columns) {
       return "Alright";
    }

    @ShellMethod(value = "Lists all the rooms", key = "list rooms")
    public String listRooms() {
        return "Alright";
    }

    @ShellMethod(value = "update room <terem neve> <széksorok száma> <szék oszlopok száma>", key = "update room")
    public String updateRoom(String name, int rows, int columns) {
        return "Alright";
    }

    @ShellMethod(value = "delete room <terem neve>", key = "delete room")
    public String deleteRoom(String name) {
        return "Alright";
    }
}
