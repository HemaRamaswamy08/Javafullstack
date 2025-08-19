<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Food</title>
<style>
/* Style for the body and form container */
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
}

/* Style for labels and inputs */
label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #333;
}

input[type="text"],
input[type="number"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box; /* Ensures padding doesn't affect the width */
}

/* Style for the submit button */
input[type="submit"] {
    width: 100%;
    background-color: #007bff;
    color: #fff;
    padding: 12px;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>

	<div class="form-container">
		<h2>Add New Food Item</h2>
		<form action="addFood" method="post">
            <label for="name">Name:</label>
			<input type="text" id="name" name="name"><br> 
            
            <label for="type">Type:</label>
            <input type="text" id="type" name="type"><br> 
            
            <label for="description">Description:</label>
            <input type="text" id="description" name="description"><br>
            
            <label for="cost">Cost:</label>
			<input type="number" name="cost" required="required"><br>
            
            <label for="quantity">Quantity:</label>
			<input type="text" id="quantity" name="quantity"><br> 
			
			<input type="submit" value="Add">
		</form>
	</div>


</body>
</html>