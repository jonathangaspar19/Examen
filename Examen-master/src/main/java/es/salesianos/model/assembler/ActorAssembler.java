package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;

public class ActorAssembler {
	public static Actor assembleActorFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String year = req.getParameter("year");
		if (null != year) {
			actor.setYear(Integer.parseInt(year));
		}
		String name = req.getParameter("name");
		actor.setName(name);
		return actor;
	}
}