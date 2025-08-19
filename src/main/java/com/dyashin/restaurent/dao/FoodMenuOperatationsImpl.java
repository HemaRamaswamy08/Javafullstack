package com.dyashin.restaurent.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dyashin.restaurent.model.Food;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class FoodMenuOperatationsImpl implements FoodMenuOperatations {
	/*
	 * @PersistenceContext -> This annotation tells Spring to inject a shared,
	 * thread-safe EntityManager proxy. This proxy automatically handles the
	 * creation and closing of the underlying EntityManager
	 */

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * @Transactional --> this tells Spring's transaction manager to start a new
	 * transaction before the method is executed and to commit it after the method
	 * successfully returns
	 */

	@Override
	@Transactional
	public void addFood(Food food) {
		entityManager.persist(food);

	}

	@Override
	@Transactional
	public boolean deleteFood(int id) {
		Food found = entityManager.find(Food.class, id);
		if (found != null) {
			entityManager.remove(found);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean editFood(Food food) {
		Food found = entityManager.find(Food.class, food.getId());
		if (found != null) {
			entityManager.merge(food);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Food> displayAllFood() {
		String query = "select e from Food e";
		TypedQuery<Food> allFood = entityManager.createQuery(query, Food.class);
		return allFood.getResultList();
	}

	@Override
	public List<Food> randomDisplay() {
		String query = "select e from Food e";
		TypedQuery<Food> allFood = entityManager.createQuery(query, Food.class);
		List<Food> result = allFood.getResultList();
		Collections.shuffle(result);
		return result;
	}

	@Override
	public Food particularFood() {
		String query = "select e from Food e";
		TypedQuery<Food> allFood = entityManager.createQuery(query, Food.class);
		List<Food> result = allFood.getResultList();
		Random randum = new Random();
		int num = randum.nextInt(result.size());
		return result.get(num);
	}

	@Override
	public List<Food> searchByFoodName(String foodName) {
		String query = "select e from Food e where lower(e.name) like lower(:foodName)";
		TypedQuery<Food> allFood = entityManager.createQuery(query, Food.class);
		allFood.setParameter("foodName", "%" + foodName + "%");
		return allFood.getResultList();
	}

	@Override
	public Food getFoodById(int id) {
		Food found = entityManager.find(Food.class, id);
		return found;
	}

}
