package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Screening;

import java.util.Date;
import java.util.List;

public interface ScreeningService {

    void createScreening(String movieTitle, String roomName, Date startDateAndTime, String token);

    List<Screening> getAllScreenings();

    void deleteScreening(String movieTitle, String roomName, Date startDateAndTime, String token);
}
