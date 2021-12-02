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


    @ShellMethod(value = "create movie <film címe> <műfaj> <vetítés hossza percben>", key = "create movie")
    public void createMovie(String title, String genre, int length) {
        movieCommandsService.createMovie(title, genre, length);
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
    public void updateMovie(String title, String genre, int length) {
        movieCommandsService.updateMovie(title,genre,length);
    }

    //TODO
    @ShellMethod(value = "delete movie <film címe>", key = "delete movie")
    public void deleteMovie(String title) {
        movieCommandsService.deleteMovie(title);
    }
}
