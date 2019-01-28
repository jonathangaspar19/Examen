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
<form action="cargarListadoDirectores" method="post">
		<input type="submit" value="ver listado">
</form>

	<%
		List<Director> directors = (List<Director>) request.getAttribute("listAllDirectors");
		pageContext.setAttribute("directors", directors);

		
	%>

	<form action="AddDirector" method="post">
		<span>Nombre director</span><input type="text" name="NAME">
		<input type="submit">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>NOMBRE DIRECTOR</td>
				<td>Borrar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="director1" items="${listAllDirectors}">
				<tr>
					<td><c:out value="${director1.name}" /></td>
					<td><a href="/deleteDirector?codDirector=${director1.cod}">DELETE</a>
					</td>
				</tr>
			</c:forEach>
				
		</tbody>
	</table>
</body>
</html>