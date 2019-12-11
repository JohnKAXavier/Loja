<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Cadastro de produtos</h1>

	<br />

	<fieldset>
		<legend>Produtos</legend>

		<form action="cart" method="get">
			<p>
				<label for="nome">Nome</label> 
				<input type="text" name="nome" id="nome" size="120">
			</p>

			<p>
				<label for="preco">Preço</label> 
				<input type="text" name="preco" id="preco" size="120">
			</p>
			
			<input  type="submit" value="Gravar">

		</form>
		
		<c:forEach var="prod" items="${listaProduto}">
			<tr>
				<td>${prod.id}</td>
				<td>${prod.nome}</td>
				<td>${prod.preco}</td>
			</tr>		
		</c:forEach>

	</fieldset>


</body>
</html>