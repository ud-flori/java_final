package com.epam.training.ticketservice.presentation.cli.commandhandler;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MovieCommandHandler {

    @ShellMethod(value = "create movie <film címe> <műfaj> <vetítés hossza percben>", key = "create movie")
    public String createMovie(String title, String genre, int length) {
        return "Alright";
    }

    @ShellMethod(value = "Lists all the movies", key = "list movies")
    public String listMovies() {
        return "Alright";
    }

    @ShellMethod(value = "update movie <film címe> <műfaj> <vetítés hossza percben>", key = "update movie")
    public String updateMovie(String title, String genre, int length) {
        return "Alright";
    }

    @ShellMethod(value = "delete movie <film címe>", key = "delete movie")
    public String deleteMovie(String title) {
        return "Alright";
    }
}
