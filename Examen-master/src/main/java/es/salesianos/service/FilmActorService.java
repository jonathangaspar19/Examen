package es.salesianos.service;


import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class FilmActorService {
	FilmActorRepository repository = new FilmActorRepository();
	
	public DtoActorFilm filterAllFilmActor(String role) {
		return repository.filterAllFilmActor(role);
	}
	
	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}
}