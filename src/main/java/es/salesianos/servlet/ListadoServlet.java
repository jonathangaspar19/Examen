package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.ActorService;
import es.salesianos.service.FilmActorService;
import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.repository.Repository;

public class ListadoServlet extends HttpServlet {
	
	private ActorService servicio = new  ActorService();
	private Repository repository = new  Repository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Actor> listAllActors = servicio.listAllActors();
		///List<Pelicula> listAllPeliculas = servicio.listAllPeliculas();

		req.setAttribute("listAllActors", listAllActors);
		///req.setAttribute("listAllPeliculas", listAllPeliculas);

		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addActor.jsp");
		dispatcher.forward(req,resp);
	}
}
