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

	public  Boolean cadastraUsuario() {
		UsuarioGateway userDB = new UsuarioGateway();
		if(getNome().isEmpty() || getCpf().isEmpty() || getSenha().isEmpty()) {
			return false;
		}else if(userDB.cpfExiste(this.cpf)) {
			return false;
		}else if(!verificaSenha()) {
			return false;
		}else {
			return userDB.criaUsuario(this);
		}
	}
	
	
	private Boolean verificaSenha() {
		return this.senha.matches("[a-zA-Z0-9]+");
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
