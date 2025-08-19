<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Food Item</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.form-container {
    background-color: #fff;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 350px;
    text-align: center;
}
h2 {
    color: #dc3545;
    margin-bottom: 20px;
}
label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #333;
}
input[type="number"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type="submit"], .back-button {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    text-decoration: none;
    display: inline-block;
    box-sizing: border-box;
    text-align: center;
}
input[type="submit"] {
    background-color: #dc3545;
    color: #fff;
    margin-bottom: 10px;
}
input[type="submit"]:hover {
    background-color: #c82333;
}
.back-button {
    background-color: #6c757d;
    color: #fff;
}
.back-button:hover {
    background-color: #5a6268;
}
</style>
</head>
<body>

	<div class="form-container">
		<h2>Delete Food Item</h2>
		<form action="deleteFood" method="post">
            <label for="foodId">Enter Food ID to Delete:</label>
			<input type="number" id="foodId" name="id" required="required"/><br/>
			<input type="submit" value="Delete">
		</form>
        <a href="javascript:history.back()" class="back-button">Go Back</a>
	</div>

</body>
</html>