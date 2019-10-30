<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book listing</title>
</head>
<body>
	<h1>Book List</h1>
	*Select entry - choose action button
	<br>
	<br>

	<form method="post" action="NavigationServlet">
		<table>
			<tr>
				<th scope="col">*</th>
				<th scope="col" align="left">Title</th>
				<th scope="col" align="left">Author</th>
			</tr>
			<c:forEach items="${requestScope.allBooks}" var="currentBook">
				<tr>
					<td><input type="radio" name="id" value="${currentBook.id}"></td>
					<td>${currentBook.title}</td>
					<td>${currentBook.author}</td>
				</tr>
			</c:forEach>
		</table>
		<br> 
		<input type="submit" value="edit" name="doThisToBook">
		<input type="submit" value="delete" name="doThisToBook"> 
		<input type="submit" value="add" name="doThisToBook">

	</form>

</body>
</html>