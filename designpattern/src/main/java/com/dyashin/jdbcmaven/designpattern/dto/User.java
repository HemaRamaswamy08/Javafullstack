package com.dyashin.jdbcmaven.designpattern.dto;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String userName;
	
	public User() {
		
	}

}
