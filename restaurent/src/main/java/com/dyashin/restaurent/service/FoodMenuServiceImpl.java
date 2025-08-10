package com.dyashin.restaurent.service;

import java.util.List;

import com.dyashin.restaurent.dao.FoodMenuOperatations;
import com.dyashin.restaurent.dao.FoodMenuOperatationsDAO;
import com.dyashin.restaurent.model.FoodMenu;

public class FoodMenuServiceImpl implements FoodMenuService {

	FoodMenuOperatationsDAO dao = new FoodMenuOperatations();

	@Override
	public List<FoodMenu> displayAll() {
		return dao.displayAllFoodItems();
	}

	@Override
	public List<FoodMenu> search(String foodName) {
		return dao.searchFood(foodName);
	}

	@Override
	public void add(FoodMenu food) {
		dao.addMenu(food);
	}

	@Override
	public void edit(int id, FoodMenu food) {
		dao.editFood(id, food);
	}

	@Override
	public String delete(int id) {
		return dao.deleteFood(id);
	}

	@Override
	public boolean searchById(int id) {
		return dao.searchItem(id);
	}

}
