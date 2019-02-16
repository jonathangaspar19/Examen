package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Film;
import es.salesianos.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	FilmRepository repository;

	public List<Film> selectAllFilm() {
		return repository.selectAllFilm();
	}
	
	public void insert(Film film) {
		repository.insert(film);
	}
	
	public void delete(String codString) {
		Film film = new Film();
		int cod = Integer.parseInt(codString);
		film.setCod(cod);
		repository.delete(film);
	}
}