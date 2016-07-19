package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.OrientadorDAO;

public class Orientador {
	private int idOrientador;
	private String nomeOrientador;
	private OrientadorDAO dao;
	
	public Orientador() {
		super();
		dao = new OrientadorDAO();
	}
	public int getIdOrientador() {
		return idOrientador;
	}

	public void setIdOrientador(int idOrientador) {
		this.idOrientador = idOrientador;
	}

	public String getNomeOrientador() {
		return nomeOrientador;
	}

	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}

	public Orientador getOrientador(int idOrientador) {
		return dao.getOrientador(idOrientador);
	}
}
