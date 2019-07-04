package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Museu;
import model.Usuario;
import model.Visitante;

@WebServlet("/listarMuseu")
public class ListarMuseu extends HttpServlet {
	Museu museus = new Museu();
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoListar");
		if (acao != null){
			switch (acao) {
				case "criar":
					request.getRequestDispatcher("WEB-INF/CriarMuseu.jsp").forward(request,response);
					break;					
			}
		}else{
			request.getRequestDispatcher("WEB-INF/ListarMuseu.jsp").forward(request,response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Museu> listaMuseus = museus.listaMuseus();
		request.setAttribute("museus", listaMuseus);
		request.getRequestDispatcher("WEB-INF/ListarMuseu.jsp").forward(request,response);
	
	}
}


