package services;

import client.Client;
import events.Event;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.Arrays;

public class ClientService {
    ArrayList<Client> clients = new ArrayList<Client>();
    static Integer id = 0;

    public void createClient(String parameters) { //works
        id++;
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Client client = new Client(id, parametersArray[0], parametersArray[1], tickets);
        System.out.println(client);
        clients.add(client);
    }
    public void updateClient(String parameters) { //works
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Client client = getClientById(Integer.parseInt(parametersArray[0]));
        client.setFirstName(parametersArray[1]);
        client.setLastName(parametersArray[2]);
    }
    private Client getClientById(Integer clientId) { //works
        for (Client client : clients) {
            if (client.getId().equals(clientId))
                return client;
        }
        return null;
    }
    public void getClients() { //works
        if (this.clients.size() == 0) {
            System.out.println("There are 0 clients :(.");
        } else for (Client client : this.clients) {
            System.out.println(client);
        }
    }
    public void deleteClientById(Integer id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                this.clients.remove(client);
                System.out.println(client + " has been successfully removed.");
                break;
            }
        }
    }


    public void buyTicket(Integer clientId, Integer eventId) {
        EventsService eventsService = new EventsService();
        Event event = eventsService.getEventById(eventId);
        Client client = this.getClientById(clientId);
        if (event != null) {
            if (event != null) {
                if (event.getNumberOfTickets() > 0) {
                    Ticket ticket = new Ticket(event);
                    event.setNumberOfTickets(event.getNumberOfTickets() - 1);
                    client.getTickets().add(ticket);

                } else System.out.println("No more tickets available for this event.");
            } else System.out.println("The event " + eventId + " does not exist.");
        } else System.out.println("The client " +clientId + " does not exist.");
    }
    // public void buyTicket()
}
