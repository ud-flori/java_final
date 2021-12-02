package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> listMovies();

    void createMovie(String title, String genre, int length);

    void updateMovie(String title, String genre, int length);

    void deleteMovie(String title);

}
