<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f2f5;
	margin: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	padding-top: 50px;
	padding-bottom: 50px;
}

.container {
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
	text-align: center;
	width: 80%;
	max-width: 900px;
}

h1 {
	color: #444;
	margin-bottom: 10px;
	font-size: 2em;
}

p {
	color: #555;
	margin-bottom: 25px;
	font-size: 1.1em;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
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

.back-button {
	margin-top: 30px;
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
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.back-button:hover {
	background-color: #5a6268;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Food List</h1>
		<p>${message}</p>

		<c:if test="${empty foodList}">
			<p>No food items to display.</p>
		</c:if>

		<c:if test="${not empty foodList}">
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Type</th>
						<th>Description</th>
						<th>Cost</th>
						<th>Quantity</th>
						<th>Operatations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="food" items="${foodList}">
						<tr>
							<td>${food.id}</td>
							<td>${food.name}</td>
							<td>${food.type}</td>
							<td>${food.description}</td>
							<td>$${food.cost}</td>
							<td>${food.quantity}</td>
							<td>
								<a href="operatations/edit-food?id=${food.id}" class="update-button">Update</a>
								<a href="#" onclick="confirmDelete(${food.id})" class="delete-button">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<a href="javascript:history.back()" class="back-button">Go Back</a>
	</div>
	<script>
		function confirmDelete(id) {
			if (confirm("Are you sure you want to delete this food item?")) {
				window.location.href = "operatations/delete-food?id=" + id;
			}
		}
	</script>
</body>
</html>