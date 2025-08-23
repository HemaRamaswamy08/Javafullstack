package com.dyashin.springpractice.confuguratation.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceUser {

	UserRepository repo;

	@Autowired
	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

	public void registerUser(String user) {
		System.out.println("Register User :" + user);
		repo.saveUser(user);
	}
}
