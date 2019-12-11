<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Produto</h1>
	
	<form action="products" method="POST">
		
		<div>
			<label>Nome:</label>
			<input type="text" name="name" value="${product.name}"/>
		</div>
		
		<div>
			<label> Categoria </label>
			<select name="category">
				<c:forEach var="category" items="${categories}">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select> 
		</div>
		
		<div>
			<label>Descrição:</label>
			<textarea name="description">${product.description}</textarea>
		</div>
		
		<div>
			<label>Preço:</label>
			<input type="number" name="price" value="${product.price}"/>
		</div>
		
		<input type="hidden" name="id" value="${product.id}">
		
		<button>SALVAR</button>
	</form>
	
</body>
</html>