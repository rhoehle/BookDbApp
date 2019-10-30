<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Readers and Critics</title>
</head>
<body>
	<form action="NavigationServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allReaders}" var="currentReader">
				<tr>
					<td><input type="radio" name="readerId"
						value="${currentReader.readerId}"></td>
					<td>${currentReader.readerName}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToReader"> <input
			type="submit" value="delete" name="doThisToReader"> <input
			type="submit" value="add" name="doThisToReader">
	</form>
</body>
</html>