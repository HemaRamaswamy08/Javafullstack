<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Selection</title>
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
    background-color: #28a745; /* A pleasant green color */
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
    background-color: #218838;
    transform: translateY(-2px);
}
.button:active {
    background-color: #1e7e34;
    transform: translateY(0);
}
.back-button {
    margin-top: 20px;
    text-decoration: none;
    padding: 12px 25px;
    background-color: #6c757d;
    color: white;
    border-radius: 8px;
    font-size: 1em;
    font-weight: bold;
    transition: background-color 0.3s;
    border: none;
    cursor: pointer;
}
.back-button:hover {
    background-color: #5a6268;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Food Selection Options</h1>
		<div class="button-group">
			<a href="display/displayAllFood" class="button"> Display All Food Items</a>
			<a href="display/randomFoodDisplay" class="button">Display Food Items Randomly</a>
			<a href="display/particularFood" class="button">Display Particular Food</a>
		</div>
		<a href="javascript:history.back()" class="back-button">Go Back</a>
	</div>

</body>
</html>