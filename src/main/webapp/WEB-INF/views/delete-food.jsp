<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food List</title>
<style>
/* ... (Your existing styling is fine) ... */
.delete-button {
	background-color: #dc3545;
	color: white;
	padding: 6px 12px;
	border-radius: 4px;
	text-decoration: none;
	font-weight: bold;
	transition: background-color 0.3s;
}

.delete-button:hover {
	background-color: #c82333;
}
</style>
<script>
    function confirmDelete(id) {
        if (confirm("Are you sure you want to delete this food item?")) {
            window.location.href = "operatations/deleteFood?id=" + id;
        }
    }
</script>
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
</body>
</html>