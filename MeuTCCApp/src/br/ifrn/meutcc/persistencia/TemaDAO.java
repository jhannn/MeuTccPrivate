package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.meutcc.modelo.Tema;

public class TemaDAO {
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	
	public TemaDAO() {
		super();
	}
	
	public List<Tema> listTemas(int idCurso) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.idCurso = "+idCurso);
				List<Tema> temas = new ArrayList<Tema>();
				while (rsTemas.next()) {
					Tema tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					temas.add(tema);
				}
				return temas;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public Tema getTema(int idTema) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.id = "+idTema);
				Tema tema = null;
				if (rsTemas.next()) {
					tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					tema.setQtdCandidato(this.qtdCandidatos(tema.getId()));
					tema.setIdOrientador(rsTemas.getInt("idOrientador"));
				}
				return tema;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int qtdCandidatos(int idTema) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT COUNT(*) as qtd FROM temacandidato as t WHERE t.idTema = "+idTema);
				int tema = 0;
				if (rsTemas.next()) {
					tema=rsTemas.getInt("qtd");		
				}
				return tema;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
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