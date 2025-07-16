package com.org.dyashin.basic;

public record EmployeeRecord(int id, String empName, String email, long mobileNumber) {

	@Override
	public String toString() {
		return id + " " + empName + " " + email + " " + mobileNumber;
	}

}
