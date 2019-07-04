package model;

import java.util.Date;
import java.util.List;

import gateway.SolicitacaoGateway;

public class SolicitacaoMuseu {

	private Long id;
	private String nome;
	private String Cidade;
	private Date Criacao;
	private String Estado;
	private String nomeGestor;
	private String CPFGestor;
	private String senhaGestor;
	
	public SolicitacaoMuseu() {
	}
	public SolicitacaoMuseu(String nome, String Cidade, Date criacao, String estado,
			String nomeGestor, String cpfGestor, String senhaGestor) {
		this.nome = nome;
		this.Cidade = Cidade;
		this.Criacao = criacao;
		this.Estado = estado;
		this.nomeGestor = nomeGestor;
		this.CPFGestor = CPFGestor;
		this.senhaGestor = senhaGestor;
		
	}
	
	public Boolean criaSolicitacao() throws Exception {
		SolicitacaoGateway solicitacaoDB = new SolicitacaoGateway();
		if(getNome().isEmpty() || getCidade().isEmpty() || getEstado().isEmpty() ||
				getCPFGestor().isEmpty() || getCriacao() ==  null || getNomeGestor().isEmpty() ||
				getSenhaGestor().isEmpty()) {
			throw new Exception("Todos os campos devem ser preenchidos");
		}else {
			return solicitacaoDB.criaSolicitacao(this);
		}
	}

	public List<SolicitacaoMuseu> listSolicitacoes(){
		SolicitacaoGateway solicitacaoDB = new SolicitacaoGateway();
		return solicitacaoDB.listaSolicitacoes();
	}
	
	public SolicitacaoMuseu buscaSolicitacao(Long id) {
		SolicitacaoGateway solicitacaoDB = new SolicitacaoGateway();
		return solicitacaoDB.buscaSolicitacoes(id);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getNomeGestor() {
		return nomeGestor;
	}

	public void setNomeGestor(String nomeGestor) {
		this.nomeGestor = nomeGestor;
	}

	public String getCPFGestor() {
		return CPFGestor;
	}

	public void setCPFGestor(String cPFGestor) {
		CPFGestor = cPFGestor;
	}

	public String getSenhaGestor() {
		return senhaGestor;
	}

	public void setSenhaGestor(String senhaGestor) {
		this.senhaGestor = senhaGestor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCriacao() {
		return Criacao;
	}

	public void setCriacao(Date criacao) {
		Criacao = criacao;
	}
}