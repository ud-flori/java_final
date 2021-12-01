package com.epam.training.ticketservice.dao.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ScreeningId implements Serializable {

    private String filmTitle;
    private String roomName;
    private Timestamp startDateAndTime;

    public ScreeningId() {
    }

    public ScreeningId(String filmTitle, String roomName, Timestamp startDateAndTime) {
        this.filmTitle = filmTitle;
        this.roomName = roomName;
        this.startDateAndTime = startDateAndTime;
    }


}