package com.dyashin.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.dyashin.springboot.model.Food;
import com.dyashin.springboot.model.FoodRequestAndResponse;

public interface FoodService {
	List<FoodRequestAndResponse> getAllFoods();

	// Optional<FoodRequestAndResponse> getFoodById(int id);

	List<FoodRequestAndResponse> searchFoodByName(String name);

	FoodRequestAndResponse addFood(FoodRequestAndResponse food);

	FoodRequestAndResponse updateFood(FoodRequestAndResponse food);

	String deleteFood(int id);

	ResponseEntity<FoodRequestAndResponse> searchById(Integer id);
}
