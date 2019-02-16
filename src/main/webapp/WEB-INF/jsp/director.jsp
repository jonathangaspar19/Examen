<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="/insertDirector" method="post">
		<span>name:</span> <input type="text" name="name"> <br /> <input
			type="submit">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Cod</td>
				<td>Title</td>
				<td>codDirector</td>
				<td>delete</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="director" items="${listAllDirectors}">
				<tr>
					<td><c:out value="${director.cod}" /></td>
					<td><c:out value="${director.name}" /></td>
					<td><a href="/deleteDirector?cod=${director.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>