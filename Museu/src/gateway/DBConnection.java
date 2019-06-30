package gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String DRIVER = "org.h2.Driver";
	private static final String dbUrl = "jdbc:h2:~/museudb;";
	public static Connection conexao = null;
	public static void criaConexao() {
		try {
			System.out.println("Banco Iniciado");
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(dbUrl, "sa", "");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
