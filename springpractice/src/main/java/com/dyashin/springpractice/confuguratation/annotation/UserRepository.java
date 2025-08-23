package com.dyashin.springpractice.confuguratation.annotation;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	public void saveUser(String user) {
		System.out.println("user " + user + "saved sucesfully");
	}

}
