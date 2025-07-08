package com.org.dyashin.jdbcsession;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AllDataOfMyDB {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statements = null;
		ResultSet result = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";
			System.out.println("dubrul =>" + dburl);
			connection = DriverManager.getConnection(dburl);

			String querie = "select * from employee";

			statements = connection.createStatement();
			result = statements.executeQuery(querie);

			while (result.next()) {
				int employeeId = result.getInt("employee_id");
				String employeeName = result.getString("employee_name");
				long phoneNum = result.getLong("phone_number");
				String email = result.getString("employee_email");
				int age = result.getInt("age");
				int passportNumber = result.getInt("passport_number");
				String gender = result.getString("gender");
				long aadharNumber = result.getLong("aadhar_number");
				String blood_group = result.getString("blood_group");
				Date joiningDate = result.getDate("date_of_join");
				long mobileNumber = result.getLong("mobile_no");
				int pincode = result.getInt("pincode");
				boolean marriageStatus = result.getBoolean("marriage_status");
				String addres = result.getString("address");

				System.out.println("Employee Id ==> " + employeeId);
				System.out.println("Employee Name ==> " + employeeName);
				System.out.println("Phone Number ==>" + phoneNum);
				System.out.println("Email ==> " + email);
				System.out.println("Age ==> " + age);
				System.out.println("Passport Number ==> " + passportNumber);
				System.out.println("Gender==>" + gender);
				System.out.println("Aadha Number ==> " + aadharNumber);
				System.out.println("Blood Group==> " + blood_group);
				System.out.println("Date of Joining ==>" + joiningDate);
				System.out.println("Mobile Number ==>" + mobileNumber);
				System.out.println("Addredd ==> " + addres);
				System.out.println("Pincode ==> " + pincode);
				System.out.println("Marriage Status==> " + marriageStatus);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statements != null) {
					statements.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
