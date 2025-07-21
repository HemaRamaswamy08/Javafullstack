package com.dyashin.myfirstwebapp.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String currentDataTime = new Date().toString();
		String htmlResponse = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">"
				+ "<title>My First HTML</title>" + "</head>" + "<body>" + "<h1>Current Date and Time is : <br>"
				+ "<span style=\"color:blue\">" + currentDataTime + "</span></h1>" + "<br><br>" + "</body>" + "</html>";

		resp.setContentType("text/html");
		resp.setHeader("Refresh", "1");

		PrintWriter out = resp.getWriter();
		out.print(htmlResponse);

	}

}
