package es.salesianos.model;

public class FilmActor {
	private int codFilm;
	private int codActor;
	private int cache;
	private String role;

	public int getCodFilm() {
		return codFilm;
	}

	public void setCodFilm(int codFilm) {
		this.codFilm = codFilm;
	}

	public int getCodActor() {
		return codActor;
	}

	public void setCodActor(int codActor) {
		this.codActor = codActor;
	}

	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}