<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dyashin.springmvc.model.Music"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete BY id</title>
</head>
<body>

	<h2>Delete OPerataion</h2>
	<form action="delete" method="get">
		Enter User ID: <input type="text" name="musicId"> <input
			type="submit" value="Delete">
	</form>


</body>
</html>