package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Director;
import es.salesianos.repository.Repository;


public class DirectorService {
	private Repository repository = new Repository();

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Director> listAllDirectors() {
		return repository.searchAllDirectors();
	}

	
	public void searchAndDeleteDirector(Integer codDirector) {
		repository.searchAndDeleteDirector(codDirector);
	}


	public void addDirector(Director director) {
		repository.insertDirector(director);
	}


}
