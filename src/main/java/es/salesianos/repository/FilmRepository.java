package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Film;

@Repository
public class FilmRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	private static final Logger log = LogManager.getLogger(ActorRepository.class);
	
	public void insert(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO FILM (tittle)" + "VALUES (?)");
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public void delete(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM FILM WHERE cod=?");
			preparedStatement.setInt(1, film.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public List<Film> selectAllFilm() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Film> listFilm = new ArrayList<Film>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM FILM");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film filmfromDataBase = new Film();
				filmfromDataBase.setCod(resultSet.getInt(1));
				filmfromDataBase.setTitle(resultSet.getString(2));
				filmfromDataBase.setCodDirector(resultSet.getInt(3));
				listFilm.add(filmfromDataBase);
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listFilm;
	}
}