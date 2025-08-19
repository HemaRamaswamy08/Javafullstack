package com.dyashin.restaurent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyashin.restaurent.model.Food;
import com.dyashin.restaurent.service.FoodMenuService;

@Controller
@RequestMapping("restaurent")
public class MainController {

	@Autowired
	FoodMenuService service;

	@GetMapping("/")
	public String redirectToHome() {
		return "redirect:/restaurent/home";
	}

	@GetMapping("home")
	public String homePage() {
		return "home";
	}

	@GetMapping("operate-on-db")
	public String showDBPage() {
		return "operate-on-db";
	}

	@GetMapping("open-food-menu")
	public String showMenuPage() {
		return "open-food-menu";
	}

	@GetMapping("/show")
	public String display(Model model) {
		List<Food> foodList = service.allFood();
		model.addAttribute("foodList", foodList);
		return "show";
	}

}
