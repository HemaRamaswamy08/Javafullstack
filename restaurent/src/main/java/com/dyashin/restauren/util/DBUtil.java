package com.dyashin.restauren.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {

	public static HikariDataSource data;

	static {

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/restaurent");
		config.setUsername("root");
		config.setPassword("root");

		data = new HikariDataSource(config);
	}

	public static Connection getDBConnection(){

		try {
			return data.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
