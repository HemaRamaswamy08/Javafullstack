package com.dyashin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateMusicServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Set the content type for the response
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();

		String jdbcURL = "jdbc:mysql://localhost:3306/jdbc";
		String dbUser = "root";
		String dbPassword = "root";

		Connection conn = null;
		PreparedStatement stmt = null;

		// Start HTML response structure
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println(
				"<head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Update Song Result</title>");
		out.println("<style>");
		out.println(
				"body { font-family: 'Inter', sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; background-color: #f0f2f5; margin: 0; color: #333; }");
		out.println(
				".container { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1); text-align: center; max-width: 500px; width: 90%; }");
		out.println("h2 { color: #6f42c1; margin-bottom: 20px; font-size: 2em; }");
		out.println("p { margin-bottom: 10px; line-height: 1.5; }");
		out.println("p strong { color: #555; }");
		out.println(".success-message { color: #28a745; font-weight: bold; }");
		out.println(".info-message { color: #6c757d; font-weight: bold; }");
		out.println(".error-message { color: #dc3545; font-weight: bold; }");
		out.println("a { color: #007bff; text-decoration: none; font-weight: bold; margin: 0 10px; }");
		out.println("a:hover { text-decoration: underline; }");
		out.println(".button-group { margin-top: 30px; }");
		out.println("</style>");
		out.println("</head><body><div class=\"container\">");

		try {
			// Parse the music ID from the form
			int musicIdToUpdate;
			try {
				musicIdToUpdate = Integer.parseInt(req.getParameter("id"));
			} catch (NumberFormatException e) {
				out.println("<h2>Error: Invalid Music ID!</h2>");
				out.println("<p class=\"error-message\">Music ID must be a valid number for update.</p>");
				out.println("<div class=\"button-group\">");
				out.println("<p><a href=\"update.jsp\">Go back to update form</a></p>");
				out.println("<p><a href=\"home.html\">Go to Home</a></p>");
				out.println("</div>");
				out.println("</div></body></html>");
				return; // Stop further processing
			}

			String newTitle = req.getParameter("newTitle");
			String newMovie = req.getParameter("newMovie");

			// Check if at least one field is provided for update
			if ((newTitle == null || newTitle.trim().isEmpty()) && (newMovie == null || newMovie.trim().isEmpty())) {
				out.println("<h2>Error: No Update Data Provided!</h2>");
				out.println("<p class=\"error-message\">Please provide a new Title or a new Movie Name to update.</p>");
				out.println("<div class=\"button-group\">");
				out.println("<p><a href=\"update.jsp\">Go back to update form</a></p>");
				out.println("<p><a href=\"home.html\">Go to Home</a></p>");
				out.println("</div>");
				out.println("</div></body></html>");
				return; // Stop further processing
			}

			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the database connection
			conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

			// Dynamically build the SQL UPDATE query
			StringBuilder sqlBuilder = new StringBuilder("UPDATE musicplayer SET ");
			boolean firstParam = true;

			if (newTitle != null && !newTitle.trim().isEmpty()) {
				sqlBuilder.append("song_name = ?");
				firstParam = false;
			}
			if (newMovie != null && !newMovie.trim().isEmpty()) {
				if (!firstParam) {
					sqlBuilder.append(", ");
				}
				sqlBuilder.append("movie_name = ?");
			}
			sqlBuilder.append(" WHERE music_Id = ?");

			String sql = sqlBuilder.toString();
			stmt = conn.prepareStatement(sql);

			int paramIndex = 1;
			if (newTitle != null && !newTitle.trim().isEmpty()) {
				stmt.setString(paramIndex++, newTitle);
			}
			if (newMovie != null && !newMovie.trim().isEmpty()) {
				stmt.setString(paramIndex++, newMovie);
			}
			stmt.setInt(paramIndex, musicIdToUpdate); // The last parameter is always the ID

			// Execute the update
			int rowsAffected = stmt.executeUpdate();

			// Send response back to the client
			if (rowsAffected > 0) {
				out.println("<h2>Success!</h2>");
				out.println("<p class=\"success-message\">Song with Music ID <strong>" + musicIdToUpdate
						+ "</strong> updated successfully!</p>");
				if (newTitle != null && !newTitle.trim().isEmpty()) {
					out.println("<p>New Title: <strong>" + newTitle + "</strong></p>");
				}
				if (newMovie != null && !newMovie.trim().isEmpty()) {
					out.println("<p>New Movie Name: <strong>" + newMovie + "</strong></p>");
				}
			} else {
				out.println("<h2>Failed!</h2>");
				out.println("<p class=\"info-message\">No song found with Music ID <strong>" + musicIdToUpdate
						+ "</strong>, or no changes were made.</p>");
			}
			out.println("<div class=\"button-group\">");
			out.println("<p><a href=\"update.jsp\">Update another song</a></p>");
			out.println("<p><a href=\"displayAllSongs\">Go to Home</a></p>");
			out.println("</div>");

		} catch (Exception e) {
			// Catch all other exceptions
			out.println("<h2>Error: Database Operation Failed</h2>");
			out.println(
					"<p class=\"error-message\">An error occurred while trying to update the song information.</p>");
			out.println("<p>Please check your database connection and servlet logs.</p>");
			out.println("<p class=\"error-message\">Error details: " + e.getMessage() + "</p>");
			out.println("<div class=\"button-group\">");
			out.println("<p><a href=\"update.jsp\">Go back to update form</a></p>");
			out.println("<p><a href=\"displayAllSongs\">Go to Home</a></p>");
			out.println("</div>");
			// Log the exception for server-side debugging
			throw new ServletException("Database or Servlet Error during update", e);
		} finally {
			// Close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.err.println("Error closing PreparedStatement in UpdateMusicServlet: " + e.getMessage());
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.err.println("Error closing Connection in UpdateMusicServlet: " + e.getMessage());
			}
		}
		out.println("</div></body></html>"); // Ensure closing tags are always printed
	}
}
