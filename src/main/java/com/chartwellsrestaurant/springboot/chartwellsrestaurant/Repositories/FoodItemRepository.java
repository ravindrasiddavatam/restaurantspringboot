package com.chartwellsrestaurant.springboot.chartwellsrestaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chartwellsrestaurant.springboot.chartwellsrestaurant.Entities.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

}
