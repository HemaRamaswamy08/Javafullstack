package com.dyashin.jdbcmaven.mavenpractice;

public class User {

	private int userId;
	private String userName;

	public User(int id, String name) {
		this.userId = id;
		this.userName = name;
	}

	public int getId() {
		return this.userId;
	}

	public String getString() {
		return this.userName;
	}

	@Override
	public String toString() {
		return getId() + " " + getString();
	}
}
