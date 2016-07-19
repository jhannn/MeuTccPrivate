package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.TemaDAO;

public class Tema {
	private int id;
	private String titulo;
	private String descricao;
	private int qtdCandidato;
	private int idOrientador;
	private TemaDAO dao;
	public Tema() {
		super();
		dao = new TemaDAO();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	public int getQtdCandidato() {
		return qtdCandidato;
	}
	public void setQtdCandidato(int qtdCandidato) {
		this.qtdCandidato = qtdCandidato;
	}
	public List<Tema> listTemas(int idCurso) {
		return dao.listTemas(idCurso);
	}
	public Tema getTema(int idTema) {
		return dao.getTema(idTema);
	}
	public int getIdOrientador() {
		return idOrientador;
	}
	public void setIdOrientador(int idOrientador) {
		this.idOrientador = idOrientador;
	}
}
