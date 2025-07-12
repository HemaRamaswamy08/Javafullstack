package com.org.dyashin.jdbcsession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBWithProp {

	public static void main(String[] args) {

		Properties prop = new Properties();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Step 1 :load the property file
			FileInputStream read = new FileInputStream(
					"D:\\JAVA-New\\javaadvancebyrahul\\jdbcsession\\src\\config.properties");
			prop.load(read);
			read.close();

			// Step 2 : Get Properties
			String dburl = prop.getProperty("dburl");
			String user = prop.getProperty("db.user");
			String password = prop.getProperty("db.password");

			// Step 3 : Get Connection to DB
			connection = DriverManager.getConnection(dburl, user, password);

			// Step 4 : Issue Query
			String querry = "select * from users";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(querry);

			// Step 5 : process Result
			System.out.println("  UserId ||   UserName	");
			System.out.println("-----------------------");
			while (rs.next()) {
				int id = rs.getInt("user_id");
				String userName = rs.getString("username");

				System.out.println(id + " || " + userName);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
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
