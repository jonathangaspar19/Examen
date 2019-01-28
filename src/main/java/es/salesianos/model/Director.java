package es.salesianos.model;

import java.util.List;

public class Director {
	private Integer cod;
	private String name;

	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private List<Film> peliculas;

	public List<Film> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Film> peliculas) {
		this.peliculas = peliculas;
	}
}
