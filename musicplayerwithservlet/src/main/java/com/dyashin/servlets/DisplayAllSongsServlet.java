package com.dyashin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayAllSongsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Set the content type to HTML
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();

		// Database connection details
		String jdbcURL = "jdbc:mysql://localhost:3306/java";
		String dbUser = "root";
		String dbPassword = "root";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Start HTML response structure
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println(
				"<head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>All Songs</title>");
		out.println("<style>");
		out.println(
				"body { font-family: 'Inter', sans-serif; display: flex; justify-content: center; align-items: flex-start; min-height: 100vh; background-color: #f0f2f5; margin: 0; padding-top: 50px; color: #333; }");
		out.println(
				".container { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1); text-align: center; max-width: 900px; width: 90%; }");
		out.println("h2 { color: #17a2b8; margin-bottom: 30px; font-size: 2.2em; }");
		out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
		out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
		out.println("th { background-color: #f2f2f2; color: #555; font-weight: bold; }");
		out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
		out.println("tr:hover { background-color: #e9e9e9; }");
		out.println(".no-songs-message { color: #6c757d; font-weight: bold; margin-top: 20px; }");
		out.println(".error-message { color: #dc3545; font-weight: bold; margin-top: 20px; }");
		out.println(
				".back-link { display: block; margin-top: 30px; color: #007bff; text-decoration: none; font-weight: bold; }");
		out.println(".back-link:hover { text-decoration: underline; }");
		out.println(".delete-link { color: #dc3545; text-decoration: none; font-weight: bold; }"); // Added style for delete link
		out.println(".delete-link:hover { text-decoration: underline; }");
		out.println(".add-song-button {");
		out.println("    display: inline-block;");
		out.println("    background-color: #28a745; /* Green color */");
		out.println("    color: white;");
		out.println("    padding: 12px 25px;");
		out.println("    border: none;");
		out.println("    border-radius: 8px;");
		out.println("    font-size: 1.1em;");
		out.println("    cursor: pointer;");
		out.println("    text-decoration: none;"); // Remove underline for link
		out.println("    transition: background-color 0.3s ease, transform 0.2s ease;");
		out.println("    margin-bottom: 30px;"); // Space below the button
		out.println("    box-shadow: 0 4px 8px rgba(40, 167, 69, 0.3);");
		out.println("}");
		out.println(".add-song-button:hover {");
		out.println("    background-color: #218838;");
		out.println("    transform: translateY(-2px);");
		out.println("}");
		out.println(".add-song-button:active {");
		out.println("    transform: translateY(0);");
		out.println("    box-shadow: 0 2px 4px rgba(40, 167, 69, 0.4);");
		out.println("}");
		out.println("</style>");
		out.println("</style>");
		out.println("</head><body><div class=\"container\">");
		out.println("<h1>Welcome to Aptify <h2>");
		
		out.println("<h2>All Songs in Database</h2>");
		out.println("<a href=\"index.jsp\" class=\"add-song-button\">Add New Song</a>");

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the database connection
			conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

			// SQL query to select all data
			String sql = "SELECT music_Id, song_name, movie_name, movie_year FROM musicplayer ORDER BY music_Id ASC";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) { // Check if ResultSet has any rows
				out.println("<table>");
				out.println(
						"<thead><tr><th>Music ID</th><th>Title</th><th>Movie Name</th><th>Year</th><th colspan=2>Operation</th></tr></thead>");
				out.println("<tbody>");
				while (rs.next()) {
					int musicId = rs.getInt("music_Id"); // Get the music ID
					out.println("<tr>");
					out.println("<td>" + musicId + "</td>");
					out.println("<td>" + rs.getString("song_name") + "</td>");
					out.println("<td>" + rs.getString("movie_name") + "</td>");
					out.println("<td>" + rs.getInt("movie_year") + "</td>");
					out.println("<td><a href=\"update.jsp?id=" + musicId + "\" class=\"back-link\">Update</a></td>");
					out.println("<td><a href=\"deleteSong?id=" + musicId + "\" class=\"delete-link\" onclick=\"return confirm('Are you sure you want to delete this song with ID " + musicId + "?');\">Delete</a></td>");
					out.println("</tr>");
				}
				out.println("</tbody>");
				out.println("</table>");
			} else {
				out.println("<p class=\"no-songs-message\">No songs found in the database.</p>");
			}

		} catch (Exception e) {
			// Catch all other exceptions
			out.println(
					"<p class=\"error-message\">An error occurred while fetching songs: " + e.getMessage() + "</p>");
			out.println("<p>Please check your database connection and servlet logs.</p>");
			// Log the exception for server-side debugging
			throw new ServletException("Database or Servlet Error during display all songs", e);
		} finally {
			// Close resources
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.err.println("Error closing ResultSet in DisplayAllSongsServlet: " + e.getMessage());
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.err.println("Error closing PreparedStatement in DisplayAllSongsServlet: " + e.getMessage());
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.err.println("Error closing Connection in DisplayAllSongsServlet: " + e.getMessage());
			}
		}
		out.println("</div></body></html>"); // Ensure closing tags are always printed
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res); // Redirect POST to GET for simplicity
	}
}
