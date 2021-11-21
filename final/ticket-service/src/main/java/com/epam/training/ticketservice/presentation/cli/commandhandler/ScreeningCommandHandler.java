package com.epam.training.ticketservice.presentation.cli.commandhandler;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ScreeningCommandHandler {

    @ShellMethod(value = "create screening <film címe> <terem neve> <vetítés kezdetének dátuma és ideje, "
            + "YYYY-MM-dd HH:mm formátumban>", key = "create screening")
    public String createScreening(String movieTitle, String roomName, String startDateAndTime) {
        return "Alright";
    }

    @ShellMethod(value = "Lists all the screenings", key = "list screenings")
    public String listScreenings() {
        return "Alright";
    }

    @ShellMethod(value = "delete screening <film címe> <terem neve> <vetítés kezdetének dátuma és ideje, "
            + "YYYY-MM-dd HH:mm formátumban>", key = "delete screening")
    public String deleteScreening(String movieTitle, String roomName, String startDateAndTime) {
        return "Alright";
    }
}
