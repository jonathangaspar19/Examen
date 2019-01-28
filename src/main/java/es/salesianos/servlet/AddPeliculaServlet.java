package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.ExamAssembler;
import es.salesianos.service.FilmService;

/**
 * Servlet implementation class addOwnerServlet
 */
public class AddPeliculaServlet extends HttpServlet {
private FilmService service = new FilmService();
	private ExamAssembler assembler = new ExamAssembler();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film film = assembler.assembleFilmFromRequest(req);
		service.addFilm(film);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addPelicula.jsp");
		dispatcher.forward(req,resp);
	}
}
