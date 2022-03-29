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
import java.time.LocalDate;
import java.util.*;

public class EventsService {
    ArrayList<Event> events = new ArrayList<Event>();
    static Integer id = 0;
    static Integer locationId = 0;

    public EventsService() {
    }

    public void createFootballGameEvent(String parameters) throws ParseException { //works
        // name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, address, firstTeam, secondTeam, stadium, competition
        String[] parametersArray = parameters.split(", ");
        //      System.out.println(Arrays.toString(parametersArray));
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


    public void createConcertEvent(String parameters) throws ParseException {  //works
        // name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
        // timeLength, artist, genre
        String[] parametersArray = parameters.split(", ");
        //   System.out.println(Arrays.toString(parametersArray));
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

    public void createMovieEvent(String parameters) throws ParseException { //works
        // (String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location,
        //                  PriorityQueue<Sponsor> sponsors, Integer timeLength, String genre, String director, Integer yearOfProduction)
        String[] parametersArray = parameters.split(", ");
        //    System.out.println(Arrays.toString(parametersArray));
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

    public void updateFootballGameEvent(String parameters) throws ParseException { //works
        // name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
        //                            "newAddress, newStadium
        String[] parametersArray = parameters.split(", ");
        String oldEventName = parametersArray[0];
        FootballGames eventToUpdate = (FootballGames) getEventByName(oldEventName);
        Locations location = new Locations(locationId, parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
        eventToUpdate.setStadium(parametersArray[6]);
    }

    public void updateConcertEvent(String parameters) throws ParseException { //works
        String[] parametersArray = parameters.split(", ");
        String oldEventName = parametersArray[0];
        Concerts eventToUpdate = (Concerts) getEventByName(oldEventName);
        Locations location = new Locations(locationId, parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
        eventToUpdate.setTimeLength(Integer.valueOf(parametersArray[7]));
    }

    public void updateMovieEvent(String parameters) throws ParseException { //works
        String[] parametersArray = parameters.split(", ");
        String oldEventName = parametersArray[0];
        Movies eventToUpdate = (Movies) getEventByName(oldEventName);
        Locations location = new Locations(locationId, parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void getEvents() { //works
        if (this.events.size() == 0) {
            System.out.println("There are 0 events.");
        } else for (Event event : this.events) {
            System.out.println(event.getName());
        }
    }

    public void deleteEventByName(String name) { //works
        for (Event event : events) {
            if (event.getName().equals(name)) {
                this.events.remove(event);
                System.out.println(event.getName() + " has been successfully removed.");
                break;
            }
        }
    }

    public Event getEventByName(String name) { //works
        for (Event event : events) {
            if (event.getName().equals(name))
                return event;
        }
        return null;
    }

    public Event getEventById(Integer id) { //works
        for (Event event : events) {
            if (event.getId().equals(id))
                return event;
        }
        return null;
    }

    public void addSponsor(Integer eventId, Integer sponsorId) {
        SponsorService sponsorService = new SponsorService();
        Sponsor sponsor = sponsorService.getSponsorById(sponsorId);
        Event event = getEventById(eventId);
        if (event != null)
            event.setSponsor(sponsor);
        else System.out.println(eventId + " does not exist.");
    }

    public void addLocation(Integer eventId, Integer locationId) {
        LocationService locationService = new LocationService();
        Locations location = locationService.getLocationById(locationId);
        Event event = getEventById(eventId);
        if (event != null)
            event.setLocation(location);
        else System.out.println(eventId + " does not exist.");
    }

}
