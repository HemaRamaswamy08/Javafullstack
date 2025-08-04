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

public class SearchMusicServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // IMPORTANT: Set the content type to HTML
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8"); // Ensure proper character encoding
        PrintWriter out = res.getWriter();

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/jdbc";
		String dbUser = "root";
		String dbPassword = "root";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // Start HTML response structure
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Search Result</title>");
        out.println("<style>");
        out.println("body { font-family: 'Inter', sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; background-color: #f0f2f5; margin: 0; color: #333; }");
        out.println(".container { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1); text-align: center; max-width: 500px; width: 90%; }");
        out.println("h2 { color: #007bff; margin-bottom: 20px; font-size: 2em; }");
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
            int musicIdToSearch;
            try {
                musicIdToSearch = Integer.parseInt(req.getParameter("id"));
            } catch (NumberFormatException e) {
                out.println("<h2>Error: Invalid Music ID!</h2>");
                out.println("<p class=\"error-message\">Music ID must be a valid number for search.</p>");
                out.println("<div class=\"button-group\">");
                out.println("<p><a href=\"search.jsp\">Go back to search form</a></p>");
                out.println("<p><a href=\"home.html\">Go to Home</a></p>");
                out.println("</div>");
                out.println("</div></body></html>"); // Close HTML structure
                return; // Stop further processing
            }

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query to select data
            String sql = "SELECT music_Id, song_name, movie_name, movie_year FROM musicplayer WHERE music_Id = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, musicIdToSearch);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Song found, display details
                Integer foundMusicId = rs.getInt("music_Id");
                String foundTitle = rs.getString("song_name");
                String foundMovieName = rs.getString("movie_name");
                Integer foundYear = rs.getInt("movie_year");

                out.println("<h2>Search Result: Song Found!</h2>");
                out.println("<p class=\"success-message\">Song details for Music ID <strong>" + foundMusicId + "</strong>:</p>");
                out.println("<p><strong>Title:</strong> " + foundTitle + "</p>");
                out.println("<p><strong>Movie Name:</strong> " + foundMovieName + "</p>");
                out.println("<p><strong>Year:</strong> " + foundYear + "</p>");
            } else {
                // No song found with the given ID
                out.println("<h2>Search Result: Not Found</h2>");
                out.println("<p class=\"info-message\">No song found with Music ID <strong>" + musicIdToSearch + "</strong>.</p>");
            }

            out.println("<div class=\"button-group\">");
            out.println("<p><a href=\"search.jsp\">Search another song</a></p>");
            out.println("<p><a href=\"home.html\">Go to Home</a></p>");
            out.println("</div>");

        } catch (Exception e) {
            // Catch all other exceptions
            out.println("<h2>Error: Database Operation Failed</h2>");
            out.println("<p class=\"error-message\">An error occurred during search: " + e.getMessage() + "</p>");
            out.println("<p>Please check your database connection and servlet logs.</p>");
            out.println("<div class=\"button-group\">");
            out.println("<p><a href=\"search.jsp\">Go back to search form</a></p>");
            out.println("<p><a href=\"home.html\">Go to Home</a></p>");
            out.println("</div>");
            // Log the exception for server-side debugging
            throw new ServletException("Database or Servlet Error during search", e);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                System.err.println("Error closing ResultSet in SearchMusicServlet: " + e.getMessage());
            }
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                System.err.println("Error closing PreparedStatement in SearchMusicServlet: " + e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println("Error closing Connection in SearchMusicServlet: " + e.getMessage());
            }
        }
        out.println("</div></body></html>"); // Ensure closing tags are always printed
    }
}
