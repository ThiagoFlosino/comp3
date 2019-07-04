package model;

import java.util.Date;
import java.util.List;

import gateway.MuseuGateway;
import gateway.UsuarioGateway;

public class Museu {

	private String nome;
	private Date cria��o;
	private String cidade;
	private String estado;
	private Gestor gestor;
	private String status;
	private List<Object> acervos;
	private List<Object> exposicoes;
	
	public Museu() {
	}
	
	
	public  Boolean cadastraMuseu() throws Exception {
		MuseuGateway museuDB = new MuseuGateway();
		if(getNome() == null || getCidade() == null || getEstado() == null|| getGestor() == null) {
			throw new Exception("Os campos Nome, Cidade e Estado s�o obrigat�rios");
		}else {
			this.setCria��o(new Date());
			return museuDB.criaMuseu(this);
		}
	}
	public List<Museu> listaMuseus(){
		MuseuGateway museuDB = new MuseuGateway();
		return museuDB.listaMuseus();
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getCria��o() {
		return cria��o;
	}

	public void setCria��o(Date cria��o) {
		this.cria��o = cria��o;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public List<Object> getAcervos() {
		return acervos;
	}

	public void setAcervos(List<Object> acervos) {
		this.acervos = acervos;
	}

	public List<Object> getExposicoes() {
		return exposicoes;
	}

	public void setExposicoes(List<Object> exposicoes) {
		this.exposicoes = exposicoes;
	}
	
	

}
