package com.org.dyashin.basic.threadwithconnectionpool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class ConnectionPool extends Thread {
	private static Connection connection;
	private static final LinkedList<Connection> connectionPool = new LinkedList<Connection>();
	private static int poolSize = 0;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Properties prop = new Properties();
			FileInputStream read = new FileInputStream(
					"D:\\JAVA-New\\javaadvancebyrahul\\jdbcsession\\src\\config.properties");
			prop.load(read);
			read.close();
			poolSize = Integer.parseInt(prop.getProperty("pool.size"));
			for (int i = 0; i < poolSize; i++) {
				connection = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("db.user"),
						prop.getProperty("db.password"));
				connectionPool.add(connection);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ConnectionPool() {

	}

	public synchronized Connection getConnection() throws SQLException, InterruptedException {
		while (connectionPool.isEmpty()) {
			System.out.println("Connection Not avaiable Please wait");
			wait();
		}
		System.out.println("Availble Connection :" + connectionPool.size());
		System.out.println("Got Connection");
		return connectionPool.removeFirst();

	}

	public synchronized void returnConnection(Connection conn) {
		if (conn != null) {
			connectionPool.addLast(conn);
			System.out.println("Connection Added back");
			notify();
		}
	}

	public synchronized int availableConnections() {
		return connectionPool.size();
	}

}
