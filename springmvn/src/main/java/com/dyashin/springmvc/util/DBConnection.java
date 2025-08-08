package com.dyashin.springmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {
	Connection con;
	String dburl = "jdbc:mysql://localhost:3306/jdbc?user=root&password=root";

	public Connection getDBConnection() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(dburl);
				return con;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
