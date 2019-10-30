<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reader/Critic creation</title>
</head>
<body>
	<form action="AddReaderServlet" method="post">
		<h3>Add a Reader/Reviewer</h3>
		Reader Name: <input type="text" name="readerName"><br>
		Date Read: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4"><br>
			
		List of Readers: <br> <br>
		<table>
			<c:forEach items="${requestScope.allReaders}" var="currentReader">
				<tr>
					<td><input type="radio" name="readerId"
						value="${currentReader.readerId}"></td>
					<td>${currentReader.readerName}</td>
				</tr>
			</c:forEach>
		</table>

		<br> <input type="submit" value="Add Reader"> <br> <br>

	</form>
	<a href="/BookDbWebApp2/index.html">Add new books instead</a>
</body>
</html>