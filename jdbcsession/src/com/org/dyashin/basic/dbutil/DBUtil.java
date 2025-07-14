package com.org.dyashin.basic.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dyashin.basic.Employee;

import exception.DataNotFoundExceptionn;

public class DBUtil {

	static List<Employee> allEmp = new ArrayList<Employee>();
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	static String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";

	private DBUtil() {

	}

	public static List<Employee> getAllEmployee() {

		try {
			conn = DriverManager.getConnection(dburl);
			String query = "SELECT * from employee";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				allEmp.add(new Employee(rs.getInt("employee_id"), rs.getString("employee_name"),
						rs.getString("employee_email"), rs.getLong("mobile_no")));
			}
			if (allEmp.isEmpty()) {
				throw new DataNotFoundExceptionn("Data Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allEmp;

	}

	public static void getInformatation(int id) {

		try {
			conn = DriverManager.getConnection(dburl);
			String query = "SELECT * from employee where employee_id=? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Employee emp = new Employee(rs.getInt("employee_id"), rs.getString("employee_name"),
						rs.getString("employee_email"), rs.getLong("mobile_no"));

				System.out.println(emp);
				return;
			}
			if (!rs.next()) {
				throw new DataNotFoundExceptionn("Data Not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
