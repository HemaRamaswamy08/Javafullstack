<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dyashin.springmvc.model.Music" %>
<!DOCTYPE html>
<html>
<head>
<title>Search User by ID</title>
</head>
<body>
	<h2>Search for a User by ID</h2>
	<form action="search" method="get">
		Enter User ID: <input type="text" name="musicId"> <input
			type="submit" value="Search">
	</form>

	<%
		String error = (String) request.getAttribute("error");
		if (error != null && !error.isEmpty()) {
	%>
		<p style='color: red;'><%= error %></p>
	<%
		}
	%>

	<%
		Music music = (Music) request.getAttribute("music");
		if (music != null) {
	%>
		<h3>Search Results:</h3>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Song Name</th>
					<th>Artist</th>
					<th>Movie Year</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%= music.getMusicId() %></td>
					<td><%= music.getSongName() %></td>
					<td><%= music.getMovieName() %></td>
					<td><%= music.getMovieYear() %></td>
				</tr>
			</tbody>
		</table>
	<%
		}
	%>

	<%
		String musicIdParam = request.getParameter("musicId");
		Music musicResult = (Music) request.getAttribute("music");
		if (musicResult == null && musicIdParam != null && !musicIdParam.isEmpty()) {
	%>
		<p>No music found with that ID.</p>
	<%
		}
	%>
</body>
</html>