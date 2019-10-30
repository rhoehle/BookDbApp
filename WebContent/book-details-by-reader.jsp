<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>
</head>
<body>
<body>
	<form method = "post" action = "bookDetailsNavigationServlet">
		<table>
		<c:forEach items= "${requestScope.allBookDetails}" var = "currentBookDetail">
		<tr>
 				<td><input type="radio" name="id" value="${currentBookDetail.id}"></td> 
				<td><h2>${currentBookDetail.rating}</h2></td></tr>
				<tr><td colspan="3">Date Read: ${currentBookDetail.dateRead}</td></tr>
				<tr><td colspan="3">Reader: ${currentBookDetail.reader.readerName}</td></tr>
				
				<c:forEach var="listVal" items="${requestScope.allBooks}">
						<tr><td></td><td colspan="3">
						${listVal.title}, ${listVal.author}
						</td>
						</tr>
				</c:forEach>
				
		</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> 
		<input type="submit" value="delete" name="doThisToItem"> 
		<input type="submit" value="add" name="doThisToItem">
	</form>
	<a href="AddReaderServlet">Create a Reader</a>
	<a href="index.html">Insert a new book</a>
</body>

</body>
</html>