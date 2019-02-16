package es.salesianos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

@Service
public class FilmActorService {
	
	@Autowired
	FilmActorRepository repository;
	
	public DtoActorFilm filterAllFilmActor(String role) {
		return repository.filterAllFilmActor(role);
	}
	
	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}
}