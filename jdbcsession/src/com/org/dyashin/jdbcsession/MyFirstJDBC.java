package com.org.dyashin.jdbcsession;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MyFirstJDBC {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		ResultSet rs = null;
		// 1. Load the Driver

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// get the db connection via driver
			String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";
			System.out.println("dburl >>" + dburl);
			conn = DriverManager.getConnection(dburl);
			// issue the sql queries via conn
			String query = "select * from employee";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			// process the results returned by sql

			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String employeeName = rs.getString("employee_name");
				Date joiningDate = rs.getDate("date_of_join");
				long mobileNumber = rs.getLong("mobile_no");
				String email = rs.getString("employee_email");

				System.out.println("Employee Id ==> " + employeeId);
				System.out.println("Employee Name ==> " + employeeName);
				System.out.println("Date of Joining ==>" + joiningDate);
				System.out.println("Mobile Number ==>" + mobileNumber);
				System.out.println("Email ==> " + email);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
