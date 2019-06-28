import java.sql.Connection;
import java.sql.SQLException;

import gateway.DBConnection;
import model.Usuario;

public class SistemaMuseu {

	public static void main(String[] args) {
//		Usuario teste = new Usuario();
//		teste.setCpf("14636701763");
//		teste.setNome("thiago");
//		teste.setSenha("123456A");
//		teste.cadastraUsuario();
		
		Connection conn = new DBConnection().getConnection();
		try {
			System.out.println(conn.createStatement().execute("create SCHEMA museu"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
