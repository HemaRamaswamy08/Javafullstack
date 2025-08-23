package com.dyashin.springpractice.confuguratation.java;

public class UserRepository {
	User user;

	public UserRepository(User user) {
		this.user = user;
	}

	public void register(String name) {
		System.out.println("Registered " + name);
		user.saveUser(name);
	}

}
