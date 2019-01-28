package es.salesianos.model;

import java.util.List;

public class Film {
	private Integer cod;
	private String title;
	private Integer codowner;
	private Director director;
	private List<FilmActors> peliculaActor;

	public Integer getCOD() {
		return cod;
	}
	public void setCOD(Integer cOD) {
		cod = cOD;
	}
	public String getTITTLE() {
		return title;
	}

	public void setTITTLE(String Title) {
		title = Title;
	}
	public Integer getCODOWNER() {
		return codowner;
	}

	public void setCODOWNER(Integer Codowner) {
		codowner = Codowner;
	}
	
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<FilmActors> getPeliculaActor() {
		return peliculaActor;
	}

	public void setPeliculaActor(List<FilmActors> peliculaActor) {
		this.peliculaActor = peliculaActor;
	}
	
}
