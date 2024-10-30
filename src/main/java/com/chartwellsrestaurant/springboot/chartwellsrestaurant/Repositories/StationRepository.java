package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.Station;

public interface StationRepository extends JpaRepository<Station, Long> {

}
