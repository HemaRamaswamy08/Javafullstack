package com.dyashin.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestAndResponse {

	private Integer id;
	private String name;
	private String type;
	private String description;
	private Integer cost;
	private String quantity;

	public FoodRequestAndResponse(String name, String type, String description, Integer cost, String quantity) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}

}
