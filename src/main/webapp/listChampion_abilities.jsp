<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br />
	<div class="container">
		<form method="post" action="/comparadorRangos">
			<span>Seleccionar habilidades entre una y otra</span><input
				type="number" name="rango_1" id="rango_1"><span> y </span><input
				type="number" name="rango_2" id="rango_2">&nbsp;<input
				type="submit" value="enviar">
		</form>
		<table class="table table-striped">
			<tr>
				<td>Id</td>
				<td>champion_name</td>
				<td>description</td>
				<td>effect</td>
				<td>cost</td>
				<td>rango</td>
			</tr>
			<c:forEach var="habilidad" items="${lista}" varStatus="indice">
				<tr style="border: 1px solid black; padding: 5pt">
					<td><c:out value="${habilidad.id}" /></td>
					<td><c:out value="${habilidad.champion_name}" /></td>
					<td><c:out value="${habilidad.champion_description}" /></td>
					<td><c:out value="${habilidad.effect}" /></td>
					<td><c:out value="${habilidad.cost}" /></td>
					<td><c:out value="${habilidad.rango}" /></td>
					<td>
				</tr>
				<!-- id,champion,champion_name,champion_description,effect,cost,rango -->
			</c:forEach>
		</table>
		<br /> <a type="button" class="btn btn-primary" href="index.jsp">Volver
			a Home</a>
	</div>
</body>
</html>