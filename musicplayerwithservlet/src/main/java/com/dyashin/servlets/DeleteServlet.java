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

public class DeleteServlet extends HttpServlet {

    // Helper method to perform the deletion logic and redirection
    private void processDeleteRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Set content type for potential error messages before redirect
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter(); // Get writer for potential error output

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/java";
        String dbUser = "root";
        String dbPassword = "root";

        Connection conn = null;
        PreparedStatement stmt = null;
        int musicIdToDelete = -1; // Initialize with an invalid ID

        try {
            // Get the music ID from the request parameter
            String idParam = req.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                musicIdToDelete = Integer.parseInt(idParam);
            } else {
                // If no ID is provided, redirect back to the display page with an error status
                res.sendRedirect("displayAllSongs?status=invalidId");
                return; // Stop further processing
            }

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query to delete a song by ID
            String sql = "DELETE FROM musicplayer WHERE music_Id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, musicIdToDelete);

            // Execute the delete operation
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                // Deletion successful, redirect back to display page with success status
                res.sendRedirect("displayAllSongs?status=deleted&id=" + musicIdToDelete);
            } else {
                // No song found with the given ID, or deletion failed (e.g., ID didn't exist)
                res.sendRedirect("displayAllSongs?status=notFound&id=" + musicIdToDelete);
            }

        } catch (NumberFormatException e) {
            // Handle invalid ID format gracefully
            System.err.println("Invalid Music ID format received for deletion: " + req.getParameter("id") + " - " + e.getMessage());
            // Redirect back to display page with an error status
            res.sendRedirect("displayAllSongs?status=invalidIdFormat");
        } catch (Exception e) {
            // Catch all other exceptions (e.g., database connection issues, SQL errors)
            System.err.println("Error deleting song with ID " + musicIdToDelete + ": " + e.getMessage());
            // Redirect back to display page with a generic error status
            res.sendRedirect("displayAllSongs?status=error&id=" + musicIdToDelete);
            // Re-throw as ServletException for server-side logging
            throw new ServletException("Database or Servlet Error during song deletion", e);
        } finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {
                System.err.println("Error closing PreparedStatement in DeleteSongServlet: " + e.getMessage());
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.err.println("Error closing Connection in DeleteSongServlet: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Call the shared processing method for GET requests
        processDeleteRequest(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Call the shared processing method for POST requests
        processDeleteRequest(req, res);
    }
}
