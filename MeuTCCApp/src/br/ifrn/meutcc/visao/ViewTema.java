package br.ifrn.meutcc.visao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.logica.TemasLogic;
import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/ViewTema")
public class ViewTema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewTema() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperar o id do tema
		String id = request.getParameter("id");
		int idTema = -1;
		try {
			idTema = Integer.parseInt(id);
		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
		}
		TemasLogic logic = new TemasLogic();
		Tema tema = logic.getTema(idTema);
		request.setAttribute("tema", tema);
		request.getRequestDispatcher("viewTema.jsp").forward(request, response);
	}

}
