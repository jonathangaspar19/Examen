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

	<%
		request.getAttribute("codFilm");
		request.getAttribute("codActor");
	%>


	<form action="/fillFilmActor?codFilm=${codFilm}&codActor=${codActor}" method="post">
		<span>Cache:</span> <input type="text" name="cache"> <br /> <span>Role:</span>
		<input type="text" name="role"> <br /> <input type="submit">
	</form>

</body>
</html>