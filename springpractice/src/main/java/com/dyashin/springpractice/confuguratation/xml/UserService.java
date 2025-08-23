package com.dyashin.springpractice.confuguratation.xml;

public class UserService {

	public UserRepository repo;

	public UserRepository setRepo() {
		return repo;
	}

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

	public void registerUser(String user) {
		System.out.println("Register User :" + user);
		repo.saveUser(user);
	}

}
