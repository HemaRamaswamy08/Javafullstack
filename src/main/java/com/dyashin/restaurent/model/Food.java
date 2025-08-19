package com.dyashin.restaurent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "food_menu")
@Data
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


}
