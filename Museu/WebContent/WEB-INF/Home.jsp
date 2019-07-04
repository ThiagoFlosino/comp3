<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Museu" %>
<%@ page import="model.Gestor" %>
<%@ page import="model.SolicitacaoMuseu" %>
<%@ page import="java.util.Collection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cria Museu</title>
</head>
<body>

<%@include file="messagePage.jsp" %>

<form action="" method="post">
	<input type="submit" name ="acao" value = "CadastarUsuario">
	<input type="submit" name ="acao" value = "CadastrarSolicitacao">
	<input type="submit" name ="acao" value = "CadastarGestor">
	<input type="submit" name ="acao" value = "CadastarMuseu">
</form>
</body>
</html>