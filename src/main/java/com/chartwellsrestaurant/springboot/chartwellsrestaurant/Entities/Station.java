package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String code; // e.g., TP, BB
    private String name;
    
    @OneToMany(mappedBy = "station")
    private List<FoodItem> foodItems;
    
    public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	
}

