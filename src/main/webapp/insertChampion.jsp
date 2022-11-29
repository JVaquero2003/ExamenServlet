<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Campeones</title>
</head>
<body>
<h1>Insertar Champions</h1>
	<form action="/insertChampion" method="get">
		<span>Champion Name</span>	<input type="text" id="champion_name" name="champion_name" /> 
		<span>Title</span>	<input type="text" id="title" name="title" />
		<span>Lore</span>	<input type="text" id="lore" name="lore" />
		<span>Tags</span>	<input type="text" id="tags" name="tags" />
		<input type="submit" value="enviar" />
	</form>
</body>
</html>