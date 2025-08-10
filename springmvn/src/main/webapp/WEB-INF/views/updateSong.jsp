<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<title>Update Song</title>
</head>
<body>

	<c:if test="${not empty msg}">
		<h1 style="color: green;">${msg}</h1>
		<a href="songs">To We All SOngs</a>
	</c:if>
	<c:if test="${empty msg }">

		<form action="update" method="post">
			<label>Enter Music ID:</label> <input type="text" name="musicId"
				value="${music.musicId}" readonly="readonly" /><br> <label>Enter
				Song Name:</label> <input type="text" name="songName"
				value="${music.songName}" /><br> <label>Enter Movie
				Name:</label> <input type="text" name="movieName" value="${music.movieName}" /><br>

			<label>Enter Movie Year:</label> <input type="text" name="movieYear"
				value="${music.movieYear}" /><br> <input type="submit"
				value="Update" />
		</form>
	</c:if>
</body>
</html>
