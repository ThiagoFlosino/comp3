<%@ page import="java.util.Collection" %>
<%@ page import="model.Museu" %>
<%@ page import="model.Gestor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="messagePage.jsp" %>

	<form action="ListarMuseu" method="get">
		<table width="80%">
		  <tr>
		    <th>Nome</th>
		    <th>Criacao</th>
		    <th>Estado</th>
		    <th>Gestor</th>
		  </tr>
		  
		  <%
			  try{
				  Collection<Museu> museus = (Collection<Museu>)request.getAttribute("museus");
				  for (Museu i: museus){
		  %>

			  <tr align="center">
			    <td><%=i.getNome()%></td>
			    <td><%=i.getCriação()%></td>
			    <td><%=i.getEstado()%></td>
			    <td><%=i.getGestor().getNome()%></td>
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