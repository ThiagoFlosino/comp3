package gateway;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gestor;
import model.Museu;
import model.SolicitacaoMuseu;

public class SolicitacaoGateway {

		public List<SolicitacaoMuseu> listaSolicitacoes() {
			String sql = "SELECT ID, NOME, CIDADE, ESTADO,CRIACAO,"
					+ "NOME_GESTOR, CPF_GESTOR, SENHA_GESTOR"
					+ " FROM SOLICITACAO_MUSEU";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				ResultSet rs = psttm.executeQuery();
				List<SolicitacaoMuseu> retorno = new ArrayList<SolicitacaoMuseu>();
				while(rs.next()) {
					SolicitacaoMuseu item = new SolicitacaoMuseu();
					item.setId(rs.getLong("ID"));
					item.setNome(rs.getString("NOME"));
					item.setCidade(rs.getString("CIDADE"));
					item.setEstado(rs.getString("ESTADO"));
					item.setCriacao(rs.getDate("CRIACAO"));
					item.setNomeGestor(rs.getString("NOME_GESTOR"));
					item.setCPFGestor(rs.getString("CPF_GESTOR"));
					item.setSenhaGestor(rs.getString("SENHA_GESTOR"));
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
		
		public Boolean criaSolicitacao(SolicitacaoMuseu solicitacao) {
			String sql = "INSERT INTO SOLICITACAO_MUSEU"
					+ "(NOME, CIDADE, CRIACAO, ESTADO,"
					+ "NOME_GESTOR, CPF_GESTOR, SENHA_GESTOR) VALUES (?,?,?,?,?,?,?)";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				psttm.setString(1, solicitacao.getNome());
				psttm.setString(2, solicitacao.getCidade());
				psttm.setDate(3, (Date) solicitacao.getCriacao());
				psttm.setString(4, solicitacao.getEstado());
				psttm.setString(5, solicitacao.getNomeGestor());
				psttm.setString(6, solicitacao.getCPFGestor());
				psttm.setString(7, solicitacao.getSenhaGestor());
				Boolean retorno = psttm.execute();
				DBConnection.conexao.close();
				return retorno;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
		public SolicitacaoGateway() {
			DBConnection.criaConexao();
			try {
				Boolean retorno = DBConnection.conexao.createStatement().execute(""
						+ "CREATE TABLE IF NOT EXISTS SOLICITACAO_MUSEU ("
						+ " ID INT PRIMARY KEY AUTO_INCREMENT,"
						+ " NOME VARCHAR(255),"
						+ " CIDADE VARCHAR(255),"
						+ " CRIACAO DATE,"
						+ " ESTADO VARCHAR(255),"
						+ " NOME_GESTOR VARCHAR(255),"
						+ " CPF_GESTOR VARCHAR(255),"
						+ " SENHA_GESTOR VARCHAR(255)"
						+ ");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public SolicitacaoMuseu buscaSolicitacoes(Long id) {
			String sql = "SELECT ID, NOME, CIDADE, ESTADO,CRIACAO,"
					+ "NOME_GESTOR, CPF_GESTOR, SENHA_GESTOR"
					+ " FROM SOLICITACAO_MUSEU"
					+ " WHERE ID = ?";
			try {
				DBConnection.criaConexao();
				PreparedStatement psttm = DBConnection.conexao.prepareStatement(sql);
				ResultSet rs = psttm.executeQuery();
				SolicitacaoMuseu retorno = new SolicitacaoMuseu();
				if(rs.next()) {
					SolicitacaoMuseu item = new SolicitacaoMuseu();
					item.setId(rs.getLong("ID"));
					item.setNome(rs.getString("NOME"));
					item.setCidade(rs.getString("CIDADE"));
					item.setEstado(rs.getString("ESTADO"));
					item.setCriacao(rs.getDate("CRIACAO"));
					item.setNomeGestor(rs.getString("NOME_GESTOR"));
					item.setCPFGestor(rs.getString("CPF_GESTOR"));
					item.setSenhaGestor(rs.getString("SENHA_GESTOR"));
				}
				DBConnection.conexao.close();
				return retorno;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}

}
