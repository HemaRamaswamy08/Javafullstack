package com.dyashin.restaurent.dao;

import java.util.List;

import com.dyashin.restaurent.model.FoodMenu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class FoodMenuOperatations implements FoodMenuOperatationsDAO {

	public List<FoodMenu> displayAllFoodItems() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();
		String query = "Select f from FoodMenu f";
		TypedQuery<FoodMenu> all = manager.createQuery(query, FoodMenu.class);
		return all.getResultList();
	}

	public List<FoodMenu> searchFood(String foodName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();
		String query = "SELECT f FROM FoodMenu f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))";

		TypedQuery<FoodMenu> search = manager.createQuery(query, FoodMenu.class);
		search.setParameter("name", foodName);

		List<FoodMenu> found = search.getResultList();

		return found;

	}

	public void addMenu(FoodMenu food) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();

		FoodMenu newFood = new FoodMenu();

		newFood.setId(food.getId());
		newFood.setName(food.getName());
		newFood.setQuantity(food.getQuantity());
		newFood.setDescription(food.getDescription());
		newFood.setType(food.getType());

		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(newFood);
		System.out.println("Added sucessfully");
		tran.commit();

	}

	public void editFood(int id, FoodMenu food) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();

		FoodMenu oldFood = new FoodMenu();
		oldFood.setName(food.getName());
		oldFood.setQuantity(food.getQuantity());
		oldFood.setDescription(food.getDescription());
		oldFood.setType(food.getType());

		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(oldFood);
		tran.commit();

	}

	public String deleteFood(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		FoodMenu found = manager.find(FoodMenu.class, id);
		if (found != null) {
			tran.begin();
			manager.remove(found);
			tran.commit();
			return "Deleted Sucessfully";
		} else {
			return "food not found";
		}

	}

	@Override
	public boolean searchItem(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		FoodMenu found = manager.find(FoodMenu.class, id);
		if (found != null) {
			return true;
		} else {
			return false;
		}

	}

}
