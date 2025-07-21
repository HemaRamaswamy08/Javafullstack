package com.dyashin.jdbcmaven.designpattern.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dyashin.jdbcmaven.designpattern.dto.User;
import com.dyashin.jdbcmaven.designpattern.util.ConnectionPool;
import com.dyashin.jdbcmaven.designpattern.util.GetPropertyDetails;
import com.dyashin.jdbcmaven.designpattern.util.Property;

public class EmployeeDAOOracleImpl implements EmployeeDAO {

	Statement stmt = null;
	ResultSet rs = null;
	Connection conn = null;

	public void getAllUser() {
		try {
			conn = ConnectionPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(GetPropertyDetails.getQueryAllUser(Property.QUERY_ALL_USER));
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("user_id") + ", Username: " + rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				ConnectionPool.returnConnection(conn);
			}
		}

	}

	public User getUserOne() {
		User user = new User();
		try {
			conn = ConnectionPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(GetPropertyDetails.getQueryOneUser(Property.QUERY_ONE_USER));
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("username"));

				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
}
