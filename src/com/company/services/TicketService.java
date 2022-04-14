package com.company.services;

import com.company.models.Ticket;

import java.util.ArrayList;

public class TicketService {
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public void getTickets() {
        System.out.println(tickets);
    }

}
