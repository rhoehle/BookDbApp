<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new book detail</title>
</head>
<body>
	<h1>Add Details to Books</h1>

	<form action="CreateNewBookDetailServlet" method="post">
		Book Rating: <input type="text" name="rating"><br />
		Date Read: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4"> 
			Reader Name: <input type="text" name="readerName"><br /> 
			Attach Details to books:<br /> <select name="allDetailsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allBookDetails}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.title}|
					${currentitem.author}</option>
			</c:forEach>
		</select> <br /> <input type="submit"
			value="Create Book Details">
	</form>
	<a href="index.html">Go add new books instead.</a>
</body>
</html>