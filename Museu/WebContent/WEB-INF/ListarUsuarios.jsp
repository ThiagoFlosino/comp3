<%@ page import="java.util.Collection" %>
<%@ page import="model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando Usuario</title>
</head>

<body>

<%@include file="messagePage.jsp" %>

	<form action="ListarUsuarios" method="get">
		<table width="80%">
		  <tr>
		    <th>Nome</th>
		    <th>CPF</th>
		    <th>Senha</th>
		  </tr>
		  
		  <%
			  try{
				  Collection<Usuario> usuarios = (Collection<Usuario>)request.getAttribute("usuarios");
				  for (Usuario i: usuarios){
		  %>
			  <tr align="center">
			    <td><%=i.getNome()%></td>
			    <td><%=i.getCpf()%></td>
			    <td><%=i.getSenha()%></td>
			  </tr>
		  <%
				  }
			  }catch(Exception e){ }
		  %>
		</table>

	 	<input type="submit" name ="acaoListar" value = "Criar">
<!-- 		<input type="submit" name ="acaoListar" value = "Atualizar">
		<input type="submit" name ="acaoListar" value = "Ver"> -->
		<!-- <input type="submit" name ="acaoListar" value = "Remover"> -->
	</form>
</body>

</html>