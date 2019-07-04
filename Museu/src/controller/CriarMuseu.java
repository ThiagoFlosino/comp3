package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Gestor;
import model.Museu;
import model.SolicitacaoMuseu;

@WebServlet("/CriarMuseu")
public class CriarMuseu extends  HttpServlet{
	SolicitacaoMuseu solicitacao = new SolicitacaoMuseu();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SolicitacaoMuseu> listaSolicitacoes = solicitacao.listSolicitacoes();
		request.setAttribute("solicitacoes", listaSolicitacoes);
		request.getRequestDispatcher("WEB-INF/CriarMuseu.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("Cargo").equals("Gestor")) {
			Long idSolicitacao = Long.parseLong(request.getParameter("idSolicitação"));
			SolicitacaoMuseu selecionada = solicitacao.buscaSolicitacao(idSolicitacao);
			Gestor gestor = new Gestor();
			gestor.setCpf(selecionada.getCPFGestor());
			gestor.setNome(selecionada.getNomeGestor());
			gestor.setSenha(selecionada.getSenhaGestor());
			Museu museu = new Museu();
			museu.setCidade(selecionada.getCidade());
			museu.setCriação(selecionada.getCriacao());
			museu.setEstado(selecionada.getEstado());
			museu.setNome(selecionada.getNome());
			try {
				gestor.cadastraUsuario();
				museu.setGestor(gestor);
				if(museu.cadastraMuseu()) {
					request.setAttribute("message", "Museu criado com sucesso!");
					request.getRequestDispatcher("WEB-INF/listarMuseu.jsp").forward(request,response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("message", "Somente um Gestor pode criar um Museu");
			request.getRequestDispatcher("WEB-INF/CriarMuseu.jsp").forward(request,response);
		}
	}
}
