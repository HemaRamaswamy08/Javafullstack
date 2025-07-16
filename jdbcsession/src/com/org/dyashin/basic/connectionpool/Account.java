package com.org.dyashin.basic.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Account {
	static Connection connect = null;
	static Statement stmt = null;
	static ResultSet result = null;
	static String query;

	public List<User> allUser() {
		List<User> users = new ArrayList<User>();
		try {
			connect = SingleConnection.getInstance().getConnection();
			query = "Select * from users";
			stmt = connect.createStatement();
			result = stmt.executeQuery(query);
			while (result.next()) {
				users.add(new User(result.getInt("user_id"), result.getString("username")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User currentUser(int id) {
		User userDetails = null;
		try {
			connect = SingleConnection.getInstance().getConnection();
			query = "Select * from users where user_id=?";
			PreparedStatement prep = connect.prepareStatement(query);
			prep.setInt(1, id);
			result = prep.executeQuery();
			if (result.next()) {
				userDetails = new User(result.getInt("user_id"), result.getString("username"));
			} else {
				userDetails = new User(id, " -- Data Not available");
			}
			return userDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
