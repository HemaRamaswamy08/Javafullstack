<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dyashin.springmvc.model.Music"%>

<html>
<head>
<title>All Songs</title>
</head>
<body>
	<h2>All Songs</h2>

	<%
	List<Music> songs = (List<Music>) request.getAttribute("songs");
	if (songs != null && !songs.isEmpty()) {
	%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Song Name</th>
			<th>Artist</th>
			<th>Movie Year</th>
			<th>Actions</th>
		</tr>
		<%
		for (Music song : songs) {
		%>
		<tr>
			<td><%=song.getMusicId()%></td>
			<td><%=song.getSongName()%></td>
			<td><%=song.getMovieName()%></td>
			<td><%=song.getMovieYear()%></td>
			<td>
				<form action="editSong" method="get" style="display: inline;">
					<input type="hidden" name="musicId"
						value="<%=song.getMusicId()%>"> <input type="submit"
						value="Update">
				</form>

				<form action="delete" method="get" style="display: inline;"
					onsubmit="return confirm('Are you sure you want to delete this song?');">
					<input type="hidden" name="musicId"
						value="<%=song.getMusicId()%>"> <input type="submit"
						value="Delete">
				</form>

			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>No songs found.</p>
	<%
	}
	%>
	<br>
	<br>

	<a href="adding">
		<button style="padding: 15px;">Add</button>
	</a>

</body>
</html>
