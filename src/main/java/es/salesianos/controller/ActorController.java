package es.salesianos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ActorController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ActorService service;

	@GetMapping(path = "/actor")
	public ModelAndView getActors() {
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", service.selectAllActor());
		return model;
	}

	@GetMapping(path = "/deleteActor")
	public String deleteActor(@RequestParam String cod) {
		service.delete(cod);
		return "index";
	}

	@GetMapping(path = "/filterActor")
	public ModelAndView filterActor(@RequestParam Integer beginDate, @RequestParam Integer endDate) {
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", service.filterAllActor(beginDate, endDate));
		return model;
	}

	@PostMapping(path = "/insertActor")
	public String insertActor(@RequestParam String name, @RequestParam Integer year) {
		Actor actor = new Actor();
		actor.setName(name);
		actor.setYear(year);
		service.insert(actor);
		return "index";
	}

	@GetMapping(path = "/recoveryFilm")
	public ModelAndView recoveryFilm(@RequestParam Integer cod) {
		ModelAndView model = new ModelAndView("selectActor");
		model.addObject("codFilm", cod);
		model.addObject("listAllActors", service.selectAllActor());
		return model;
	}
}