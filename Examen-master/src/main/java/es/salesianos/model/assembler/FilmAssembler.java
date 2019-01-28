package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Film;

public class FilmAssembler {
	public static Film assembleFilmFrom(HttpServletRequest req) {
		Film film = new Film();
		String codDirector = req.getParameter("codDirector");
		if (null != codDirector) {
			film.setCodDirector(Integer.parseInt(codDirector));
		}
		String title = req.getParameter("title");
		film.setTitle(title);
		return film;
	}
}