package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Director;
import es.salesianos.model.assembler.DirectorAssembler;
import es.salesianos.service.DirectorService;

public class DirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DirectorService service = new DirectorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Director director = DirectorAssembler.assembleDirectorFrom(req);
		service.insert(director);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cod = req.getParameter("cod");
		if (null != cod) {
			service.delete(cod);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Director> listAllDirectors = service.selectAllDirector();
		req.setAttribute("listAllDirectors", listAllDirectors);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/director.jsp");
		dispatcher.forward(req, resp);
	}
}