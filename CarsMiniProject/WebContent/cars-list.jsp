<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars List</title>
</head>
<body>
	<h1>List Of Cars</h1>
	<form method = "post" action="carNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allItems}" var="currentitem">
	<tr>
		<td><input type = "radio" name="id" value="${currentitem.id}"></td>
		<td>${currentitem.name}</td>
		<td>${currentitem.color}</td>
	</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToItem">
	<input type="submit" value="delete" name="doThisToItem">
	<input type="submit" value="add" name="doThisToItem">
	</form>
	<br />
	<a href="index.html">HomePage</a>
</body>
</html>