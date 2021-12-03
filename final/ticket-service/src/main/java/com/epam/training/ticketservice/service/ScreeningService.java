package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.theatre.Screening;

import java.text.ParseException;
import java.util.List;

public interface ScreeningService {

    String createScreening(String movieTitle, String roomName, String startDateAndTime) throws ParseException;

    List<Screening> getAllScreenings();

    void deleteScreening(String movieTitle, String roomName, String startDateAndTime) throws  ParseException;
}
