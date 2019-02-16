<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


	<form action="/actor" method="post">
		<span>name:</span><input type="text" name="name"><br />
		<span>year:</span><input type="text" name="year"><br />
		<input type="submit">
	</form>
	<br />

	<form action="/actor" method="get">
		<span>From:</span>
		<input type="text" name="beginDate">
		<span>To:</span>
		<input type="text" name="endDate">
		<input type="submit">
	</form>
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>Cod</td>
				<td>Title</td>
				<td>codDirector</td>
				<td>Delete</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor.cod}" /></td>
					<td><c:out value="${actor.name}" /></td>
					<td><c:out value="${actor.year}" /></td>
					<td><a href="/actor?cod=${actor.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>