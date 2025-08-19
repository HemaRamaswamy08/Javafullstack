<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Menu</title>
<style>
body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 100vh;
    margin: 0;
    background-color: #f0f2f5;
    color: #333;
}
.container {
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 350px;
}
h1 {
    color: #444;
    margin-bottom: 25px;
    font-size: 2em;
}
.button-group {
    display: flex;
    flex-direction: column;
    gap: 15px;
}
.button {
    text-decoration: none;
    padding: 15px 25px;
    background-color: #007bff;
    color: white;
    border-radius: 8px;
    font-size: 1em;
    font-weight: bold;
    transition: background-color 0.3s, transform 0.2s;
    border: none;
    cursor: pointer;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
.button:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
}
.button:active {
    background-color: #004494;
    transform: translateY(0);
}
</style>
</head>
<body>

	<div class="container">
		<h1>Food Menu Operations</h1>
		<div class="button-group">
			<a href="open-food-menu" class="button">Open Food Menu</a>
			<a href="display/search-food" class="button">Search the Food</a>
			<a href="display/displayAllFood" class="button"> Show All Food Items</a>
			<a href="operate-on-db" class="button">Operate on Food Database</a>
		</div>
	</div>

</body>
</html>