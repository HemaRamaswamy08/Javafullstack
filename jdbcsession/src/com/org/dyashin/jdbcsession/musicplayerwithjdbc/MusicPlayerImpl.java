package com.org.dyashin.jdbcsession.musicplayerwithjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicPlayerImpl {

	private static String dburl = "jdbc:mysql://localhost:3306/java?user=root&password=root";
	private static Connection conn = null;
	private static Statement statement = null;
	private static PreparedStatement prepstmt = null;
	private static ResultSet result = null;
	private static String query = null;
	private static int rowsEffected = 0;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addSong(int id, String name, String movieName, int year) {
		query = "Insert into musicplayer values (?,?,?,?) ";
		try {
			prepstmt = conn.prepareStatement(query);
			prepstmt.setInt(1, id);
			prepstmt.setString(2, name);
			prepstmt.setString(3, movieName);
			prepstmt.setInt(4, year);

			rowsEffected = prepstmt.executeUpdate();
			System.out.println("Added " + rowsEffected + " data sucessfully");
		} catch (SQLException e) {
			System.out.println("Error while adding song :" + e.getMessage());
		}

	}

	public static void display() {
		query = "select * from  musicplayer";
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int movieId = result.getInt("music_Id");
				String songName = result.getString("song_name");
				String movieName = result.getString("movie_name");
				int year = result.getInt("movie_year");

				System.out.println("Movied Id => " + movieId);
				System.out.println("Song Name=> " + songName);
				System.out.println("Movie Name=> " + movieName);
				System.out.println("Year =>" + year);
				System.out.println();
				
			}
		} catch (SQLException e) {
			System.out.println("Error while Displaying song :" + e.getMessage());
		}
	}

	public static void updateSong(int id, String songName) {
		query = "update musicplayer set song_name = ? where music_Id=?";
		try {
			prepstmt = conn.prepareStatement(query);
			prepstmt.setString(1, songName);
			prepstmt.setInt(2, id);
			rowsEffected = prepstmt.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("updated " + rowsEffected + " row sucessfully");
			} else {
				System.out.println("Id Not Found");
			}

		} catch (SQLException e) {
			System.out.println("Error while updating song :" + e.getMessage());
		}

	}

	public static void deleteSong(int id) {
		query = "delete from musicplayer where music_Id=?";
		try {
			prepstmt = conn.prepareStatement(query);
			prepstmt.setInt(1, id);
			rowsEffected = prepstmt.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("Deleted " + rowsEffected + " row sucessfully");
			} else {
				System.out.println("Id Not Found");
			}

		} catch (SQLException e) {
			System.out.println("Error while deleting song :" + e.getMessage());
		}

	}

	public static void searchSong(int id) {
		query = "select * from musicplayer where music_Id=? ";
		try {
			prepstmt = conn.prepareStatement(query);
			prepstmt.setInt(1, id);
			result = prepstmt.executeQuery();
			if (!result.next()) {
				System.out.println("No data Found");
			}
			while (result.next()) {
				int movieId = result.getInt("music_Id");
				String songName = result.getString("song_name");
				String movieName = result.getString("movie_name");
				int year = result.getInt("movie_year");
				System.out.println("Movied Id => " + movieId);
				System.out.println("Song Name=> " + songName);
				System.out.println("Movie Name=> " + movieName);
				System.out.println("Year =>" + year);
			}

		} catch (SQLException e) {
			System.out.println("Error while Searching song " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (prepstmt != null) {
				prepstmt.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
