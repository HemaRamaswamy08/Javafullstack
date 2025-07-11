package com.org.dyashin.jdbcsession;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class OtherThanSelect {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		ResultSet rs = null;
		// 1. Load the Driver

		try {
			// Method1 : to load driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			// 2. get the db connection via driver
			String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";
			System.out.println("dburl >>" + dburl);
			conn = DriverManager.getConnection(dburl);
			// 3. issue the sql queries via conn
			String query = "Insert into users values (1006, 'Nisha') ";

			stmt = conn.createStatement();
			int count = stmt.executeUpdate(query);
			System.out.println("Number of rows effected :"+count);

		} catch (SQLException e) {
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
	}
}
