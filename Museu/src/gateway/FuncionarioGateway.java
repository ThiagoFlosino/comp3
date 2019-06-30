package gateway;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioGateway {

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
		
		public Boolean criaRelacaoFuncioario(Long idUsuario,String cargo) {
			String sql = "INSERT INTO USUARIO_CARGO(ID_USUARIO, CARGO) VALUES (?,?)";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				psttm.setLong(1, idUsuario);
				psttm.setString(2, cargo);
				Boolean retorno = psttm.execute();
				DBConnection.conexao.close();
				return retorno;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
		public FuncionarioGateway() {
			DBConnection.criaConexao();
			try {
				DBConnection.conexao.createStatement().execute(""
						+ "CREATE TABLE IF NOT EXISTS USUARIO_CARGO"
						+ "(ID INT PRIMARY KEY AUTO_INCREMENT,"
						+ "ID_USUARIO NUMBER,"
						+ "CARGO VARCHAR(255));");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}
