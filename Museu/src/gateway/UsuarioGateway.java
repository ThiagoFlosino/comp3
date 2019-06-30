package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioGateway {
	
	Connection conn = new DBConnection().getConnection();
	PreparedStatement psttm = null;
	
	public Usuario findByName(String nome) {
		String sql = "SELECT nome, cpf, senha FROM public.usuario where nome = ?";
		Usuario usuario = null;
		try {
			psttm = conn.prepareStatement(sql);
			psttm.setString(1, nome);
			ResultSet rs = psttm.executeQuery();
			usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setSenha(rs.getString("senha"));
			return usuario;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean cpfExiste(String cpf) {
		String sql = "SELECT nome, cpf, senha FROM usuario where cpf = ?";
		try {
			psttm = conn.prepareStatement(sql);
			psttm.setString(1, cpf);
			ResultSet rs = psttm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean criaUsuario(Usuario user) {
		String sql = "INSERT INTO USUARIO(NOME, CPF, SENHA) VALUES (?,?,?)";
		try {
			psttm = conn.prepareStatement(sql);
			psttm.setString(1, user.getNome());
			psttm.setString(2, user.getCpf());
			psttm.setString(3, user.getSenha());
			Boolean retorno = psttm.execute();
			return retorno;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
