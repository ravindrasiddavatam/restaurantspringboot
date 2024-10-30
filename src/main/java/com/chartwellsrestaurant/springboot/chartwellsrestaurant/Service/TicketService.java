package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.Customer;
import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.Ticket;
import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories.CustomerRepository;
import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Ticket purchaseTicket(String stationCode, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

        Ticket ticket = new Ticket();
        ticket.setStationCode(stationCode);
        ticket.setUsed(false);
        ticket.setCustomer(customer);

        return ticketRepository.save(ticket);
    }

    public boolean validateTicket(Long ticketId, long stationCode) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketId));

        if (ticket.isUsed()) {
            throw new IllegalStateException("Ticket has already been used.");
        }

        if (!ticket.getStationCode().equals(stationCode)) {
            throw new IllegalArgumentException("Ticket is not valid for this station.");
        }

        ticket.setUsed(true);
        ticketRepository.save(ticket);  // Mark ticket as used
        return true;
    }
}

