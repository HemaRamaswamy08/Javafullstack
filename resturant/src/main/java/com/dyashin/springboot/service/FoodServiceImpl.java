package com.dyashin.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dyashin.springboot.exception.FoodNotFoundException;
import com.dyashin.springboot.model.Food;
import com.dyashin.springboot.model.FoodRequestAndResponse;
import com.dyashin.springboot.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository repo;

	public List<FoodRequestAndResponse> getAllFoods() {
		List<Food> foods = repo.findAll();
		if (foods.isEmpty()) {
			throw new FoodNotFoundException("Menu is Empty");
		}
		List<FoodRequestAndResponse> allFood = foods.stream().map(food -> {
			FoodRequestAndResponse foodFound = new FoodRequestAndResponse();
			foodFound.setId(food.getId());
			foodFound.setName(food.getName());
			foodFound.setCost(food.getCost());
			foodFound.setDescription(food.getDescription());
			foodFound.setQuantity(food.getQuantity());
			foodFound.setType(food.getType());
			return foodFound;
		}).collect(Collectors.toList());
		return allFood;

	}

	public ResponseEntity<FoodRequestAndResponse> searchById(Integer id) {
		Optional<Food> foodOptional = repo.findById(id);

		if (foodOptional.isPresent()) {
			FoodRequestAndResponse found = new FoodRequestAndResponse();
			Food food = foodOptional.get();
			found.setId(food.getId());
			found.setName(food.getName());
			found.setCost(food.getCost());
			found.setDescription(food.getDescription());
			found.setQuantity(food.getQuantity());
			found.setType(food.getType());
			return ResponseEntity.ok(found);
		} else {
			throw new FoodNotFoundException("Food with ID " + id + " Not Found");
		}

	}

	public List<FoodRequestAndResponse> searchFoodByName(String name) {
		List<Food> allfood = repo.findByNameContainingIgnoreCase(name);
		if (allfood.isEmpty()) {
			throw new FoodNotFoundException("Food with " + name + " Not Found");
		} else {
			List<FoodRequestAndResponse> foods = allfood.stream().map(food -> {
				FoodRequestAndResponse foodFound = new FoodRequestAndResponse();
				foodFound.setId(food.getId());
				foodFound.setName(food.getName());
				foodFound.setCost(food.getCost());
				foodFound.setDescription(food.getDescription());
				foodFound.setQuantity(food.getQuantity());
				foodFound.setType(food.getType());
				return foodFound;
			}).collect(Collectors.toList());
			return foods;

		}
	}

	public FoodRequestAndResponse addFood(FoodRequestAndResponse food) {
		Food saveFood = new Food();
		if (food.getName() == null || food.getName().isEmpty()) {
			throw new FoodNotFoundException("Food name Required ");
		}
		saveFood.setName(food.getName());
		saveFood.setCost(food.getCost());
		saveFood.setDescription(food.getDescription());
		saveFood.setType(food.getType());
		saveFood.setQuantity(food.getQuantity());
		repo.save(saveFood);

		FoodRequestAndResponse response = new FoodRequestAndResponse();
		response.setId(saveFood.getId());
		response.setName(saveFood.getName());
		response.setCost(saveFood.getCost());
		response.setDescription(saveFood.getDescription());
		response.setType(saveFood.getType());
		response.setQuantity(saveFood.getQuantity());

		return response;

	}

	public FoodRequestAndResponse updateFood(FoodRequestAndResponse food) {
		Food existingFood = repo.findById(food.getId())
				.orElseThrow(() -> new FoodNotFoundException("Food item not found with ID: " + food.getId()));

		// 2. Update the properties of the existing food item with the new values.
		existingFood.setName(food.getName());
		existingFood.setCost(food.getCost());
		existingFood.setDescription(food.getDescription());
		existingFood.setType(food.getType());
		existingFood.setQuantity(food.getQuantity());
		repo.save(existingFood);

		FoodRequestAndResponse updatedFood = new FoodRequestAndResponse();
		updatedFood.setId(existingFood.getId());
		updatedFood.setName(existingFood.getName());
		updatedFood.setCost(existingFood.getCost());
		updatedFood.setDescription(existingFood.getDescription());
		updatedFood.setQuantity(existingFood.getQuantity());
		updatedFood.setType(existingFood.getType());
		return updatedFood;

	}

	public String deleteFood(int id) {
		Optional<Food> foodOptional = repo.findById(id);

		if (foodOptional.isPresent()) {
			repo.deleteById(id);
			return "Food with Id " + id + "is deleted Sucessfully";
		} else {
			throw new FoodNotFoundException("Food with ID " + id + " is not present");
		}
	}

}
