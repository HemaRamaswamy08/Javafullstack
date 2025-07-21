package com.dyashin.basic.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.dyashin.basic.Employee;

import exception.DataNotFoundException;

public class DbUtil {

	private DbUtil() {

	}

	public static List<Employee> getAllEmployee() {
		List<Employee> allEmp = new ArrayList<Employee>();

		Connection conn = null;
		Statement stmt = null;

		ResultSet rs = null;
		// 1. Load the Driver

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. get the db connection via driver
			String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";
			System.out.println("dburl >>" + dburl);
			conn = DriverManager.getConnection(dburl);
			System.out.println("Connection Interface implementation class is :" + conn.getClass());
			// 3. issue the sql queries via conn
			String query = "SELECT * from employee";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			// 4. process the results returned by sql

			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String employeeName = rs.getString("employee_name");
				long mobileNumber = rs.getLong("mobile_no");
				String email = rs.getString("employee_email");

				allEmp.add(new Employee(employeeId, employeeName, email, mobileNumber));
			}
			if (allEmp.size() == 0) {
				throw new DataNotFoundException("Data Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5.close all the JDBC Object
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

		return allEmp;

	}

}
