package com.org.dyashin.basic.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	private Connection connection = null;
	private static SingleConnection instance;
	private static final String DBURL = "jdbc:mysql://localhost:3306/java?";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private SingleConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection  = DriverManager.getConnection(DBURL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		return connection;
	}

	public static synchronized SingleConnection getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new SingleConnection();
		}
		return instance;

	}

}
