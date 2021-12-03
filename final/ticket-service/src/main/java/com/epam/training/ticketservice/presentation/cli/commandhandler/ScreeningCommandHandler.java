package com.epam.training.ticketservice.presentation.cli.commandhandler;


import com.epam.training.ticketservice.domain.theatre.Screening;
import com.epam.training.ticketservice.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@ShellComponent
public class ScreeningCommandHandler {

    private ScreeningService screeningCommandService;

    @Autowired
    public ScreeningCommandHandler(ScreeningService screeningCommandsService) {
        this.screeningCommandService = screeningCommandsService;
    }

    @ShellMethod(value = "create screening <film címe> <terem neve> <vetítés kezdetének dátuma és ideje, "
            + "YYYY-MM-dd HH:mm formátumban>", key = "create screening")
    public String createScreening(String movieTitle, String roomName, String startDateAndTime) throws ParseException {
        return screeningCommandService.createScreening(movieTitle,roomName,startDateAndTime);

    }

    @ShellMethod(value = "Lists all the screenings", key = "list screenings")
    public String listScreenings() {
        List<Screening> screenings = screeningCommandService.getAllScreenings();

        if (screenings.isEmpty()) {
            return "There are no screenings";
        }

        StringBuilder output = new StringBuilder();
        for (int i = screenings.size() - 1; i >= 0; i--) {
            Screening sc = screenings.get(i);
            output.append(String.format("%s (%s, %d minutes), screened in room %s, at %s\n",
                    sc.getMovie().getTitle(), sc.getMovie().getGenre(), sc.getMovie().getLength(),
                    sc.getRoom().getName(),
                    (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(sc.getStartDateAndTime())));
        }

        return output.toString();

    }

    @ShellMethod(value = "delete screening <film címe> <terem neve> <vetítés kezdetének dátuma és ideje, "
            + "YYYY-MM-dd HH:mm formátumban>", key = "delete screening")
    public void deleteScreening(String movieTitle, String roomName, String startDateAndTime) throws ParseException {
        screeningCommandService.deleteScreening(movieTitle,roomName,startDateAndTime);
    }
}
