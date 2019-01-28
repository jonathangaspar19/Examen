<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nueva Pelicula</title>
</head>
<body>
<form action="cargarListadoPeliculas" method="post">
		<input type="submit" value="ver listado">
</form>

	<%
		List<Film> peliculas = (List<Film>) request.getAttribute("listAllFilms");
		pageContext.setAttribute("peliculas", peliculas);

		
	%>

	<form action="AddPelicula" method="post">
		<span>Titulo:</span><input type="text" name="TITTLE">
		<span>Codigo director</span><input type="number" name="CODOWNER">
		<input type="submit">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>TITLE</td>
				<td>CODOWNER</td>
				<td>Borrar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pelicula1" items="${listAllFilms}">
				<tr>
					<td><c:out value="${pelicula1.TITTLE}" /></td>
					<td><c:out value="${pelicula1.CODOWNER}" /></td>
					<td><a href="/deletePelicula?codPelicula=${pelicula1.COD}">DELETE</a>
					</td>
				</tr>
			</c:forEach>
				
		</tbody>
	</table>
</body>
</html>