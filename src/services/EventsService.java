package services;

import events.Event;
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

    public EventsService() {
    }

    public EventsService(ArrayList<Event> events) {
        this.events = events;
    }

    public void createFootballGameEvent(String parameters) throws ParseException {
        // name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, address, firstTeam, secondTeam, stadium, competition
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        PriorityQueue<Sponsor> sponsors = new PriorityQueue<Sponsor>(1, new SponsorComparator());
        Locations location = new Locations(parametersArray[5], parametersArray[6], parametersArray[7]);
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        FootballGames footballGame = new FootballGames(parametersArray[0], Integer.valueOf(parametersArray[1]),
                Double.parseDouble(parametersArray[2]), eventDate, location, sponsors, parametersArray[7], parametersArray[8],
                parametersArray[9], parametersArray[10]);
        events.add(footballGame);
    }

    public void updateFootballGameEvent(String parameters) throws ParseException {
        // name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
        //                            "newAddress, newStadium
        String[] parametersArray = parameters.split(", ");
        String oldEventName = parametersArray[0];
        FootballGames eventToUpdate = (FootballGames) getEventByName(oldEventName);
        Locations location = new Locations(parametersArray[4], parametersArray[5], parametersArray[6]);
        Date eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parametersArray[3]);
        eventToUpdate.setDate(eventDate);
        eventToUpdate.setLocation(location);
        eventToUpdate.setTicketPrice(Double.parseDouble(parametersArray[2]));
        eventToUpdate.setNumberOfTickets(Integer.valueOf(parametersArray[1]));
        eventToUpdate.setStadium(parametersArray[6]);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void getEvents() {
        if (this.events.size() == 0) {
            System.out.println("There are 0 events.");
        } else for (Event event : this.events) {
            System.out.println(event.getName());
        }
    }

    public void deleteEventByName(String name) {
        for (Event event : events) {
            if (event.getName().equals(name)) {
                this.events.remove(event);
                System.out.println(event.getName() + " has been succesfully removed.");
                break;
            }
        }
    }

    private Event getEventByName(String name) {
        for (Event event : events) {
            if (event.getName().equals(name))
                return event;
        }
        return null;
    }

    public void addSponsor(String eventName, Sponsor sponsor) {
        Event event = getEventByName(eventName);
        if (event != null)
            event.addSponsor(sponsor);
        else System.out.println("Nu exista eventul " + eventName);

    }
}
