package com.dyashin.restaurent.service;

import java.util.List;

import com.dyashin.restaurent.model.FoodMenu;

public interface FoodMenuService {

	List<FoodMenu> displayAll();

	List<FoodMenu>  search(String foodName);

	void add(FoodMenu food);

	void edit(int id, FoodMenu food);

	String delete(int id);
	boolean searchById(int id);
}
