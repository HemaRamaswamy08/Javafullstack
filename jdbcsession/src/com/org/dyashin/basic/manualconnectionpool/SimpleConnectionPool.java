package com.org.dyashin.basic.manualconnectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class SimpleConnectionPool {
	private static final String URL = "jdbc:mysql://localhost:3306/java";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final int POOL_SIZE = 2;

	private static final LinkedList<Connection> pool = new LinkedList<>();

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for (int i = 0; i < POOL_SIZE; i++) {
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				pool.add(conn);
			}
			System.out.println("Connection pool initialized with " + POOL_SIZE + " connections.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		if (pool.isEmpty()) {
			throw new SQLException("No available connection in the pool");
		}
		return pool.removeFirst();
	}

	public static synchronized void returnConnection(Connection conn) {
		if (conn != null) {
			pool.addLast(conn);
		}
	}

	public static synchronized int availableConnections() {
		return pool.size();
	}

}
