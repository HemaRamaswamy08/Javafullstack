package com.dyashin.restaurent.controller;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.dyashin.restaurent.model.FoodMenu;
import com.dyashin.restaurent.service.FoodMenuService;
import com.dyashin.restaurent.service.FoodMenuServiceImpl;
import com.dyashin.restauren.util.ScannerUtil;

public class FoodController {
	FoodMenuService service = new FoodMenuServiceImpl();

	public void displayFoodOptions() {

		List<FoodMenu> foodItems = service.displayAll();

		if (foodItems.isEmpty()) {
			System.out.println("No Food to show");
			return;
		}

		System.out.println("i.	Press A for  “displaying all the food items”");
		System.out.println("ii	Press B  for  “displaying food items randomly”");
		System.out.println("iii	Press C for  “display particular food “");
		String choice = ScannerUtil.getStringInput("options");

		switch (choice) {
		case "A":
			for (FoodMenu foodMenu : foodItems) {
				System.out.println(foodMenu.getName());
			}
			break;
		case "B":
			Collections.shuffle(foodItems);
			for (FoodMenu foodMenu : foodItems) {
				System.out.println(foodMenu.getName());
			}

			break;
		case "C":
			Random random = new Random();
			int rand = random.nextInt(foodItems.size());
			System.out.println(foodItems.get(rand));
			break;

		}

	}

	public void searchAndDisplay() {
		String foodName = ScannerUtil.getStringInput("Food name");
		System.out.println(service.search(foodName));
	}

	public void displayTable() {
		List<FoodMenu> foods = service.displayAll();
		foods.forEach(System.out::println);
	}

	public void dbOperatations() {
		System.out.println("i.	Press A to “Add food” to restaruent Repository");
		System.out.println("ii. Press B to “Edit an existing food” info ");
		System.out.println("iii. Press C to “Delete an existing food item” info");
		String choice = ScannerUtil.getStringInput("Choice");
		switch (choice) {
		case "A":
			int id = ScannerUtil.getIntInput("food id");
			String foodName = ScannerUtil.getStringInput("food name");
			String type = ScannerUtil.getStringInput("food Type");
			String description = ScannerUtil.getStringInput("food Description");
			String quantity = ScannerUtil.getStringInput("food_quantity");

			FoodMenu food = new FoodMenu(id, foodName, type, description, quantity);

			service.add(food);
			break;
		case "B":
			int foodId = ScannerUtil.getIntInput("food id");
			boolean isPresent = service.searchById(foodId);
			if (isPresent) {
				String name = ScannerUtil.getStringInput("food name");
				String ftype = ScannerUtil.getStringInput("food Type");
				String fdescription = ScannerUtil.getStringInput("food Description");
				String fquantity = ScannerUtil.getStringInput("food_quantity");

				FoodMenu edited = new FoodMenu(foodId, name, ftype, fdescription, fquantity);
				service.edit(foodId, edited);
			} else {
				System.out.println("Food Id not present");
			}
			break;

		default:
			System.out.println("Invalid chance");
		}
	}

}
