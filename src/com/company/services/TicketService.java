package com.company.services;

import com.company.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets = new ArrayList<Ticket>();
    private static TicketService instance = null;

    private TicketService() {

    }
    public static TicketService getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new TicketService();
        return instance;
    }

    public void getTickets() {
        System.out.println(tickets);
    }

}
