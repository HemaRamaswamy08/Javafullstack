package com.org.dyashin.jdbcsession.musicplayerwithjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicPlayerMain {
	public static void main(String[] args) {
		
		
		try {
			//1. Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.get the db connection
			String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";
			System.out.println(dburl);
			Connection connection = DriverManager.getConnection(dburl);
			String name = "dandelion";
			String movie = "album song";
			Statement statement = connection.createStatement();
			String query = "Insert into musicplayer values (104, '" + name + "', '" + movie + "', 2020)";
			int count = statement.executeUpdate(query);
			System.out.println("Number of rows effected :" + count);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
