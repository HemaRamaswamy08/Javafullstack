package com.dyashin.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.springboot.model.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	List<Food> findByNameContainingIgnoreCase(String name);
}
