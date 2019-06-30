package model;

import gateway.UsuarioGateway;

public class Usuario {
	
	String nome;
	String cpf;
	String senha;
	
	public Usuario(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public  Boolean cadastraUsuario() throws Exception {
		UsuarioGateway userDB = new UsuarioGateway();
		if(getNome().isEmpty() || getCpf().isEmpty() || getSenha().isEmpty()) {
			throw new Exception("Os campos Nome, CPF e Senha s�o obrigat�rios");
		}else if(userDB.cpfExiste(this.cpf)) {
			throw new Exception("O CPF j� existe na base");
		}else if(!verificaSenha()) {
			throw new Exception("A Senha precisa ser Alfa-Num�rica");
		}else {
			return userDB.criaUsuario(this);
		}
	}
	
	
	private Boolean verificaSenha() {
		return this.senha.matches("^[a-zA-Z0-9]*");
	}
	
	
	/* GETTERS E SETTERS */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
