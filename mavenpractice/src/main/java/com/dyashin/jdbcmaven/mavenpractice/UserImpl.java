package com.dyashin.jdbcmaven.mavenpractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserImpl {

	public static List<User> getAllEmp() {
		List<User> all = new ArrayList<User>();

		try (Connection conn = DBConnection.getCon().getConnection(); Statement stmt = conn.createStatement();) {
			try (ResultSet result = stmt.executeQuery("select * from users")) {
				while (result.next()) {
					all.add(new User(result.getInt("user_id"), result.getString("username")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;

	}

}
