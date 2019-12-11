<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Categorias</h1>
	
	<table>

		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="category" items="${resources}">

				<tr>
					<td>${category.name}</td>
					<td>${category.description}</td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

</body>
</html>