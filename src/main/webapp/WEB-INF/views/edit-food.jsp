<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Food Item</title>
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
    color: #ffc107;
    margin-bottom: 20px;
}
label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #333;
    text-align: left;
}
input[type="text"],
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
    background-color: #007bff;
    color: #fff;
    margin-bottom: 10px;
}
input[type="submit"]:hover {
    background-color: #0056b3;
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
		<h2>Edit Food Item</h2>
		<form:form action="editFood" method="post" modelAttribute="food">
            <form:hidden path="id"/>

            <label for="name">Name:</label>
			<form:input type="text" id="name" path="name"/><br/>
            
            <label for="type">Type:</label>
            <form:input type="text" id="type" path="type"/><br/>
            
            <label for="description">Description:</label>
            <form:input type="text" id="description" path="description"/><br/>
            
            <label for="cost">Cost:</label>
			<form:input type="number" path="cost"/><br/>
            
            <label for="quantity">Quantity:</label>
			<form:input type="text" id="quantity" path="quantity"/><br/>
			
			<input type="submit" value="Update Food">
		</form:form>
    </div>
</body>
</html>