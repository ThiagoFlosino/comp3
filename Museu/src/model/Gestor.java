package model;

import gateway.FuncionarioGateway;

public class Gestor extends Usuario {
	
	private String cargo = "Gestor";

	
	public Gestor(String nome, String cpf, String senha) {
		super(nome, cpf, senha, "Funcionario");
	}
	
	@Override
	public Boolean cadastraUsuario() throws Exception {
		super.cadastraUsuario();
		FuncionarioGateway userDB = new FuncionarioGateway();
		Long id = userDB.findIDByCPF(this.cpf);
		return userDB.criaRelacaoFuncioario(id, this.cargo);
	}

	public Gestor() {
		// TODO Auto-generated constructor stub
	}

	private void SolicitaCriacaoDeMuseu() {
		
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
