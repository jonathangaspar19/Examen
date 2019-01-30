package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Director;

public class DirectorAssembler {
	public static Director assembleDirectorFrom(HttpServletRequest req) {
		Director director = new Director();
		String codDirector = req.getParameter("cod");
		if (null != codDirector) {
			director.setCod(Integer.parseInt(codDirector));
		}
		String name = req.getParameter("name");
		director.setName(name);
		return director;
	}
}