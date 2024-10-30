package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.FoodItem;
import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Service.StationService;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private StationService stationService;
    
    @GetMapping("/{stationCode}")
    public List<FoodItem> getMenu(@PathVariable long stationCode) {
        return stationService.getMenuByStationCode(stationCode);
    }
    @GetMapping
    public String sayHi() {
    	return "Hello World!";
    }
}

