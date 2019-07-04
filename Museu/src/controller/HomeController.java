package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("Cargo", "Visitante");
		request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request,response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		switch (acao) {
			case "CadastarUsuario":
				request.getSession().setAttribute("Tipo", "Visitante");
				request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);
				break;
			case "CadastrarSolicitacao":
				request.getRequestDispatcher("WEB-INF/SolicitarCriacao.jsp").forward(request,response);
				break;
			case "CadastarGestor":
				request.getSession().setAttribute("Tipo", "Gestor");
				request.getRequestDispatcher("WEB-INF/CriarUsuario.jsp").forward(request,response);
				break;
			case "CadastarMuseu":
				request.getRequestDispatcher("WEB-INF/CriarMuseu.jsp").forward(request,response);
				break;
			case "Mudar para Admin":
				request.getSession().setAttribute("Cargo", "Admin");
				request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request,response);
				break;
			case "Mudar para Visitante":
				request.getSession().setAttribute("Cargo", "Visitante");
				request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request,response);
				break;
			default:
				request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request,response);

		}
	
	}

}
