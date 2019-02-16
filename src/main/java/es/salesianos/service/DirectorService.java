package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Director;
import es.salesianos.repository.DirectorRepository;

@Service
public class DirectorService {
	
	@Autowired
	DirectorRepository repository;

	public List<Director> selectAllDirector() {
		return repository.selectAllDirector();
	}
	
	public void insert(Director director) {
		repository.insert(director);
	}
	
	public void delete(String codString) {
		Director director = new Director();
		int cod = Integer.parseInt(codString);
		director.setCod(cod);
		repository.delete(director);
	}

	public Director filterAllDirector(String name) {
		return repository.filterAllDirector(name);
	}
}