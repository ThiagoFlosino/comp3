<%@ page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<%@include file="messagePage.jsp"%>
<p><strong>Cadastar</strong> 
<% if (request.getAttribute("Tipo") != null){ %>
		<strong><%=request.getAttribute("Tipo") %></strong> 
<% }else{ %>
	<strong>Usuario</strong>
<% } %>
</p>

<body>
	<form action="criarUsuario" method="post">
		<br>
		Nome : <input type="text" name="nome" value=""> <br>
		CPF : <input type="text" name="cpf" value=""> <br>
		Senha : <input type="password" name="password" value=""> <br>
		<input type="submit" name="acaoCriar" value="Criar">
		<input type="submit" name="acaoCriar" value="Cancelar">
	</form>
</body>

</html>