package services;

import models.ticket.Ticket;

import java.util.ArrayList;

public class TicketService {
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public void getTickets() {
        System.out.println(tickets);
    }

}
