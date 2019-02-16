package es.salesianos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Film;
import es.salesianos.model.FilmActor;
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.service.FilmActorService;
import es.salesianos.service.FilmService;

@Controller
public class FilmActorController extends HttpServlet {

	@Autowired
	private FilmActorService service;

	@GetMapping(path = "/fillFilmActor")
	public ModelAndView getPageFillFilmActor(@RequestParam Integer codActor, @RequestParam Integer codFilm) {
		ModelAndView model = new ModelAndView("fillFilmActor");
		model.addObject("codFilm", codFilm);
		model.addObject("codActor", codActor);
		return model;
	}

	@GetMapping(path = "/searchRole")
	public String getPagesearchRole() {
		return "searchRole";
	}

	@PostMapping(path = "/insertFilmActor")
	public String insertActor(@RequestParam Integer codActor, @RequestParam Integer codFilm, @RequestParam String role,
			@RequestParam Integer cache) {
		FilmActor filmActor = new FilmActor();
		filmActor.setCodActor(codActor);
		filmActor.setCodFilm(codFilm);
		filmActor.setCache(cache);
		filmActor.setRole(role);
		service.insert(filmActor);
		return "index";
	}

	@PostMapping(path = "/filterRole")
	public ModelAndView insertActor(@RequestParam String role) {
		ModelAndView model = new ModelAndView("searchRole");
		model.addObject("selectFilmActor", service.filterAllFilmActor(role));
		return model;
	}
}