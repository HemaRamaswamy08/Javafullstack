package com.org.dyashin.tasks;

public class ClassB implements Connection {

	@Override
	public Statement createStatement() {
		System.out.println("Class B Implementation class of connection");
		return new ClassY();
	}
}
