<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	
<table border="1">
	<thead>
		<tr>
			<td>Cod</td>
			<td>Title</td>
			<td>Link Actor</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="film" items="${listAllFilms}">
			<tr>
				<td><c:out value="${film.cod}"/> </td>
				<td><c:out value="${film.title}"/> </td>
				<td><a href="/recoveryFilm?cod=${film.cod}">Link</a></td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>