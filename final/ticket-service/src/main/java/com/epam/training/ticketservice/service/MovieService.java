package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.service.impl.Flag;

import java.util.List;

public interface MovieService {

    List<Movie> listMovies();

    Flag createMovie(String title, String genre, int length, String token);

    List<Movie> getAllMovies();

    Flag updateMovie(String title, String genre, int length, String token);

    Flag deleteMovie(String title, String token);

}
