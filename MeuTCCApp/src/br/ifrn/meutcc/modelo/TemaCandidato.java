package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.TemaCandidatoDAO;

public class TemaCandidato {
	private int id;
	private int idTema;
	private int idCandidato;
	private TemaCandidatoDAO dao;
	
	public TemaCandidato() {
		super();
		dao = new TemaCandidatoDAO();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	public boolean addCandidato(int idCurso, int idCandidato) {
		return dao.addCandidato(idCurso, idCurso);
	}
}
