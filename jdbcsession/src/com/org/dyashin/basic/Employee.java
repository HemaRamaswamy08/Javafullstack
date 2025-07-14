package com.org.dyashin.basic;

public class Employee {

	private int id;
	private String empName;
	private String email;
	private long mobileNumber;

	public Employee(int id, String empName, String email, long mobileNumber) {
		this.id = id;
		this.empName = empName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmail() {
		return email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public String toString() {
		return getId() + " " + getEmpName() + " " + getEmail() + " " + getMobileNumber();
	}

}
