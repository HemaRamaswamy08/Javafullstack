package com.dyashin.springcode.configuration;

public class Address {

	StudentInfo studentInfo;

	public Address(StudentInfo stud) {
		this.studentInfo = stud;
	}
	
	public void stuff() {
		System.out.println("Address class");
	}

}
