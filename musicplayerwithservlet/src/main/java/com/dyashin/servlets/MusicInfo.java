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

public class MusicInfo extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String movie = req.getParameter("movie");
        int year = Integer.parseInt(req.getParameter("year"));

        String jdbcURL = "jdbc:mysql://localhost:3306/jdbc";
        String dbUser = "root";
        String dbPassword = "root";
        Connection conn = null;
        PreparedStatement stmt = null;
        PrintWriter out = res.getWriter();
        res.setContentType("text/html"); // Set content type to HTML

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "INSERT INTO musicplayer (music_Id, song_name,movie_name,movie_year) VALUES (?, ?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, title);
            stmt.setString(3, movie);
            stmt.setInt(4, year);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                // Generate success HTML directly
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("    <meta charset=\"UTF-8\">");
                out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("    <title>Success! 🎉</title>");
                out.println("    <style>");
                out.println("        body {");
                out.println("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
                out.println("            background-color: #e0f7fa; /* Light cyan background */");
                out.println("            display: flex;");
                out.println("            justify-content: center;");
                out.println("            align-items: center;");
                out.println("            min-height: 100vh;");
                out.println("            margin: 0;");
                out.println("            color: #333;");
                out.println("        }");
                out.println("        .container {");
                out.println("            background-color: #ffffff;");
                out.println("            padding: 40px 60px;");
                out.println("            border-radius: 12px;");
                out.println("            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);");
                out.println("            text-align: center;");
                out.println("            max-width: 500px;");
                out.println("            width: 90%;");
                out.println("            animation: fadeIn 1s ease-in-out;");
                out.println("        }");
                out.println("        h1 {");
                out.println("            color: #28a745; /* Green for success */");
                out.println("            margin-bottom: 20px;");
                out.println("            font-size: 2.5em;");
                out.println("            display: flex;");
                out.println("            align-items: center;");
                out.println("            justify-content: center;");
                out.println("        }");
                out.println("        h1::before {");
                out.println("            content: '✅'; /* Checkmark emoji */");
                out.println("            margin-right: 15px;");
                out.println("            font-size: 1.2em;");
                out.println("        }");
                out.println("        p {");
                out.println("            font-size: 1.2em;");
                out.println("            line-height: 1.6;");
                out.println("            color: #555;");
                out.println("            margin-bottom: 30px;");
                out.println("        }");
                out.println("        .button {");
                out.println("            display: inline-block;");
                out.println("            background-color: #007bff; /* Blue button */");
                out.println("            color: white;");
                out.println("            padding: 12px 25px;");
                out.println("            border-radius: 8px;");
                out.println("            text-decoration: none;");
                out.println("            font-size: 1em;");
                out.println("            transition: background-color 0.3s ease, transform 0.2s ease;");
                out.println("        }");
                out.println("        .button:hover {");
                out.println("            background-color: #0056b3;");
                out.println("            transform: translateY(-2px);");
                out.println("        }");
                out.println("        @keyframes fadeIn {");
                out.println("            from { opacity: 0; transform: translateY(-20px); }");
                out.println("            to { opacity: 1; transform: translateY(0); }");
                out.println("        }");
                out.println("    </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("    <div class=\"container\">");
                out.println("        <h1>Operation Successful!</h1>");
                out.println("        <p>Song information saved successfully! 🎵</p>");
                out.println("        <a href=\"index.jsp\" class=\"button\">Go Back to Home</a>");
                out.println("    </div>");
                out.println("</body>");
                out.println("</html>");

            } else {
                // Generate error HTML directly
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("    <meta charset=\"UTF-8\">");
                out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("    <title>Error! ❌</title>");
                out.println("    <style>");
                out.println("        body {");
                out.println("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
                out.println("            background-color: #ffebee; /* Light red background */");
                out.println("            display: flex;");
                out.println("            justify-content: center;");
                out.println("            align-items: center;");
                out.println("            min-height: 100vh;");
                out.println("            margin: 0;");
                out.println("            color: #333;");
                out.println("        }");
                out.println("        .container {");
                out.println("            background-color: #ffffff;");
                out.println("            padding: 40px 60px;");
                out.println("            border-radius: 12px;");
                out.println("            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);");
                out.println("            text-align: center;");
                out.println("            max-width: 500px;");
                out.println("            width: 90%;");
                out.println("            animation: fadeIn 1s ease-in-out;");
                out.println("        }");
                out.println("        h1 {");
                out.println("            color: #dc3545; /* Red for error */");
                out.println("            margin-bottom: 20px;");
                out.println("            font-size: 2.5em;");
                out.println("            display: flex;");
                out.println("            align-items: center;");
                out.println("            justify-content: center;");
                out.println("        }");
                out.println("        h1::before {");
                out.println("            content: '❌'; /* Cross mark emoji */");
                out.println("            margin-right: 15px;");
                out.println("            font-size: 1.2em;");
                out.println("        }");
                out.println("        p {");
                out.println("            font-size: 1.2em;");
                out.println("            line-height: 1.6;");
                out.println("            color: #555;");
                out.println("            margin-bottom: 30px;");
                out.println("        }");
                out.println("        .button {");
                out.println("            display: inline-block;");
                out.println("            background-color: #6c757d; /* Grey button */");
                out.println("            color: white;");
                out.println("            padding: 12px 25px;");
                out.println("            border-radius: 8px;");
                out.println("            text-decoration: none;");
                out.println("            font-size: 1em;");
                out.println("            transition: background-color 0.3s ease, transform 0.2s ease;");
                out.println("        }");
                out.println("        .button:hover {");
                out.println("            background-color: #5a6268;");
                out.println("            transform: translateY(-2px);");
                out.println("        }");
                out.println("        @keyframes fadeIn {");
                out.println("            from { opacity: 0; transform: translateY(-20px); }");
                out.println("            to { opacity: 1; transform: translateY(0); }");
                out.println("        }");
                out.println("    </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("    <div class=\"container\">");
                out.println("        <h1>Operation Failed!</h1>");
                out.println("        <p>Failed to save song information. Please try again.</p>");
                out.println("        <a href=\"index.jsp\" class=\"button\">Go Back to Home</a>");
                out.println("    </div>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            // Generate error HTML for database connection/SQL errors
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("    <title>Error! ❌</title>");
            out.println("    <style>");
            out.println("        body {");
            out.println("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
            out.println("            background-color: #ffebee; /* Light red background */");
            out.println("            display: flex;");
            out.println("            justify-content: center;");
            out.println("            align-items: center;");
            out.println("            min-height: 100vh;");
            out.println("            margin: 0;");
            out.println("            color: #333;");
            out.println("        }");
            out.println("        .container {");
            out.println("            background-color: #ffffff;");
            out.println("            padding: 40px 60px;");
            out.println("            border-radius: 12px;");
            out.println("            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);");
            out.println("            text-align: center;");
            out.println("            max-width: 500px;");
            out.println("            width: 90%;");
            out.println("            animation: fadeIn 1s ease-in-out;");
            out.println("        }");
            out.println("        h1 {");
            out.println("            color: #dc3545; /* Red for error */");
            out.println("            margin-bottom: 20px;");
            out.println("            font-size: 2.5em;");
            out.println("            display: flex;");
            out.println("            align-items: center;");
            out.println("            justify-content: center;");
            out.println("        }");
            out.println("        h1::before {");
            out.println("            content: '❌'; /* Cross mark emoji */");
            out.println("            margin-right: 15px;");
            out.println("            font-size: 1.2em;");
            out.println("        }");
            out.println("        p {");
            out.println("            font-size: 1.2em;");
            out.println("            line-height: 1.6;");
            out.println("            color: #555;");
            out.println("            margin-bottom: 30px;");
            out.println("        }");
            out.println("        .button {");
            out.println("            display: inline-block;");
            out.println("            background-color: #6c757d; /* Grey button */");
            out.println("            color: white;");
            out.println("            padding: 12px 25px;");
            out.println("            border-radius: 8px;");
            out.println("            text-decoration: none;");
            out.println("            font-size: 1em;");
            out.println("            transition: background-color 0.3s ease, transform 0.2s ease;");
            out.println("        }");
            out.println("        .button:hover {");
            out.println("            background-color: #5a6268;");
            out.println("            transform: translateY(-2px);");
            out.println("        }");
            out.println("        @keyframes fadeIn {");
            out.println("            from { opacity: 0; transform: translateY(-20px); }");
            out.println("            to { opacity: 1; transform: translateY(0); }");
            out.println("        }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class=\"container\">");
            out.println("        <h1>Error Occurred!</h1>");
            out.println("        <p>An error occurred: " + e.getMessage() + "</p>"); // Display the actual error message
            out.println("        <a href=\"index.jsp\" class=\"button\">Go Back to Home</a>");
            out.println("    </div>");
            out.println("</"
            		+ "body>");
            out.println("</html>");
            // You can still log the exception for debugging purposes
            System.err.println("Database Error in MusicInfo servlet: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) { /* Log error */ }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) { /* Log error */ }
            if (out != null) {
                out.close(); // Close the PrintWriter
            }
        }
    }
}