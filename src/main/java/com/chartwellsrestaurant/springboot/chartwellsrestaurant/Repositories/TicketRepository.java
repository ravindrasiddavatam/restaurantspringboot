package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
