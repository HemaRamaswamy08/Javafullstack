package com.dyashin.restaurent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dyashin.restaurent.model.Food;
import com.dyashin.restaurent.service.FoodMenuService;

@Controller
@RequestMapping("restaurent/operatations")
public class RestaurentController {

	@Autowired
	FoodMenuService service;

	/*
	 * Method 1
	 * 
	 * @GetMapping("/add") public String showDisplay(@ModelAttribute(name = "food")
	 * Food food) { return "add"; }
	 */

	@GetMapping("add")
	public ModelAndView showAddForm() {
		ModelAndView model = new ModelAndView();
		// or ModelAndView model = new ModelAndView("add"); --> here only view name
		model.addObject("food", new Food());
		model.setViewName("add");

		return model;
	}

	@PostMapping("/addFood")
	public String addFood(Food food, Model model) {
		service.addFoodDetails(food);
		model.addAttribute("message", "Food added sucesfully");
		model.addAttribute("operation", "Add");
		return "success";
	}

	@GetMapping("/deleteFoodForm")
	public String deleteFoodForm() {
		return "delete";

	}

	@PostMapping("/deleteFood")
	public String deleteFood(@RequestParam(name = "id") int id, Model model) {
		boolean result = service.deleteFoodDetails(id);
		if (result) {
			model.addAttribute("message", "Deleted Item Sucessfully");
			model.addAttribute("operation", "Delete");
			return "success";
		} else {
			model.addAttribute("message", "Item Not Found to delete");
			model.addAttribute("operation", "Delete");
			return "Failed";
		}

	}

	@GetMapping("/updateForm")
	public ModelAndView showUpdateForm() {
		ModelAndView model = new ModelAndView("update");
		model.addObject("food", new Food());
		return model;
	}

	@PostMapping("/editFood")
	public String updateFood(@ModelAttribute("food") Food food, Model model) {
		boolean isUpdate = service.updateFood(food);
		if (isUpdate) {
			model.addAttribute("message", "Updated Sucessfully");
			model.addAttribute("operation", "Update");
			return "success";
		} else {
			model.addAttribute("message", "Item Not Found to delete");
			model.addAttribute("operation", "Update");
			return "Failed";
		}

	}

	/*
	 * This below methds for show page --> update and delete data passed
	 */
	@GetMapping("/edit-food")
	public ModelAndView editFoodForm(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("edit-food");
		Food food = service.getById(id);
		modelAndView.addObject("food", food);
		return modelAndView;
	}

	@GetMapping("delete-food")
	public String delete(@RequestParam("id") int id, Model model) {
		boolean result = service.deleteFoodDetails(id);
		if (result) {
			// Add a message to display on the food list page
			// You'll need to update your foodList.jsp to display this message
			model.addAttribute("message", "Item deleted successfully!");
			model.addAttribute("operation", "Delete");
		} else {
			model.addAttribute("message", "Item not found to delete.");
			model.addAttribute("operation", "Delete");
		}

		return "redirect:/restaurent/show";
	}

}
