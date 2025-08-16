package com.dyashin.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.springboot.exception.FoodNotFoundException;
import com.dyashin.springboot.model.FoodRequestAndResponse;
import com.dyashin.springboot.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {

	@Autowired
	private FoodService service;

	@GetMapping
	public ResponseEntity<List<FoodRequestAndResponse>> getAllFoods() {
		return ResponseEntity.ok(service.getAllFoods());

	}

	@GetMapping("/searchById/{id}")
	public ResponseEntity<FoodRequestAndResponse> getFoodById(@PathVariable int id) {
		return service.searchById(id);
	}

	@GetMapping("/search/{name}")
	public ResponseEntity<List<FoodRequestAndResponse>> searchFood(@PathVariable String name) {
		return ResponseEntity.ok(service.searchFoodByName(name));
	}

	@PostMapping
	public ResponseEntity<FoodRequestAndResponse> addFood(@RequestBody FoodRequestAndResponse food) {
		return ResponseEntity.ok(service.addFood(food));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<FoodRequestAndResponse> updateFood(@PathVariable int id,
			@RequestBody FoodRequestAndResponse food) {

		if (service.searchById(id) == null) {
			throw new FoodNotFoundException("Item does't found to update");
		}
		food.setId(id);
		return ResponseEntity.ok(service.updateFood(food));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable int id) {
		String message = service.deleteFood(id);
		return ResponseEntity.ok(message);
	}
}
