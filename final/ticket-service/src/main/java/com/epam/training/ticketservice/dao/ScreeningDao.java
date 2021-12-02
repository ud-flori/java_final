package com.epam.training.ticketservice.dao;

import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.domain.theatre.ScreeningInformation;

import java.util.Collection;

public interface ScreeningDao {

    void createScreening(ScreeningInformation screening);

    Collection<Screening> readAll();

    void deleteScreening(ScreeningInformation screening);

}
