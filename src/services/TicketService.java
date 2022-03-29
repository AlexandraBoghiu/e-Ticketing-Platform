package services;

import events.Event;
import ticket.Ticket;

import java.util.ArrayList;

public class TicketService {
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public void getTickets() {
        System.out.println(tickets);
    }

}
