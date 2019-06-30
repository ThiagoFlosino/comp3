import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import gateway.DBConnection;
import model.Usuario;

public class SistemaMuseu {

	public static void main(String[] args) throws SQLException {
		
//		Connection conn = new DBConnection().getConnection();
//		try {
//			conn.createStatement().execute(""
//					+ "CREATE TABLE IF NOT EXISTS USUARIO"
//					+ "(ID INT PRIMARY KEY AUTO_INCREMENT,"
//					+ "NOME VARCHAR(255),"
//					+ "CPF VARCHAR(255),"
//					+ "SENHA VARCHAR(255));");
//			Usuario user = new Usuario();
//			user.setNome("Teste exception");
//			user.setCpf("1231231241412");
//			user.setSenha("123456");
//			user.cadastraUsuario();
//			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM USUARIO;");
//			while(rs.next()) {
//				System.out.println("ID: " + rs.getLong("ID")
//				+"\nNome: "+rs.getString("NOME")
//				+"\nCPF: " + rs.getString("CPF")
//				+"\nSenha: " + rs.getString("SENHA"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}finally {
//			conn.close();
//		}
	}
}
