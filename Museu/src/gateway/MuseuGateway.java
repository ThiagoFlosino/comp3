package gateway;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gestor;
import model.Museu;

public class MuseuGateway {

		public List<Museu> listaMuseus() {
			String sql = "SELECT M.CRIACAO AS CRIACAO_MUSEU,"
					+ "M.CIDADE AS CIDADE_MUSEU,"
					+ "M.ESTADO AS ESTADO_MUSEU,"
					+ "M.NOME AS NOME_MUSEU,"
					+ "U.NOME AS NOME_USUARIO,"
					+ "U.CPF,"
					+ "U.SENHA,"
					+ "U.TIPO"
					+ " FROM MUSEU M"
					+ " LEFT JOIN USUARIO U ON(U.ID = M.ID_GESTOR )";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				ResultSet rs = psttm.executeQuery();
				List<Museu> retorno = new ArrayList<Museu>();
				while(rs.next()) {
					Museu item = new Museu();
					item.setNome(rs.getString("NOME_MUSEU"));
					item.setCidade(rs.getString("CIDADE_MUSEU"));
					item.setEstado(rs.getString("ESTADO_MUSEU"));
					item.setCriação(rs.getDate("CRIACAO_MUSEU"));
					Gestor gestor = new Gestor();
					gestor.setNome(rs.getString("NOME_USUARIO"));
					gestor.setTipo(rs.getString("TIPO"));
					gestor.setSenha(rs.getString("SENHA"));
					item.setGestor(gestor);
					retorno.add(item);
				}
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
				Boolean retorno = DBConnection.conexao.createStatement().execute(""
						+ "CREATE TABLE IF NOT EXISTS MUSEU"
						+ "(ID INT PRIMARY KEY AUTO_INCREMENT,"
						+ "CRIACAO DATE,"
						+ "CIDADE VARCHAR(255),"
						+ "ESTADO VARCHAR(255),"
						+ "ID_GESTOR NUMBER,"
						+ "NOME VARCHAR(255)"
						+ ");");
				System.out.println("Criado Tabela Museu: " + retorno.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
