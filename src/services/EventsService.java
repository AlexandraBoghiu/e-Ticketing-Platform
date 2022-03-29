package services;

import events.Event;
import events.cultural.concerts.Concerts;
import events.cultural.movies.Movies;
import events.sports.football.FootballGames;
import locations.Locations;
import sponsor.Sponsor;
import sponsor.SponsorComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EventsService {
    ArrayList<Event> events = new ArrayList<Event>();
    static Integer id = 0;
    static Integer locationId = 0;

    public EventsService() {
    }

    public void createFootballGameEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        id++;
        locationId++;
        PriorityQueue<Sponsor> sponsors = new PriorityQueue<Sponsor>(1, new SponsorComparator());
        Locations location = new Locations(locationId, parametersArray[5], parametersArray[6], parametersArray[7]);
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        FootballGames footballGame = new FootballGames(id, parametersArray[0], Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors, parametersArray[7], parametersArray[8],
                parametersArray[9], parametersArray[10]);
        events.add(footballGame);
    }


    public void createConcertEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        id++;
        locationId++;
        PriorityQueue<Sponsor> sponsors = new PriorityQueue(1, new SponsorComparator());
        Locations location = new Locations(locationId, parametersArray[5], parametersArray[6], parametersArray[7]);
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        Concerts concert = new Concerts(id, parametersArray[0], Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors, Integer.valueOf(parametersArray[7]),
                parametersArray[8], parametersArray[9]);
        this.events.add(concert);
    }

    public void createMovieEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        id++;
        locationId++;
        PriorityQueue<Sponsor> sponsors = new PriorityQueue(1, new SponsorComparator());
        Locations location = new Locations(locationId, parametersArray[5], parametersArray[6], parametersArray[7]);
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        Movies movie = new Movies(id, parametersArray[0], Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors, Integer.valueOf(parametersArray[7]),
                parametersArray[8], parametersArray[9], Integer.valueOf(parametersArray[10]));
        this.events.add(movie);
    }

    public void updateFootballGameEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        Integer oldEventId = Integer.valueOf(parametersArray[0]);
        FootballGames eventToUpdate = (FootballGames) getEventById(oldEventId);
        Locations location = new Locations(locationId, parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
        eventToUpdate.setStadium(parametersArray[6]);
    }

    public void updateConcertEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        Integer oldEventId = Integer.valueOf(parametersArray[0]);
        Concerts eventToUpdate = (Concerts) getEventById(oldEventId);
        Locations location = new Locations(locationId, parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
        eventToUpdate.setTimeLength(Integer.valueOf(parametersArray[7]));
    }

    public void updateMovieEvent(String parameters) throws ParseException {
        String[] parametersArray = parameters.split(", ");
        Integer oldEventId = Integer.valueOf(parametersArray[0]);
        Movies eventToUpdate = (Movies) getEventById(oldEventId);
        Locations location = new Locations(locationId, parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
    }

    private void addEvent(Event event) {
        this.events.add(event);
    }

    public void getEvents() {
        if (this.events.size() == 0) {
            System.out.println("There are 0 events.");
        } else for (Event event : this.events) {
            System.out.println(event.getName());
        }
    }

    public void deleteEventById(Integer id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                this.events.remove(event);
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
        SponsorService sponsorService = new SponsorService();
        Sponsor sponsor = sponsorService.getSponsorById(sponsorId);
        Event event = getEventById(eventId);
        if (event != null)
            event.setSponsor(sponsor);
        else System.out.println(eventId + " does not exist.");
    }

    public void addLocationToEvent(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer locationId = Integer.valueOf(parametersArray[1]);
        Integer eventId = Integer.valueOf(parametersArray[0]);
        LocationService locationService = new LocationService();
        Locations location = locationService.getLocationById(locationId);
        Event event = getEventById(eventId);
        if (event != null)
            event.setLocation(location);
        else System.out.println(eventId + " does not exist.");
    }

}
