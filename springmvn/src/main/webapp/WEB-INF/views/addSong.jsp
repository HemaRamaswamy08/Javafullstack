<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Song</title>
</head>
<body>

<c:if test="${not empty msg}">
    <h1 style="color: green;">${msg}</h1>
    <a href="adding"><button>Add Another Song</button></a>
    <a href="songs"><button>View All Songs</button></a>
</c:if>

<c:if test="${empty msg}">
    <h2>Add a Song</h2>
    <form action="add" method="post">
        Enter Music ID: <input type="text" name="musicId"><br>
        Enter Song Name: <input type="text" name="songName"><br>
        Enter Artist: <input type="text" name="movieName"><br>
        Enter Year: <input type="text" name="movieYear"><br>
        <input type="submit" value="Submit">
    </form>
</c:if>

</body>
</html>
