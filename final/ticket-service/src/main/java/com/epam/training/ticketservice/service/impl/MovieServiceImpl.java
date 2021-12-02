package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieDao movieDao;
    private AdminAccount admin;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao, AdminAccount admin) {
        this.movieDao = movieDao;
        this.admin = admin;
    }


    @Override
    public List<Movie> listMovies() {
        return List.copyOf(movieDao.readAll());
    }

    @Override
    public void createMovie(String title, String genre, int length) {
        if(admin.isSignedIn()) {
            movieDao.createMovie(new Movie(title, genre, length));
        }
    }

    @Override
    public void updateMovie(String title, String genre, int length) {
        if(admin.isSignedIn()) {
            movieDao.updateMovie(new Movie(title, genre, length));
        }
    }

    @Override
    public void deleteMovie(String title) {
        if(admin.isSignedIn()) {
            movieDao.deleteMovie(title);
        }
    }


}
