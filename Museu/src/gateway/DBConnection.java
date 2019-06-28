package gateway;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.derby.impl.drda.NetworkServerControlImpl;

public class DBConnection {

	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static String dbUrl = "jdbc:derby://localhost:1527/museudb;create=true;user=root;password=password";
	public static Connection getConnection() {
	        try {
	        	System.setProperty("derby.system.home", "db"); 
	        	// Crie uma pasta onde você quiser que fique o seu banco e set aqui
	        	//pode ser qualquer diretorio incluindo a pasta onde estara o executavel(.jar)
	        	NetworkServerControlImpl networkServer = new NetworkServerControlImpl();
	        	networkServer.start(new PrintWriter(System.out));
	        	System.out.println("Banco Iniciado");
	        	Class.forName(DRIVER).newInstance();
	            return DriverManager.getConnection(dbUrl);
	        } catch (SQLException | ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }

}
