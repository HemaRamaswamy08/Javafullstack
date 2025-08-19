package com.dyashin.restaurent.dao;

import java.util.List;

import com.dyashin.restaurent.model.Food;

public interface FoodMenuOperatations {

	void addFood(Food food);

	boolean deleteFood(int id);

	boolean editFood(Food food);

	List<Food> displayAllFood();

	List<Food> randomDisplay();
	
	Food particularFood();
	
	List<Food> searchByFoodName(String foodName);

	Food getFoodById(int id);
	
}
