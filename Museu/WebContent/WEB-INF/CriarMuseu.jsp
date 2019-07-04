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

<form action="CriarMuseu" method="post">
	<table width="80%">
		  <thead>
		  	<tr>
			    <th>Nome Museu</th>
			    <th>Data de Criação</th>
			    <th>Cidade</th>
			    <th>Estado</th>
			    <th>Nome Gestor </th>
			    <th>CPF Gestor</th>
			    <th>Senha</th>
		    <tr>
		  </thead>
		  <tbody>
		    <%
			  try{
				  Collection<SolicitacaoMuseu> solicitacoesMuseus = (Collection<SolicitacaoMuseu>)request.getAttribute("solicitacoes");
				  for (SolicitacaoMuseu i: solicitacoesMuseus){
		  %>
			  <tr align="center">
			  	<td><input type="radio" name="idSolicitacao" value="<%= i.getId()%>"></td>
			    <td><%=i.getNome()%></td>
			    <td><%=i.getCriacao()%></td>
			    <td><%=i.getCidade()%></td>
			    <td><%=i.getEstado()%></td>
			    <td><%=i.getNomeGestor()%></td>
			    <td><%=i.getCPFGestor()%></td>
			    <td><%=i.getSenhaGestor()%></td>
			  </tr>
		   <%
				  }
			  }catch(Exception e){ }
		  %>
		  </tbody>
	</table>

	
	<input type="submit" name ="acaoListar" value = "Criar">
		<input type="submit" name ="acaoListar" value = "Atualizar">
		<input type="submit" name ="acaoListar" value = "Ver">
</form>
</body>
</html>