package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.ScreeningDao;
import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.domain.theatre.ScreeningInformation;
import com.epam.training.ticketservice.service.ScreeningService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String createScreening(String movieTitle, String roomName, String startDateAndTimeString) throws ParseException {
        if (admin.isSignedIn()) {
            Date startDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDateAndTimeString);
            for (Screening sc : getAllScreenings()) {
                long timeDiff = (startDateAndTime.getTime() - sc.getStartDateAndTime().getTime()) / 60000;
                if (roomName.equals(sc.getRoom().getName())
                        && timeDiff >= 0
                        && timeDiff < sc.getMovie().getLength() + 10) {
                    if (timeDiff < sc.getMovie().getLength()) {
                        return "There is an overlapping screening";
                    }
                    return "This would start in the break period after another screening in this room";
                }

            }

            screeningDao.createScreening(new ScreeningInformation(movieTitle, roomName, startDateAndTime));
            return "Screening created";
        }
        return "Screening has not created.";
    }

    @Override
    public List<Screening> getAllScreenings() {
        return List.copyOf(screeningDao.readAll());
    }


    @Override
    public void deleteScreening(String movieTitle, String roomName, String startDateAndTimeString) throws ParseException {
        if (admin.isSignedIn()) {
            Date startDateAndTime =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDateAndTimeString);
            screeningDao.deleteScreening(new ScreeningInformation(movieTitle, roomName, startDateAndTime));
        }
    }
}
