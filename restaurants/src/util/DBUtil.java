package util;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.FoodMenuDTO;

public class DBUtil {
	private DBUtil() {

	}

	static List<FoodMenuDTO> arr = new ArrayList<>();

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/restaurants?user=root&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

}
