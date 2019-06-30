<%@ page import="java.util.Collection" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Usuario</title>
</head>
<%@include file="messagePage.jsp" %>

<body>
	<form action="CriarCurso" method="post">
	Nome : <input type="text" name ="nome" value = "">
	CPF : <input type="text" name ="cpf" value = "">
	Senha : <input type="password" name ="senha" value=""/>
	<br>
	<input type="submit" name="acaoCriar" value="Criar">
	<input type="submit" name="acaoCriar" value="Cancelar">
	</form>
</body>

</html>