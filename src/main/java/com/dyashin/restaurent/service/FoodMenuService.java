package com.dyashin.restaurent.service;

import java.util.List;

import com.dyashin.restaurent.model.Food;

public interface FoodMenuService {

	void addFoodDetails(Food food);

	boolean deleteFoodDetails(int id);

	boolean updateFood(Food food);

	List<Food> allFood();

	List<Food> randomFood();

	Food dislayParticularFood();

	List<Food> searchFood(String name);

	Food getById(int id);

}
