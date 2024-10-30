package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.FoodItem;
import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.Station;
import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories.StationRepository;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<FoodItem> getMenuByStationCode(long stationCode) {
        Station station = stationRepository.findById(stationCode)
                .orElseThrow(() -> new IllegalArgumentException("Station not found with code: " + stationCode));
        return station.getFoodItems();
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
}

