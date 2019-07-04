package gateway;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class DBConnection{

	private static final String DRIVER = "org.h2.Driver";
//	private static final String dbUrl = "jdbc:h2:~/museudb;";
	static File f = new File("teste.txt");
	static String str = f.getAbsolutePath();
	private static final String dbUrl = "jdbc:h2:file:./db/museudb;";
	public static Connection conexao = null;
	public static void criaConexao() {
		try {
			System.out.println(str);
			System.out.println(dbUrl);
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
