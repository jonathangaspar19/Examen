package es.salesianos.service;



import es.salesianos.model.FilmActors;
import es.salesianos.repository.Repository;

public class FilmActorService {

	private Repository repository = new Repository();

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public void insertFilmActor(FilmActors peliculaActor) {
		repository.insert(peliculaActor);
		;
	}

	public FilmActors filterAllPeliculaActor(String role) {
		return repository.filterAllPeliculaActor(role);
	}


}
