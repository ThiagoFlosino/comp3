package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet("/CriarUsuario")
public class CriaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoCriar");
		if (acao != null){
			switch (acao) {
				case "Criar":
					criarUsuario(request,response);
					break;
				default:
					request.getRequestDispatcher("CriarUsuario").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);
	}

	private void criarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		String cpf = (String) request.getParameter("cpf");
		String password = (String) request.getParameter("password");
		
		try {
			Usuario usuario = new Usuario(nome,cpf,password);
			if(usuario.cadastraUsuario()) {				
				request.setAttribute("message", "Usuario criado com sucesso!");
			}
			request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);	
		}catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);
		}		
	}

}
