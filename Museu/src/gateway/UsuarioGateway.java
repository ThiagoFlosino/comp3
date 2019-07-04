package gateway;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.Visitante;

public class UsuarioGateway {
	
	
	public Usuario findByName(String nome) {
		String sql = "SELECT NOME, CPF, SENHA FROM USUARIO where NOME = ?";
		Visitante usuario = null;
		try {
			new DBConnection().criaConexao();
			PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
			psttm.setString(1, nome);
			ResultSet rs = psttm.executeQuery();
			usuario = new Visitante(rs.getString("nome"), rs.getString("cpf"), rs.getString("senha"));
			DBConnection.conexao.close();
			return (Usuario) usuario;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean cpfExiste(String cpf) {
		String sql = "SELECT NOME, CPF, SENHA FROM USUARIO where CPF = ?";
		try {
			DBConnection.criaConexao();
			PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
			psttm.setString(1, cpf);
			ResultSet rs = psttm.executeQuery();
			Boolean retorno = rs.next();
			DBConnection.conexao.close();
			return retorno;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean criaUsuario(Usuario user) {
		String sql = "INSERT INTO USUARIO(NOME, CPF, SENHA, TIPO) VALUES (?,?,?,?)";
		try {
			DBConnection.criaConexao();
			PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
			psttm.setString(1, user.getNome());
			psttm.setString(2, user.getCpf());
			psttm.setString(3, user.getSenha());
			psttm.setString(4, user.getTipo());
			Boolean retorno = psttm.execute();
			DBConnection.conexao.close();
			return retorno;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public UsuarioGateway() {
		DBConnection.criaConexao();
		try {
			DBConnection.conexao.createStatement().execute(""
					+ "CREATE TABLE IF NOT EXISTS USUARIO"
					+ "(ID INT PRIMARY KEY AUTO_INCREMENT,"
					+ "NOME VARCHAR(255),"
					+ "CPF VARCHAR(255),"
					+ "SENHA VARCHAR(255),"
					+ "TIPO VARCHAR(255));");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Usuario> listaUsuarios() {
		String sql = "SELECT NOME, CPF, SENHA, TIPO FROM USUARIO";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			DBConnection.criaConexao();
			PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario(rs.getString("nome"), rs.getString("cpf"), rs.getString("senha"), rs.getString("tipo"));
				usuarios.add(usuario);
			}
			DBConnection.conexao.close();
			return usuarios;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
