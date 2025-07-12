package com.org.dyashin.tasks;

public class DriverManager {
	
	private DriverManager() {
		
	}
	
	public static Connection getConnrction(String str) {
		Connection test = null;
		if(str.equals("A")) {
			test = new ClassA();
		}else {
			test = new ClassB();
		}
		return test;
	}
}
