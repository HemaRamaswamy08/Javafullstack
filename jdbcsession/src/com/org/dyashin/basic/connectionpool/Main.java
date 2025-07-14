package com.org.dyashin.basic.connectionpool;

public class Main {

	public static void main(String[] args) {

		Account account = new Account();

		for (User user : account.allUser()) {
			System.out.println(user);
		}

		User current = account.currentUser(1019);

		System.out.println(current);

	}

}
