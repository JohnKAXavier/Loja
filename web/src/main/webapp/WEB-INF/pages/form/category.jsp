<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Categoria</h1>
	
	<form action="categories" method="POST">
		
		<div>
			<label>Nome:</label>
			<input type="text" name="name" value="${resource.name}"/>
		</div>
		
		<div>
			<label>Descrição:</label>
			<textarea name="description">${resource.description}</textarea>
		</div>
		
		<input type="hidden" name="id" value="${resource.id}">
		
		<button>SALVAR</button>
	</form>
	
</body>
</html>