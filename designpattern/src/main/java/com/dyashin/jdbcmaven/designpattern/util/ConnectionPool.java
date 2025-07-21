package com.dyashin.jdbcmaven.designpattern.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool implements Property {

	private static Connection getInstance;
	private static final LinkedList<Connection> connectionPool = new LinkedList<Connection>();
	private static int poolSize = 0;
	static {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			poolSize = GetPropertyDetails.getPoolSize(POOL_SIZE);
			for (int i = 0; i < poolSize; i++) {
				getInstance = DriverManager.getConnection(GetPropertyDetails.getDBUrl(DB_URL),
						GetPropertyDetails.getDBUser(DB_USER), GetPropertyDetails.getDBPassword(DB_PASSWORD));
				connectionPool.add(getInstance);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ConnectionPool() {

	}

	public static Connection getConnection() throws SQLException {
		if (connectionPool.isEmpty()) {
			throw new SQLException("No available connection in the pool");
		}
		return connectionPool.removeFirst();
	}

	public static void returnConnection(Connection conn) {
		if (conn != null) {
			connectionPool.addLast(conn);
		}
	}

	public static int availableConnection() {
		return connectionPool.size();
	}

}
