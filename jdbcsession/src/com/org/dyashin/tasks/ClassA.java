package com.org.dyashin.tasks;

public class ClassA implements Connection{

	@Override
	public Statement createStatement() {
		System.out.println("Class A Implementation class of connection");
		return new ClassX();
	}

}
