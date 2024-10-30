package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.FoodItem;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;

    public List<FoodItem> placeOrder(Long ticketId, long stationCode) {
        // Validate the ticket for the given station
        if (ticketService.validateTicket(ticketId, stationCode)) {
            // If valid, retrieve the menu for the station
            return stationService.getMenuByStationCode(stationCode);
        }
        throw new IllegalStateException("Ticket validation failed.");
    }
}

