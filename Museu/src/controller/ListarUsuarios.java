package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.Visitante;

@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Visitante visitante = new Visitante();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoListar");
		if (acao != null){
			switch (acao) {
				case "Criar":
					request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);
				default:
					request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("WEB-INF/ListarUsuarios.jsp").forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = visitante.listaUsuarios();
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("WEB-INF/ListarUsuarios.jsp").forward(request,response);
	}

}