package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.FilmActor;

public class FilmActorAssembler {
	public static FilmActor assembleFilmActorFrom(HttpServletRequest req) {
		FilmActor filmActor = new FilmActor();
		String codFilm = req.getParameter("codFilm");
		String codActor = req.getParameter("codActor");
		String cache = req.getParameter("cache");
		String role = req.getParameter("role");
		filmActor.setCodFilm(Integer.parseInt(codFilm));
		filmActor.setCodActor(Integer.parseInt(codActor));
		filmActor.setCache(Integer.parseInt(cache));
		filmActor.setRole(role);
		return filmActor;
	}
}