import services.ClientService;
import services.EventsService;
import services.LocationService;
import services.SponsorService;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        EventsService eventsService = new EventsService();
        ClientService clientService = new ClientService();
        SponsorService sponsorService = new SponsorService();
        LocationService locationService = new LocationService();
        String command, parameters;
        boolean ok = true;
        while (ok) {
            System.out.println("Please enter a command. Available commands: createClient, createFootballGameEvent, createConcertEvent, createMovieEvent, createSponsor," +
                    " updateClient, updateFootballGameEvent, updateConcertEvent, updateMovieEvent, updateSponsor, getEvents, getClients, getSponsors, deleteEventByName, exit ");
            command = scanner.nextLine();
            switch (command) {
                case "createClient":
                    System.out.println("You're creating a client. Please enter the client's data in the following format:" +
                            " firstName, lastName");
                    parameters = scanner.nextLine();
                    clientService.createClient(parameters);
                    break;
                case "createFootballGameEvent":
                    System.out.println("You're creating a football game event. Please enter the event's data in the following format:" +
                            " name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, " +
                            "address, firstTeam, secondTeam, stadium, competition");
                    parameters = scanner.nextLine();
                    eventsService.createFootballGameEvent(parameters);
                    break;
                case "createConcertEvent":
                    System.out.println("You're creating a concert event. Please enter the event's data in the following format:" +
                            " name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, " +
                            "address, timeLength, artist, genre");
                    parameters = scanner.nextLine();
                    eventsService.createConcertEvent(parameters);
                    break;
                case "createMovieEvent":
                    System.out.println("You're creating a movie event. Please enter the event's data in the following format:" +
                            " name, numberOfTickets, ticketPrice, date(day/month/year) time(HH:mm), country, city, " +
                            "address, timeLength, genre, director, yearOfProduction");
                    parameters = scanner.nextLine();
                    eventsService.createMovieEvent(parameters);
                    break;
                case "createSponsor":
                    System.out.println("You're creating a sponsor. Please enter the sponsor's data in the following format:" +
                            " name, type(gold/silver/bronze)");
                    parameters = scanner.nextLine();
                    sponsorService.createSponsor(parameters);
                    break;
                case "createLocation":
                    System.out.println("You're creating a location. Please enter the location's data in the following format:" +
                            " country, city, address");
                    parameters = scanner.nextLine();
                    locationService.createLocation(parameters);
                    break;
                case "updateClient":
                    System.out.println("You're updating a client. Please enter the client's updated data in the following format:" +
                            " id, firstName, lastName\n If there is unchanged information, enter the old data for those fields. Note that the client's id cannot be changed.");
                    parameters = scanner.nextLine();
                    clientService.updateClient(parameters);
                    break;
                case "updateFootballGameEvent":
                    System.out.println("You're updating a football game event. Please enter the event's updated data in the following format:" +
                            " name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                            "newAddress, newStadium\n If there is unchanged information, " +
                            "enter the old data for those fields. Note that the event's name, teams and competition cannot be changed.");
                    parameters = scanner.nextLine();
                    eventsService.updateFootballGameEvent(parameters);
                    break;
                case "updateConcertEvent":
                    System.out.println("You're updating a concert event. Please enter the event's updated data in the following format:" +
                            " name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                            "newAddress, newTimeLength\n If there is unchanged information, " +
                            "enter the old data for those fields. Note that the event's name, artist and genre cannot be changed.");
                    parameters = scanner.nextLine();
                    eventsService.updateConcertEvent(parameters);
                    break;
                case "updateMovieEvent":
                    System.out.println("You're updating a movie event. Please enter the event's updated data in the following format:" +
                            " name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                            "newAddress\n If there is unchanged information, " +
                            "enter the old data for those fields. Note that the event's name, artist and genre cannot be changed.");
                    parameters = scanner.nextLine();
                    eventsService.updateMovieEvent(parameters);
                    break;
                case "updateSponsor":
                    System.out.println("You're updating a sponsor. Please enter the sponsor's updated data in the following format:" +
                            " id, name, type. Note that the sponsor's id cannot be changed.");
                    parameters = scanner.nextLine();
                    sponsorService.updateSponsor(parameters);
                    break;
                case "getEvents":
                    eventsService.getEvents();
                    break;
                case "getClients":
                    clientService.getClients();
                    break;
                case "getSponsors":
                    sponsorService.getSponsors();
                    break;
                case "getSponsorsByType":
                    System.out.println("Please enter the desired type(gold/silver/bronze).");
                    parameters = scanner.next();
                    sponsorService.getSponsorsByType(parameters);
                    break;
                case "deleteEventByName":
                    System.out.println("You're deleting an event. Please enter the event's name.");
                    String name = scanner.nextLine();
                    eventsService.deleteEventByName(name);
                    break;
                case "deleteClientById":
                    System.out.println("You're deleting a client. Please enter the client's id.");
                    Integer clientId = Integer.valueOf(scanner.next());
                    clientService.deleteClientById(clientId);
                    break;
                case "deleteSponsorById":
                    System.out.println("You're deleting a sponsor. Please enter the sponsor's id.");
                    Integer sponsorId = Integer.valueOf(scanner.next());
                    sponsorService.deleteSponsorById(sponsorId);
                    break;
                case "exit":
                    ok = false;
                    break;

            }
        }
    }
}
