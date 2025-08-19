<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Item Details</title>
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
h1 {
    color: #444;
    margin-bottom: 25px;
    font-size: 2em;
}
.food-details {
    text-align: left;
    margin-top: 20px;
}
.food-details p {
    font-size: 1.1em;
    margin: 10px 0;
}
.food-details p strong {
    color: #007bff;
}
.not-found {
    color: #dc3545;
    font-weight: bold;
    font-size: 1.2em;
}
.back-button {
    display: inline-block;
    margin-top: 30px;
    text-decoration: none;
    padding: 12px 25px;
    background-color: #6c757d;
    color: white;
    border-radius: 8px;
    font-weight: bold;
    transition: background-color 0.3s;
    border: none;
    cursor: pointer;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
.back-button:hover {
    background-color: #5a6268;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Food Item Details</h1>
        
        <c:if test="${food != null}">
            <div class="food-details">
                <p><strong>Name:</strong> ${food.name}</p>
                <p><strong>Type:</strong> ${food.type}</p>
                <p><strong>Description:</strong> ${food.description}</p>
                <p><strong>Cost:</strong> $${food.cost}</p>
                <p><strong>Quantity:</strong> ${food.quantity}</p>
            </div>
        </c:if>
        
        <c:if test="${food == null}">
            <p class="not-found">Food item not found.</p>
        </c:if>

        <a href="javascript:history.back()" class="back-button">Go Back</a>
    </div>
</body>
</html>