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
	
	<h1>Produtos</h1>
	
	<table>

		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Categoria</th>
				<th>Preço</th>
				<th>Ações</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="product" items="${resources}">

				<tr>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.category.name}</td>
					<td>${product.price}</td>
					<td>
						<c:if test="${!productsInCart.contains(product.id)}">
							<form method="POST" action="shopping-cart?productId=${product.id}&action=add"> 
								<button>Comprar</button>
							</form>
						</c:if>
						
						<c:if test="${productsInCart.contains(product.id)}">
							<form method="POST" action="shopping-cart?productId=${product.id}&action=remove"> 
								<button>Remover</button>
							</form>
						</c:if>
					</td>
				</tr>

			</c:forEach>

		</tbody>

	</table>
	
	<a href="<c:url value="/shopping-cart"/>">Finalizar compra</a>

</body>
</html>