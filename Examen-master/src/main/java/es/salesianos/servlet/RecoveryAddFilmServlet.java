package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.service.ActorService;
import es.salesianos.service.FilmService;

public class RecoveryAddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActorService actorService = new ActorService();
	private FilmService filmService = new FilmService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film film = FilmAssembler.assembleFilmFrom(req);
		filmService.insert(film);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codFilm = req.getParameter("codFilm");
		req.setAttribute("codFilm", codFilm);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Actor> listAllActors = actorService.selectAllActor();
		req.setAttribute("listAllActors", listAllActors);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/selectActor.jsp");
		dispatcher.forward(req, resp);
	}
}