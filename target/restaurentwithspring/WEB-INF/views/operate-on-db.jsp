<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Database Operations</title>
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
    background-color: #dc3545; /* A vibrant red color for operations */
    color: white;
    border-radius: 8px;
    font-size: 1em;
    font-weight: bold;
    transition: background-color 0.3s, transform 0.2s;
    border: none;
    cursor: pointer;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
.button.add {
    background-color: #007bff;
}
.button.add:hover {
    background-color: #0056b3;
}
.button.edit {
    background-color: #ffc107;
}
.button.edit:hover {
    background-color: #e0a800;
}
.button.delete {
    background-color: #dc3545;
}
.button.delete:hover {
    background-color: #c82333;
}
.button.back {
    background-color: #6c757d;
}
.button.back:hover {
    background-color: #5a6268;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Food Database Operations</h1>
		<div class="button-group">
			<a href="operatations/add" class="button add">Add food to restaurant Repository</a>
			<a href="operatations/updateForm" class="button edit">Edit an existing food info</a>
			<a href="operatations/deleteFoodForm" class="button delete">Delete an existing food item info</a>
            <a href="javascript:history.back()" class="button back">Go Back</a>
		</div>
	</div>

</body>
</html>