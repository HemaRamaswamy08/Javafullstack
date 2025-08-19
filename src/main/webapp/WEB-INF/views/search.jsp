<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search for Food</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f2f5;
    margin: 0;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    min-height: 100vh;
}
.container {
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 90%;
    max-width: 800px;
    margin-bottom: 20px;
}
h1 {
    color: #444;
    margin-bottom: 20px;
    font-size: 2em;
}
.search-form {
    margin-bottom: 30px;
}
input[type="text"] {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    width: 60%;
    margin-right: 10px;
}
input[type="submit"] {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type="submit"]:hover {
    background-color: #0056b3;
}
.table-container {
    margin-top: 20px;
    width: 100%;
}
table {
    width: 100%;
    border-collapse: collapse;
}
th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}
th {
    background-color: #007bff;
    color: white;
    font-weight: bold;
}
tr:nth-child(even) {
    background-color: #f2f2f2;
}
tr:hover {
    background-color: #e9e9e9;
}
.message {
    font-size: 1.2em;
    font-weight: bold;
    color: #dc3545;
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
        <h1>Search for Food</h1>

        <div class="search-form">
            <form action="search-food" method="get">
                <input type="text" name="foodName" placeholder="Enter food name..." required="required"/>
                <input type="submit" value="Search"/>
            </form>
        </div>
        
        <div class="table-container">
            <c:if test="${not empty foodList}">
                <h2>Search Results</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Cost</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="food" items="${foodList}">
                            <tr>
                                <td>${food.name}</td>
                                <td>${food.type}</td>
                                <td>${food.description}</td>
                                <td>$${food.cost}</td>
                                <td>${food.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty foodList and not empty param.foodName}">
                <p class="message">No food items found with that name.</p>
            </c:if>

            <a href="javascript:history.back()" class="back-button">Go Back</a>
        </div>
    </div>
</body>
</html>