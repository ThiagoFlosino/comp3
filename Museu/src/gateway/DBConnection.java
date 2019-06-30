package gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

//	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static final String DRIVER = "org.h2.Driver";
//	private static String dbUrl = "jdbc:derby://localhost:1527/museudb;";
	private static String dbUrl = "jdbc:h2:file:./museudb;";
	public static Connection getConnection() {
	        try {
//	        	System.setProperty("derby.system.home", "db"); 
//	        	// Crie uma pasta onde você quiser que fique o seu banco e set aqui
//	        	//pode ser qualquer diretorio incluindo a pasta onde estara o executavel(.jar)
//	        	NetworkServerControlImpl networkServer = new NetworkServerControlImpl();
//	        	networkServer.start(new PrintWriter(System.out));
//	        	System.out.println("Banco Iniciado");
	        	Class.forName(DRIVER);
	            return DriverManager.getConnection(dbUrl, "sa", "");
	        } catch (SQLException | ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }

}
