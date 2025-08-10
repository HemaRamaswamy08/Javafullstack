package com.dyashin.restaurent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "food_menu")
@Entity
public class FoodMenu {

	public FoodMenu() {

	}

	public FoodMenu(int id, String foodName, String type, String description, String quantity) {
		this.id = id;
		this.name = foodName;
		this.type = type;
		this.description = description;
		this.quantity = quantity;

	}

	@Id
	int id;

	@Column(name = "food_name")
	String name;

	@Column(name = "food_type")
	String type;

	@Column(name = "food_description")
	String description;

	@Column(name = "food_quantity")
	String quantity;

}
