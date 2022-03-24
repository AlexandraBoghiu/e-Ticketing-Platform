import services.EventsService;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        EventsService eventsService = new EventsService();
        String command, parameters;
        boolean ok = true;
        while (ok) {
            System.out.println("Please enter a command. Available commands: createFootballGameEvent, updateFootballGameEvent, getEvents, deleteEventByName ");
            command = scanner.nextLine();
            switch (command) {
                case "createFootballGameEvent":
                    System.out.println("You're creating a football game event. Please enter the event's data in the following format:" +
                            " name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, " +
                            "address, firstTeam, secondTeam, stadium, competition");
                    parameters = scanner.nextLine();
                    eventsService.createFootballGameEvent(parameters);
                    break;
                case "updateFootballGameEvent":
                    System.out.println("You're updating a football game event. Please enter the event's updated data in the following format:" +
                            " name, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                            "newAddress, newStadium\n If there is unchanged information, " +
                            "enter the old data for those fields. Note that the event name, teams and competition cannot be changed.");
                    parameters = scanner.nextLine();
                    eventsService.updateFootballGameEvent(parameters);
                    break;
                case "getEvents":
                    eventsService.getEvents();
                    break;
                case "deleteEventByName":
                    System.out.println("You're deleting an event. Please enter the event's name.");
                    String name = scanner.nextLine();
                    eventsService.deleteEventByName(name);
                    break;
                case "exit":
                    ok = false;
                    break;

            }
        }
    }
}
