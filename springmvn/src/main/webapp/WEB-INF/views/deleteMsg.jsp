<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dyashin.springmvc.model.Music"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Music</title>
</head>
<body>
	<h2>Deleted successfully</h2>

	<%
	Music music = (Music) request.getAttribute("deletedSong");
	if (music != null) {
	%>
	<p>
		Deleted ID:
		<%=music.getMusicId()%></p>
	<p>
		Deleted Song:
		<%=music.getSongName()%></p>
	<%
	}
	%>

</body>
</html>
