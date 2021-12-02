package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.ScreeningDao;
import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.service.ScreeningService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningDao screeningDao;
    private AdminAccount admin;


    @Autowired
    public ScreeningServiceImpl(ScreeningDao screeningDao, AdminAccount admin) {
        this.screeningDao = screeningDao;
        this.admin = admin;
    }

    @Override
    public void createScreening(String movieTitle, String roomName, Date startDateAndTime, String token) {
            //TODO
    }

    @Override
    public List<Screening> getAllScreenings() {
        return List.copyOf(screeningDao.readAll());
    }


    @Override
    public void deleteScreening(String movieTitle, String roomName, Date startDateAndTime, String token) {
        //TODO
    }
}
