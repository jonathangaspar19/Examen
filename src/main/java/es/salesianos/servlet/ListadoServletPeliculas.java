package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Film;
import es.salesianos.repository.Repository;
import es.salesianos.service.FilmService;

public class ListadoServletPeliculas extends HttpServlet {
	
	private FilmService servicio = new FilmService();
	private Repository repository = new  Repository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Film> listAllFilms = servicio.listAllFilms();
			
		req.setAttribute("listAllFilms", listAllFilms);

		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addPelicula.jsp");
		dispatcher.forward(req,resp);
	}
}
