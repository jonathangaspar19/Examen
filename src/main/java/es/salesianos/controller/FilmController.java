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
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.service.FilmService;


@Controller
public class FilmController{
	
	@Autowired
	private FilmService service;

	@GetMapping(path = "/film")
	public ModelAndView getFilms() {
		ModelAndView model = new ModelAndView("film");
		model.addObject("listAllFilms", service.selectAllFilm());
		return model;
	}

	@GetMapping(path = "/deleteFilm")
	public String deleteFilm(@RequestParam String cod) {
		service.delete(cod);
		return "index";
	}

	@PostMapping(path = "/insertFilm")
	public String insertFilm(@RequestParam String title) {
		Film film = new Film();
		film.setTitle(title);
		service.insert(film);
		return "index";
	}

	@GetMapping(path = "/filmActor")
	public ModelAndView getfilmActor() {
		ModelAndView model = new ModelAndView("filmactors");
		model.addObject("listAllFilms", service.selectAllFilm());
		return model;
	}

}