package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.service.impl.Flag;

import java.util.Date;
import java.util.List;

public interface ScreeningService {

    Flag createScreening(String movieTitle, String roomName, Date startDateAndTime, String token);

    List<Screening> getAllScreenings();

    Flag updateScreening(String movieTitle, String roomName, Date startDateAndTime, String token);

    Flag deleteScreening(String movieTitle, String roomName, Date startDateAndTime, String token);
}
