package com.dyashin.jdbcmaven.mavenpractice;

public class Main {
	public static void main(String[] args) {
		for (User user : UserImpl.getAllEmp()) {
			System.out.println(user);
		}
	}

}
