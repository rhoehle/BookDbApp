<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit book</title>
</head>

<body>
	<h1>Edit book</h1>
	<br>

	<form action="editItemServlet" method="post">
		Title: <input type="text" name="title" value="${itemToEdit.title}">

		Author: <input type="text" name="author" value="${itemToEdit.author}">

		<input type="hidden" name="id" value="${itemToEdit.id}"> 
		<input type="submit" value="Save Edited Book">
		
	</form>

</body>

</html>