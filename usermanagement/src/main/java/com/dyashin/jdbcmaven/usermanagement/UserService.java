package com.dyashin.jdbcmaven.usermanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dyashin.jdbcmaven.usermanagement.exception.DuplicateIdException;
import com.dyashin.jdbcmaven.usermanagement.exception.InvalidPasswordException;

public class UserService {
	public static List<User> allusers = new ArrayList<>();

	public User register(String name, String email) {
		if (email == null)
			throw new IllegalArgumentException("Email is required");
		User user = new User(1, name, email);
		allusers.add(user);
		return user;
	}

	public User register(String name, String email, String password) {
		if (email == null)
			throw new IllegalArgumentException("Email is required");
		if (password == null)
			throw new InvalidPasswordException("Password is required");

		return new User(1, name, email, password);
	}

	public static void checkId(User user) {
		Iterator<User> itr = allusers.iterator();
		while (itr.hasNext()) {
			User current = itr.next();
			if (current.getId() == user.getId()) {
				throw new DuplicateIdException("ID already present");
			}
		}

	}

	public int add(int a, int b) {
		return a + b;
	}

	public float divide(float a, float b) {
		if (b == 0)
			throw new IllegalArgumentException("Cannot divide by Zero");
		return a / b;
	}

	public void duplicateId(int id) {

	}
}
