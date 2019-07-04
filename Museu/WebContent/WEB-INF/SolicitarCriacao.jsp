<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="solicitarCriacao" method="post">
		Nome : <input type="text" name ="nome" value = "">
		Data de Criacao : <input type="date" name ="dataCriacao" value = "">
		Cidade : <input type="text" name ="cidade" value = "">
		Estado : <input type="text" name ="estado" value=""/>	<br>
		Nome Gestor : <input type="text" name ="nomeGestor" value = "">
		CPF Gestor  : <input type="text" name ="cpfGestor" value = "">
		Senha Gestor  : <input type="text" name ="senhaGestor" value = "">
	<br>
	<input type="submit" name="acaoCriar" value="Criar">
	<input type="submit" name="acaoCriar" value="Cancelar">
	</form>

</body>
</html>