package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SolicitacaoMuseu;

@WebServlet("/solicitarCriacao")
public class CriarSolicitacao extends  HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/SolicitarCriacao.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoCriar");
		if (acao != null){
			switch (acao) {
				case "Criar":
				try {
					criarSolicitacao(request,response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				default:
					request.getRequestDispatcher("WEB-INF/home.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("WEB-INF/SolicitarCriacao.jsp").forward(request,response);
		}
	}
	
	private void criarSolicitacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String nome = request.getParameter("nome");
		Date dataCriacao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataCriacao"));
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String nomeGestor = request.getParameter("nomeGestor");
		String cpfGestor = request.getParameter("cpfGestor");
		String senhaGestor = request.getParameter("senhaGestor");
		try {
				SolicitacaoMuseu solicitacao = new SolicitacaoMuseu(nome, cidade, dataCriacao, estado, nomeGestor, cpfGestor, senhaGestor);
				if(solicitacao.criaSolicitacao()) {
					request.setAttribute("message", "Solicitação criada com sucesso!");
				}
			request.getRequestDispatcher("WEB-INF/SolicitarCriacao.jsp").forward(request,response);	
		}catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("WEB-INF/SolicitarCriacao.jsp").forward(request,response);
		}
	}
}