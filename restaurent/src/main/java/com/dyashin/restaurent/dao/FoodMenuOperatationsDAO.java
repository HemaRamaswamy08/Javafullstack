package com.dyashin.restaurent.dao;

import java.util.List;

import com.dyashin.restaurent.model.FoodMenu;

public interface FoodMenuOperatationsDAO {

	List<FoodMenu> displayAllFoodItems();

	List<FoodMenu> searchFood(String foodName);

	void addMenu(FoodMenu food);

	void editFood(int id, FoodMenu food);

	String deleteFood(int id);

	boolean searchItem(int id);

}
