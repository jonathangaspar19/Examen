package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

public class ActorService {
	private ActorRepository repository = new ActorRepository();

	public List<Actor> filterAllActor(int beginDate, int endDate) {
		return repository.filterAllActor(beginDate, endDate);
	}

	public List<Actor> selectAllActor() {
		return repository.selectAllActor();
	}
	
	public void insert(Actor actor) {
		repository.insert(actor);
	}
	
	public void delete(String codString) {
		Actor actor = new Actor();
		int cod = Integer.parseInt(codString);
		actor.setCod(cod);
		repository.delete(actor);
	}
}