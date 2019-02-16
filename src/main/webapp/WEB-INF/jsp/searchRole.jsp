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
	
	<form action="/filterRole" method="post">
	<span>Search by role: <input type="text" name="role"></span>
	<br />
	<input type="submit">
	</form>
	<br />
	<br />
	
	<table border="1">
		<thead>
			<tr>
				<td>Film</td>
				<td>Actor's Name</td>
				<td>Bithdate</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${selectFilmActor.title}" /></td>
					<td><c:out value="${selectFilmActor.name}" /></td>
					<td><c:out value="${selectFilmActor.year}" /></td>
				</tr>
		</tbody>
	</table>


</body>
</html>