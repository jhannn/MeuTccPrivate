package br.ifrn.meutcc.visao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.logica.TemasCandidatosLogic;
import br.ifrn.meutcc.logica.TemasLogic;
import br.ifrn.meutcc.modelo.Tema;
import br.ifrn.meutcc.modelo.TemaCandidato;

@WebServlet("/ViewTema/AddCandidato")
public class AddCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCandidato() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTemaText = request.getParameter("id");
		String idCandidatoText = request.getParameter("idCandidato");
		int idTema = -1;
		int idCandidato= -1;
		try {
			idTema = Integer.parseInt(idTemaText);
			idCandidato = Integer.parseInt(idCandidatoText);
		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
		}
		TemasCandidatosLogic logic = new TemasCandidatosLogic();
		boolean temacandidato = logic.addCandidato(idTema, idCandidato);
		Tema tema=new Tema();
		TemasLogic temalogic=new TemasLogic();
		tema=temalogic.getTema(idTema);
		request.setAttribute("addCandidato", temacandidato);
		request.setAttribute("tema", tema);
		request.getRequestDispatcher("viewTema.jsp").forward(request, response);
	}

}
