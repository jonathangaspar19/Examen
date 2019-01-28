package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.repository.Repository;


public class ActorService {
	private Repository repository = new Repository();

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Actor> listAllActors() {
		return repository.searchAllActors();
	}

	public void searchAndDeleteActor(Integer codActor) {
		repository.searchAndDeleteActor(codActor);
	}

	public void addActor(Actor actor) {
		repository.insert(actor);
	}

	public List<Actor> filterAllActor(int beginDate, int endDate) {
		return repository.filterAllActor(beginDate, endDate);
	}

	public List<Actor> selectAllActor() {
		return repository.selectAllActor();
	}

	public Actor filterAllDirector(String name) {
		return repository.filterAllDirector(name);
	}
}
