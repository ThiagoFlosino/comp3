package gateway;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Museu;

public class MuseuGateway {

		public Long findIDByCPF(String cpf) {
			String sql = "SELECT ID FROM USUARIO where CPF = ?";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				psttm.setString(1, cpf);
				ResultSet rs = psttm.executeQuery();
				Long retorno = rs.getLong("ID");
				DBConnection.conexao.close();
				return retorno;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
		
		public Boolean criaMuseu(Museu museu) {
			String sql = "INSERT INTO MUSEU(CRIACAO, CIDADE, ID_GESTOR, ESTADO, NOME) VALUES (?,?,?,?,?)";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				psttm.setDate(1, (Date) museu.getCriação());
				psttm.setString(2, museu.getCidade());
				psttm.setLong(3, museu.getGestor().getId());
				psttm.setString(4, museu.getEstado());
				psttm.setString(5, museu.getNome());
				Boolean retorno = psttm.execute();
				DBConnection.conexao.close();
				return retorno;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
		public MuseuGateway() {
			DBConnection.criaConexao();
			try {
				DBConnection.conexao.createStatement().execute(""
						+ "CREATE TABLE IF NOT EXISTS MUSEU"
						+ "(ID INT PRIMARY KEY AUTO_INCREMENT,"
						+ "CRIACAO DATE,"
						+ "CIDADE VARCHAR(255),"
						+ "ESTADO VARCHAR(255),"
						+ "ID_GESTOR NUMBER,"
						+ "NOME VARCHAR(255)"
						+ ");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
