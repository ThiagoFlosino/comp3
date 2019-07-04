<p><b>Cargo:</b>: <%= request.getSession().getAttribute("Cargo")%></p>
<% if (request.getAttribute("message") != null){ %>
	<div>
		<strong><%=request.getAttribute("message") %></strong> 
	</div>
<% } %>
<form action="" method="post">
	<input type="submit" name="acao" value="Mudar para Admin">
	<input type="submit" name="acao" value="Mudar para Visitante">
</form>

<% if (request.getAttribute("erro") != null){ %>
	<div style="color:rgb(184,0,0)">
		<strong><%=request.getAttribute("erro") %></strong>
	</div>
<% } %>