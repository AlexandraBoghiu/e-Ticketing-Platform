package com.company.services;

import com.company.models.Client;
import com.company.models.Event;
import com.company.models.Ticket;
import com.company.repository.ClientRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientService {
    private static List<Client> clients = new ArrayList<Client>();
    private static Integer id = 0;
    private static ClientService instance = null;
    ClientRepository clientRepository = ClientRepository.getInstance();

    private ClientService() throws IOException {

    }

    public static ClientService getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new ClientService();
        return instance;
    }

    public Client createClient(List<String[]> parametersArray, boolean fromCsv, boolean print) {
        id++;
        List<Ticket> tickets = new ArrayList<Ticket>();

        if (fromCsv) {
            try {
                Client client = new Client(parametersArray.get(id)[1].trim(), parametersArray.get(id)[2].trim(), tickets);
                clients.add(client);
                clientRepository.addClient(client);
                if (print)
                    System.out.println("Client added succesfully. Id: " + id.toString() + "\n");
                return client;
            } catch (Exception e) {
                System.out.println("Not enough data in the csv file.");
            }
        } else {
            try {
                Client client = new Client(parametersArray.get(0)[0].trim(), parametersArray.get(0)[1].trim(), tickets);
                clients.add(client);
                clientRepository.addClient(client);
                if (print)
                    System.out.println("Client added succesfully. Id: " + id.toString() + "\n");
                return client;
            } catch (Exception e) {
                System.out.println("Invalid.");
            }
        }
        return null;
    }

    public void updateClient(String parameters) {
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Client client = getClientById(Integer.parseInt(parametersArray[0]));
        client.setFirstName(parametersArray[1].trim());
        client.setLastName(parametersArray[2].trim());
        System.out.println("Client updated succesfully.\n");
    }

    private Client getClientById(Integer clientId) {
        for (Client client : clients) {
            if (client.getId().equals(clientId))
                return client;
        }
        return null;
    }

    public void getInfo(Integer clientId) {
        for (Client client : clients) {
            if (client.getId().equals(clientId)) {
                System.out.println(client);
                break;
            }
        }
    }

    public void getClients() {
        if (clients.size() == 0) {
            System.out.println("There are 0 clients :(.");
        } else {
            clients.forEach((client) -> System.out.println(client));
        }
    }

    public void deleteClientById(Integer id) {
        boolean ok = false;
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                clients.remove(client);
                System.out.println(client + " has been successfully removed.");
                ok = true;
                break;
            }
        }
        if (!ok) System.out.println("Client " + id + " does not exist.");
    }

    public void changePassword(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        if (parametersArray[2].length() < 8) System.out.println("Password is too short. (at least 8 characters)");
        else {
            Client client = this.getClientById(clientId);
            if (client != null)
                client.setPassword(parametersArray[1]);
        }
    }

    public boolean logIn(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        String password = parametersArray[1];
        Client client = this.getClientById(clientId);
        if (client != null) {
            if (!client.getPassword().equals(password)) {
                System.out.println("Wrong password.");
                return false;
            } else return true;
        }
        return false;
    }

    public void buyTicket(String parameters) throws IOException {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        Integer eventId = Integer.valueOf(parametersArray[1]);
        EventService eventService = EventService.getInstance();
        Event event = eventService.getEventById(eventId);
        Client client = this.getClientById(clientId);
        if (client != null) {
            if (event != null) {
                if (event.getNumberOfTickets() > 0) {
                    Ticket ticket = new Ticket(event);
                    event.setNumberOfTickets(event.getNumberOfTickets() - 1);
                    client.getTickets().add(ticket);

                } else System.out.println("No more tickets available for this event.");
            } else System.out.println("The event " + eventId + " does not exist.");
        } else System.out.println("The client " + clientId + " does not exist.");
    }

    public void getTicketsByClientId(Integer clientId) {
        Client client = this.getClientById(clientId);
        if (client != null) {
            System.out.println(client.getTickets());
        } else System.out.println("The client " + clientId + " does not exist.");
    }
}
