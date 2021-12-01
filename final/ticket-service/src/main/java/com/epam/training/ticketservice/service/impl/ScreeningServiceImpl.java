package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.ScreeningDao;
import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningDao screeningDao;

    @Autowired
    public ScreeningServiceImpl(ScreeningDao screeningDao) {
        this.screeningDao = screeningDao;
    }

    @Override
    public Flag createScreening(String movieTitle, String roomName, Date startDateAndTime, String token) {
        return null;
    }

    @Override
    public List<Screening> getAllScreenings() {
        return List.copyOf(screeningDao.readAll());
    }

    @Override
    public Flag updateScreening(String movieTitle, String roomName, Date startDateAndTime, String token) {
        return null;
    }

    @Override
    public Flag deleteScreening(String movieTitle, String roomName, Date startDateAndTime, String token) {
        return null;
    }
}
