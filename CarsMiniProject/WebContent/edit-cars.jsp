<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Cars</title>
</head>
<body>
	<form action="editCarsServlet" method="post">
	Car Name: <input type="text" name="name" value="${itemToEdit.name }">
	Color of Car: <input type="text" name="color" value="${itemToEdit.color }">
	<input type="hidden" name="id" value="${itemToEdit.id }">
	<input type="submit" value="Save Edited Item">
	</form>
	<br />
	<a href="index.html">HomePage</a>
</body>
</html>