<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo Actor</title>
</head>
<body>
<form action="cargarListadoActores" method="post">
		<input type="submit" value="ver listado">
</form>

	<%
		List<Actor> actors = (List<Actor>) request.getAttribute("listAllActors");
		pageContext.setAttribute("actors", actors);

		
	%>

	<form action="AddActor" method="post">
		<span>Nombre:</span><input type="text" name="NAME">
		<span>Fecha Nacimiento</span><input type="number" name="YEAROFBIRTHDAY">
		<input type="submit">
	</form>
	<form action="AddActor" method="post">
		<span>De:</span>
		<input type="text" name="beginDate">
		<span>Hasta:</span>
		<input type="text" name="endDate">
		<input type="submit">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>AÑO</td>
				<td>Borrar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor1" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor1.name}" /></td>
					<td><c:out value="${actor1.yearofbirthday}" /></td>
					<td><a href="/deleteActor?codActor=${actor1.cod}">DELETE</a>
					</td>
				</tr>
			</c:forEach>
				
		</tbody>
	</table>
</body>
</html>