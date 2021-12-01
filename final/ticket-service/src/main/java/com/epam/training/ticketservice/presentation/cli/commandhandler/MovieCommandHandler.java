package com.epam.training.ticketservice.presentation.cli.commandhandler;


import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class MovieCommandHandler {

    private MovieService movieCommandsService;

    @Autowired
    public MovieCommandHandler(MovieService movieCommandsService) {
        this.movieCommandsService = movieCommandsService;
    }

    //TODO
    @ShellMethod(value = "create movie <film címe> <műfaj> <vetítés hossza percben>", key = "create movie")
    public String createMovie(String title, String genre, int length) {
        //return movieCommandsService.createMovie(title, genre, length);
        return "Alright";
    }

    @ShellMethod(value = "Lists all the movies", key = "list movies")
    public String listMovies() {
        List<Movie> movies = movieCommandsService.listMovies();

        if (movies.isEmpty()) {
            return "There are no movies at the moment";
        }

        StringBuilder output = new StringBuilder();
        for (Movie m : movies) {
            output.append(String.format("%s (%s, %d minutes)\n",
                    m.getTitle(), m.getGenre(), m.getLength()));
        }

        return output.toString();
    }

    //TODO
    @ShellMethod(value = "update movie <film címe> <műfaj> <vetítés hossza percben>", key = "update movie")
    public String updateMovie(String title, String genre, int length) {
        return "Alright";
    }

    //TODO
    @ShellMethod(value = "delete movie <film címe>", key = "delete movie")
    public String deleteMovie(String title) {
        return "Alright";
    }
}
