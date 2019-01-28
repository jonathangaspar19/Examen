<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.getAttribute("codPelicula");
		request.getAttribute("codActor");
	%>


	<form action="/fillPeliculaActor?codPelicula=${codPelicula}&codActor=${codActor}" method="post">
		<span>Cache:</span> <input type="text" name="cache"> <br /> <span>Rol:</span>
		<input type="text" name="role"> <br /> <input type="submit">
	</form>

</body>
</html>