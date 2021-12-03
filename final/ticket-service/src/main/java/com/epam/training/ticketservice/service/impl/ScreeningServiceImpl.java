package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.dao.MovieDao;
import com.epam.training.ticketservice.dao.ScreeningDao;
import com.epam.training.ticketservice.domain.theatre.Movie;
import com.epam.training.ticketservice.domain.theatre.Room;
import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.domain.theatre.ScreeningInformation;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.ScreeningService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningDao screeningDao;
    private AdminAccount admin;
    private MovieService movieCommandsService;
    private RoomService roomCommandsService;

    @Autowired
    public ScreeningServiceImpl(ScreeningDao screeningDao, AdminAccount admin, MovieService movieCommandService, RoomService roomCommandsService) {
        this.screeningDao = screeningDao;
        this.admin = admin;
        this.movieCommandsService = movieCommandService;
        this.roomCommandsService = roomCommandsService;
    }

    private void writeout(){
        List<Movie> movies = movieCommandsService.listMovies();
        String str = "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
        if (movies.isEmpty()) {
            str += "MOVIES DATABASE IS EMPTY!!!44!4!!!!44!!!";
        }
        StringBuilder output = new StringBuilder();
        for (Movie m : movies) {
            output.append(String.format("%s (%s, %d minutes)\n",
                    m.getTitle(), m.getGenre(), m.getLength()));
        }

        str += output.toString();

        List<Room> rooms = roomCommandsService.getAllRooms();

        if (rooms.isEmpty()) {
            str += "ROOMS DATABASE IS EMPTY!!!44!4!!!!44!!!";
        }

        output = new StringBuilder();
        for (Room r : rooms) {
            output.append(String.format("Room %s with %d seats, %d rows and %d columns\n",
                    r.getName(), r.getRows() * r.getColumns(), r.getRows(), r.getColumns()));
        }

        str += output.toString();

        List<Screening> screenings = getAllScreenings();

        if (screenings.isEmpty()) {
            str += "SCREENING DATABASE IS EMPTY!!!44!4!!!!44!!!";
        }

        output = new StringBuilder();
        for (int i = screenings.size() - 1; i >= 0; i--) {
            Screening sc = screenings.get(i);
            output.append(String.format("%s (%s, %d minutes), screened in room %s, at %s\n",
                    sc.getMovie().getTitle(), sc.getMovie().getGenre(), sc.getMovie().getLength(),
                    sc.getRoom().getName(),
                    (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(sc.getStartDateAndTime())));
        }

        str += output.toString();

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("C:\\Users\\flori\\menjmar.txt",true));
            writer.append(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
           return "";
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
