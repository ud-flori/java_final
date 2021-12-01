package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }


    @Override
    public List<Movie> listMovies() {
        return List.copyOf(movieDao.readAll());
    }

    @Override
    public Flag createMovie(String title, String genre, int length, String token) {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Flag updateMovie(String title, String genre, int length, String token) {
        return null;
    }

    @Override
    public Flag deleteMovie(String title, String token) {
        return null;
    }


}
