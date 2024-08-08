package com.example.casem3.service.impl;

import com.example.casem3.dao.ITicketDAO;
import com.example.casem3.dao.impl.TicketDAO;
import com.example.casem3.model.Ticket;
import com.example.casem3.service.ITicketService;

public class TicketService implements ITicketService {
    private ITicketDAO ticketDAO = new TicketDAO();

    @Override
    public void bookTickets(Ticket ticket) {
        ticketDAO.bookTickets(ticket);
    }
}
