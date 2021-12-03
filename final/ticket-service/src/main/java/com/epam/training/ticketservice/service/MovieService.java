package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> listMovies();

    boolean createMovie(String title, String genre, int length);

    boolean updateMovie(String title, String genre, int length);

    boolean deleteMovie(String title);

}
