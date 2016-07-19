package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.meutcc.modelo.Tema;

public class TemaCandidatoDAO {
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	
	public TemaCandidatoDAO() {
		super();
	}
	
	public boolean addCandidato(int idTema, int idCandidato) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				stListaTema.executeQuery("insert into temacandidato (idTema,idCandidato) values("+idTema+","+idCandidato+")");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	private void verificaConexao() {
		String 	url = "jdbc:mysql://localhost/meutcc",
				nome = "root",
				senha = "senha123";
		if (conn != null) {
			return;
		}
		try {
			Class.forName(MySQLDriver);
			conn = DriverManager.getConnection(url, nome, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}