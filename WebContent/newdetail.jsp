<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a book detail</title>
</head>
<body>
	<form action = "createNewListServlet" method="post">
	Rating: <input type ="text" name = "rating"><br />
	Date Read: <input type ="text" name = "month" placeholder="mm" size="4"> 
	<input type ="text" name = "day" placeholder="dd" size="4">, 
	<input type ="text" name = "year" placeholder="yyyy" size="4">
	Reader Name: <input type = "text" name = "shopperName"><br />
	Available Books:<br />
	<select name="allBooksToAdd" multiple size="6">
		<c:forEach items="${requestScope.allBooks}" var="currentitem">
		 <option value = "${currentitem.id}">${currentitem.title} |
		${currentitem.author}</option>
		</c:forEach>
	</select>
	<br />
	<input type = "submit" value="Create Rating and Date Read">
	</form>
<a href = "index.html">Go add new books instead.</a>
</body>
</html>