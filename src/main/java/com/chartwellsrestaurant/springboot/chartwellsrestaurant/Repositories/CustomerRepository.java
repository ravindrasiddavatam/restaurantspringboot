package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
