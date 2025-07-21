package com.dyashin.jdbcmaven.usermanagement;

public class User {
	private int id;
	private String name;
	private String email;
	private String address;
	private String password;

	public User(int id, String name, String email, String pasword) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = pasword;
	}

	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;

	}

	// Getters and Setters

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
