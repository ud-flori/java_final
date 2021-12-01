package com.epam.training.ticketservice.dao.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.dao.repository.MovieRepository;
import com.epam.training.ticketservice.domain.theatre.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieDaoImpl implements MovieDao {



    private MovieRepository movieRepository;

    @Autowired
    public MovieDaoImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void createMovie(Movie movie) {

    }

    @Override
    public Collection<Movie> readAll() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(),false)
                .map(entity -> new Movie(
                        entity.getTitle(),
                        entity.getGenre(),
                        entity.getLength()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(String title) {

    }

}
