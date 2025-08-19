package com.dyashin.restaurent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dyashin.restaurent.model.Food;
import com.dyashin.restaurent.service.FoodMenuService;

@Controller
@RequestMapping("restaurent/display")
public class DisplayController {

	@Autowired
	FoodMenuService service;

	@GetMapping("open-food-menu")
	public String openFoodMenu() {
		return "food-menu";
	}

	@GetMapping("/displayAllFood")
	public ModelAndView showAllSongs() {
		ModelAndView model = new ModelAndView("displayAll");
		List<Food> allFood = service.allFood();
		model.addObject("foodList", allFood);
		model.addObject("message", "displaying all food items");
		return model;
	}

	@GetMapping("/randomFoodDisplay")
	public ModelAndView displayRandomly() {
		ModelAndView model = new ModelAndView("displayAll");
		List<Food> allFood = service.randomFood();
		model.addObject("foodList", allFood);
		model.addObject("message", "Randomly displaying food Items");
		return model;
	}

	@GetMapping("/particularFood")
	public ModelAndView displayParticularFood() {
		ModelAndView model = new ModelAndView("particular");
		Food food = service.dislayParticularFood();
		model.addObject("food", food);
		return model;
	}

	@GetMapping("search-food")
	public ModelAndView searchFood(@RequestParam(name = "foodName", required = false) String foodName) {
		ModelAndView model = new ModelAndView("search");
		if (foodName != null && !foodName.isEmpty()) {
			List<Food> allFood = service.searchFood(foodName);
			if (!allFood.isEmpty()) {
				model.addObject("foodList", allFood);
				model.addObject("message", "Displaying search results for: " + foodName);
			} else {
				model.addObject("message", "No items found for: " + foodName);
			}
		}
		return model;
	}

	@GetMapping("/show")
	public ModelAndView showAllData(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView("updateSecond");
		Food food = service.getById(id);
		model.addObject("food", food);
		return model;
	}

}
