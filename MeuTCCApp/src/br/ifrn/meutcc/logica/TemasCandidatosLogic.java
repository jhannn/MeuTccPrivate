package br.ifrn.meutcc.logica;

import java.util.List;

import br.ifrn.meutcc.modelo.TemaCandidato;

public class TemasCandidatosLogic {
	private TemaCandidato temacandidato;
	
	public TemasCandidatosLogic() {
		temacandidato = new TemaCandidato();
	}

	public boolean addCandidato(int idTema, int idCandidato) {
		return temacandidato.addCandidato(idTema, idCandidato);
	}

}
