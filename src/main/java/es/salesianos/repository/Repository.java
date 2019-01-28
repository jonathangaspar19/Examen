package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;
import es.salesianos.model.FilmActors;

public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insert(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ACTOR (NAME,YEAROFBIRTHDATE)" + "VALUES (?, ?)");
			preparedStatement.setString(1, actor.getName());
			preparedStatement.setInt(2, actor.getYearofbirthday());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void insertFilm(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO FILM (TITTLE,CODOWNER)" + "VALUES (?, ?)");
			preparedStatement.setString(1, film.getTITTLE());
			preparedStatement.setInt(2, film.getCODOWNER());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void insertDirector(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO DIRECTOR (NAME)" + "VALUES (?)");
			preparedStatement.setString(1, director.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public List<Actor> searchAllActors() {
		List<Actor> listOwners = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {

			prepareStatement = conn.prepareStatement("SELECT * FROM ACTOR");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Actor actorInDataBase = new Actor();

				actorInDataBase.setCod(resultSet.getInt(1));
				actorInDataBase.setName(resultSet.getString(2));
				actorInDataBase.setYearofbirthday(resultSet.getInt(3));

				listOwners.add(actorInDataBase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOwners;
	}

	public List<Director> searchAllDirectors() {
		List<Director> listDirectors = new ArrayList<Director>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {

			prepareStatement = conn.prepareStatement("SELECT * FROM DIRECTOR");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Director directorInDataBase = new Director();

				directorInDataBase.setCod(resultSet.getInt(1));
				directorInDataBase.setName(resultSet.getString(2));

				listDirectors.add(directorInDataBase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listDirectors;
	}

	public List<Film> searchAllFilms() {
		List<Film> listPeliculas = new ArrayList<Film>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {

			prepareStatement = conn.prepareStatement("SELECT * FROM FILM");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Film peliculaInDataBase = new Film();

				peliculaInDataBase.setCOD(resultSet.getInt(1));
				peliculaInDataBase.setTITTLE(resultSet.getString(2));
				peliculaInDataBase.setCODOWNER(resultSet.getInt(3));

				listPeliculas.add(peliculaInDataBase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listPeliculas;
	}

	public Actor searchAndDeleteActor(Integer codActor) {
		Actor ownerInDatabase = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM ACTOR WHERE COD = ?");
			prepareStatement.setInt(1, codActor);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public Director searchAndDeleteDirector(Integer codDirector) {
		Director ownerInDatabase = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM DIRECTOR WHERE COD = ?");
			prepareStatement.setInt(1, codDirector);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public Film searchAndDeleteFilm(Integer codFilm) {
		Film ownerInDatabase = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM FILM WHERE COD = ?");
			prepareStatement.setInt(1, codFilm);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public List<Actor> filterAllActor(int beginDate, int endDate) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Actor> list = new ArrayList<Actor>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM ACTOR WHERE yearOfBirthDate BETWEEN (?) AND (?)");
			preparedStatement.setInt(1, beginDate);
			preparedStatement.setInt(2, endDate);
			System.out.println("llego");
			System.out.println(beginDate);
			System.out.println(endDate);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setCod(resultSet.getInt(1));
				actor.setName(resultSet.getNString(2));
				actor.setYearofbirthday(resultSet.getInt(3));
				list.add(actor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}

	public List<Actor> selectAllActor() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Actor> list = new ArrayList<Actor>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM ACTOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setCod(resultSet.getInt(1));
				actor.setName(resultSet.getNString(2));
				actor.setYearofbirthday(resultSet.getInt(3));
				list.add(actor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}

	public void insert(FilmActors filmActor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO FILMACTOR (cache, role, codActor, codFilm)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, filmActor.getCache());
			preparedStatement.setString(2, filmActor.getRole());
			preparedStatement.setInt(3, filmActor.getCodActor());
			preparedStatement.setInt(4, filmActor.getCodFilm());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public FilmActors filterAllPeliculaActor(String role) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		FilmActors filmActor = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM FILMACTOR WHERE ROLE = (?)");
			preparedStatement.setString(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FilmActors filmActorfromDataBase = new FilmActors();
				filmActorfromDataBase.setCache(resultSet.getInt(1));
				filmActorfromDataBase.setRole(resultSet.getString(2));
				filmActorfromDataBase.setCodActor(resultSet.getInt(3));
				filmActorfromDataBase.setCodFilm(resultSet.getInt(4));
				filmActor = filmActorfromDataBase;
			}
			preparedStatement = conn.prepareStatement("SELECT * FROM Actor where cod=" + filmActor.getCodActor());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actorfromDataBase = new Actor();
				actorfromDataBase.setName(resultSet.getString(2));
				actorfromDataBase.setYearofbirthday(resultSet.getInt(3));
				filmActor.setActor(actorfromDataBase);
			}

			preparedStatement = conn.prepareStatement("SELECT * FROM FILM where cod=" + filmActor.getCodFilm());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film filmfromDataBase = new Film();
				filmfromDataBase.setCOD(resultSet.getInt(1));
				filmfromDataBase.setTITTLE(resultSet.getString(2));
				filmfromDataBase.setCODOWNER(resultSet.getInt(3));
				filmActor.setFilm(filmfromDataBase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return filmActor;
	}

	public Actor filterAllDirector(String name) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Actor actor = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Actor WHERE name = (?)");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actorfromDataBase = new Actor();
				actorfromDataBase.setCod(resultSet.getInt(1));
				actorfromDataBase.setName(resultSet.getString(2));
				actorfromDataBase.setYearofbirthday(resultSet.getInt(3));
				actor = actorfromDataBase;
			}

			preparedStatement = conn.prepareStatement("SELECT * FROM FILMACTOR where codactor=" + actor.getCod());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FilmActors filmActorfromDataBase = new FilmActors();
				filmActorfromDataBase.setCodFilm(resultSet.getInt(4));
				actor.getFilmActor().add(filmActorfromDataBase);
			}

			int index = 0;
			for (FilmActors peliculaActor : actor.getFilmActor()) {

				preparedStatement = conn
						.prepareStatement("SELECT * FROM FILM where cod=" + peliculaActor.getCodFilm());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Film peliculafromDataBase = new Film();
					peliculafromDataBase.setTITTLE(resultSet.getString(2));
					peliculafromDataBase.setCODOWNER(resultSet.getInt(3));
					actor.getFilmActor().get(index).setFilm(peliculafromDataBase);
				}
				index++;
			}
			index = 0;
			for (FilmActors peliculaActor : actor.getFilmActor()) {
				preparedStatement = conn
						.prepareStatement("SELECT * FROM DIRECTOR where COD=" + peliculaActor.getFilm().getCODOWNER());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Director directorfromDataBase = new Director();
					directorfromDataBase.setName(resultSet.getString(2));
					actor.getFilmActor().get(index).getFilm().setDirector(directorfromDataBase);
				}
				index++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return actor;

	}

}
