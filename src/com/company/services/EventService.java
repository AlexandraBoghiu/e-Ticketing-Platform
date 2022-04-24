package com.company.services;

import com.company.models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class EventService {
    static private List<Event> events = new ArrayList<Event>();
    static private Integer id = 0;
    static private Integer locationId = 0;
    private static EventService instance = null;

    private EventService() {

    }
    public static EventService getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new EventService();
        return instance;
    }

    public void createFootballGameEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        id++;
        locationId++;
        TreeSet<Sponsor> sponsors = new TreeSet<Sponsor>(new SponsorComparator());
        Location location = new Location(locationId, parametersArray[7].trim(), parametersArray[5].trim(), parametersArray[6].trim());
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        FootballGame footballGame = new FootballGame(id, parametersArray[0].trim(), Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors, parametersArray[7].trim(), parametersArray[8].trim(),
                parametersArray[9].trim(), parametersArray[10].trim());
        events.add(footballGame);
    }


    public void createConcertEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        id++;
        locationId++;
        TreeSet<Sponsor> sponsors = new TreeSet<Sponsor>(new SponsorComparator());
        Location location = new Location(locationId, parametersArray[4].trim(), parametersArray[5].trim(), parametersArray[6].trim());
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        Concert concert = new Concert(id, parametersArray[0].trim(), Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors,
                parametersArray[7].trim(), parametersArray[8].trim());
        events.add(concert);
    }

    public void createMovieEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        id++;
        locationId++;
        TreeSet<Sponsor> sponsors = new TreeSet<Sponsor>(new SponsorComparator());
        Location location = new Location(locationId, parametersArray[4].trim(), parametersArray[5].trim(), parametersArray[6].trim());
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        Movie movie = new Movie(id, parametersArray[0].trim(), Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors,
                parametersArray[7].trim(), parametersArray[8].trim(), Integer.valueOf(parametersArray[9]));
        events.add(movie);
    }

    public void updateFootballGameEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        Integer oldEventId = Integer.valueOf(parametersArray[0]);
        FootballGame eventToUpdate = (FootballGame) getEventById(oldEventId);
        Location location = new Location(locationId, parametersArray[6].trim(), parametersArray[5].trim(), parametersArray[4].trim());
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
        eventToUpdate.setStadium(parametersArray[6].trim());
    }

    public void updateConcertEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        Integer oldEventId = Integer.valueOf(parametersArray[0]);
        Concert eventToUpdate = (Concert) getEventById(oldEventId);
        Location location = new Location(locationId, parametersArray[4].trim(), parametersArray[5].trim(), parametersArray[6].trim());
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
    }

    public void updateMovieEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        Integer oldEventId = Integer.valueOf(parametersArray[0]);
        Movie eventToUpdate = (Movie) getEventById(oldEventId);
        Location location = new Location(locationId, parametersArray[4].trim(), parametersArray[5].trim(), parametersArray[6].trim());
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
    }

    private void addEvent(Event event) {
        events.add(event);
    }

    public void getEvents() {
        if (events.size() == 0) {
            System.out.println("There are 0 models.events.");
        } else for (Event event : events) {
            System.out.println(event);
        }
    }

    public void deleteEventById(Integer id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                events.remove(event);
                System.out.println(event.getName() + " has been successfully removed.");
                break;
            }
        }
    }

    public Event getEventById(Integer id) {
        for (Event event : events) {
            if (event.getId().equals(id))
                return event;
        }
        return null;
    }

    public void addSponsorToEvent(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer sponsorId = Integer.valueOf(parametersArray[1]);
        Integer eventId = Integer.valueOf(parametersArray[0]);
        SponsorService sponsorService = SponsorService.getInstance();
        Sponsor sponsor = sponsorService.getSponsorById(sponsorId);
        Event event = getEventById(eventId);
        if (event != null)
            event.setSponsor(sponsor);
        else System.out.println(eventId + " does not exist.");
    }

}
