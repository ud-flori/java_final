package com.epam.training.ticketservice.dao.impl;

import com.epam.training.ticketservice.dao.ScreeningDao;
import com.epam.training.ticketservice.dao.repository.MovieRepository;
import com.epam.training.ticketservice.dao.repository.RoomRepository;
import com.epam.training.ticketservice.dao.repository.ScreeningRepository;
import com.epam.training.ticketservice.dao.repository.entity.MovieEntity;
import com.epam.training.ticketservice.dao.repository.entity.RoomEntity;
import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.domain.theatre.ScreeningInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ScreeningDaoImpl implements ScreeningDao {

    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;

    @Autowired
    public ScreeningDaoImpl(ScreeningRepository screeningRepository, MovieRepository movieRepository,
                            RoomRepository roomRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void createScreening(ScreeningInformation screening) {

    }

    @Override
    public Collection<Screening> readAll() {
        return StreamSupport.stream(screeningRepository.findAll().spliterator(), false)
                .map(entity -> {
                            MovieEntity movieEntity = movieRepository.findById(entity.getFilmTitle()).get();
                            RoomEntity roomEntity = roomRepository.findById(entity.getRoomName()).get();

                            return new Screening(
                                    new Movie(
                                            movieEntity.getTitle(),
                                            movieEntity.getGenre(),
                                            movieEntity.getLength()
                                    ),
                                    new Room(
                                            roomEntity.getName(),
                                            roomEntity.getRows(),
                                            roomEntity.getColumns()
                                    ),
                                    new Date(entity.getStartDateAndTime().getTime())
                            );
                        }
                ).collect(Collectors.toList());
    }

    @Override
    public void updateScreening(ScreeningInformation screening) {

    }

    @Override
    public void deleteScreening(ScreeningInformation screening) {

    }
}