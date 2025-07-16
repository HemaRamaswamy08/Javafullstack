package com.org.dyashin.basic.manualconnectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = SimpleConnectionPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users");

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("user_id") + ", Username: " + rs.getString("username"));
			}
			System.out.println(SimpleConnectionPool.availableConnections());

//		Connection connTwo = SimpleConnectionPool.getConnection();
//		Connection conThree = SimpleConnectionPool.getConnection();
		
			System.out.println("After 1 use :"+SimpleConnectionPool.availableConnections());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				SimpleConnectionPool.returnConnection(conn);
				System.out.println(SimpleConnectionPool.availableConnections());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
