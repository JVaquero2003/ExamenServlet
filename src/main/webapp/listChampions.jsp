<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<div class="container">
<table class="table table-striped">
<tr><td>Id</td><td>Nombre</td><td>Title</td><td>Lore</td><td>Tags</td></tr>
<c:forEach var="champion" items="${lista}" varStatus="indice">
	<tr style="border:1px solid black; padding:5pt">
		<td><c:out value="${champion.id}"/></td>
		<td><c:out value="${champion.champion_name}"/></td>
		<td><c:out value="${champion.title}"/></td>
		<td><c:out value="${champion.lore}"/></td>
		<td><c:out value="${champion.tags}"/></td>
		<td>
		<form action="/listChampion_abilities" method="post">
			<input type="hidden" name="id" value="${champion.id}"/>
			<input type="hidden" name="champion_name" value="${champion.champion_name}"/>
			<input type="hidden" name="title" value="${champion.title}"/>
			<input type="hidden" name="lore" value="${champion.lore}"/>
			<input type="hidden" name="tags" value="${champion.tags}"/>
			<input type="submit" value="Habilidades">
		</form>
		</td>
	</tr>
</c:forEach>
</table>
<br/>
<a type="button" class="btn btn-primary" href="index.jsp">Volver a Home</a>
</div>
</body>
</html>