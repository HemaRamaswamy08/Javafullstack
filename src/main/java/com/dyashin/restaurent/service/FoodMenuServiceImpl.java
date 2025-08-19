package com.dyashin.restaurent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.restaurent.dao.FoodMenuOperatations;
import com.dyashin.restaurent.model.Food;

@Service
public class FoodMenuServiceImpl implements FoodMenuService {

	@Autowired
	FoodMenuOperatations dao;

	@Override
	public void addFoodDetails(Food food) {
		dao.addFood(food);
	}

	@Override
	public boolean deleteFoodDetails(int id) {
		return dao.deleteFood(id);
	}

	@Override
	public boolean updateFood(Food food) {
		return dao.editFood(food);
	}

	@Override
	public List<Food> allFood() {
		return dao.displayAllFood();
	}

	@Override
	public List<Food> randomFood() {
		return dao.randomDisplay();
	}

	@Override
	public Food dislayParticularFood() {
		return dao.particularFood();
	}

	@Override
	public List<Food> searchFood(String name) {
		return dao.searchByFoodName(name);
	}

	@Override
	public Food getById(int id) {
		return dao.getFoodById(id);
	}

}
