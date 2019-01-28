package es.salesianos.model;

public class FilmActors {
	private int cache;
	private String role;
	private int codFilm;
	private int codActor;
	private Actor actor;
	private Film film;

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

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
