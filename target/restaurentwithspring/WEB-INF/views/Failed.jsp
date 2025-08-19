<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f2f5;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 100vh;
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
h2 {
    color: #28a745; /* Green color for success messages */
    margin-bottom: 20px;
    font-size: 2em;
}
p {
    font-size: 1.2em;
    color: #555;
    margin-bottom: 30px;
}
.button {
    text-decoration: none;
    padding: 15px 25px;
    background-color: #6c757d; /* Gray color for back button */
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
    background-color: #5a6268;
    transform: translateY(-2px);
}
.button:active {
    background-color: #545b62;
    transform: translateY(0);
}
.button-group {
    display: flex;
    flex-direction: column;
    gap: 15px; /* Adds space between buttons */
}
</style>
</head>
<body>

	<div class="container">
		<h2>Failed!</h2>
		<p>${message}</p>
		<div class="button-group">
		    <a href="javascript:history.back()" class="button">${operation} Another Food</a>
		    <a href="/restaurentwithspring/restaurent/home" class="button">Go Back to Home</a>
		</div>
	</div>

</body>
</html>