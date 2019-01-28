package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Film;
import es.salesianos.repository.Repository;

public class FilmService {
	
	
	private Repository repository = new Repository();

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public void addFilm(Film film) {
		repository.insertFilm(film);
	}

	public List<Film> listAllFilms() {
		return repository.searchAllFilms();
	}

	public void searchAndDeleteFilm(Integer codPelicula) {
		repository.searchAndDeleteFilm(codPelicula);
	}

}
