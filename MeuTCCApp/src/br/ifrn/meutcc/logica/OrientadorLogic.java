package br.ifrn.meutcc.logica;

import java.util.List;

import br.ifrn.meutcc.modelo.Orientador;

public class OrientadorLogic {
	private Orientador orientador;
	
	public OrientadorLogic() {
		orientador = new Orientador();
	}
	
	public Orientador getTema(int idOrientador) {
		return orientador.getOrientador(idOrientador);
	}
}
