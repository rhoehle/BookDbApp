<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book listing</title>
</head>
<body>

<h1>Book List</h1>
*Select entry - choose action button<br><br>

<form method = "post" action = "navigationServlet">
<table>
<tr>
	<th scope="col">*</th>
	<th scope="col" align="left">Title</th>
	<th scope="col" align="left">Author</th>
</tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
 <td><input type="radio" name="id" value="${currentitem.id}"></td>

 <td>${currentitem.title}</td>

 <td>${currentitem.author}</td>
 </tr>
</c:forEach>
</table><br>

<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">

</form>

</body>
</html>