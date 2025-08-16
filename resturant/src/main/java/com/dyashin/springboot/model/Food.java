package com.dyashin.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_menu")
@Data
@NoArgsConstructor
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Integer id;
	@Column(name = "food_name")
	private String name;

	@Column(name = "food_type")
	private String type;

	@Column(name = "food_description")
	private String description;

	@Column(name = "food_cost")
	private Integer cost;

	@Column(name = "food_quantity")
	private String quantity;

	public Food(Integer id, String name, String type, String description, Integer cost, String quantity) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}

}
