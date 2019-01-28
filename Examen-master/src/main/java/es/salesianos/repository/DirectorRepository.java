package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Director;

public class DirectorRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	private static final Logger log = LogManager.getLogger(ActorRepository.class);

	public void insert(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO DIRECTOR (name)" + "VALUES (?)");
			preparedStatement.setString(1, director.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void delete(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM DIRECTOR WHERE cod=?");
			preparedStatement.setInt(1, director.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public List<Director> selectAllDirector() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Director> listDirector = new ArrayList<Director>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM DIRECTOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Director directorfromDataBase = new Director();
				directorfromDataBase.setCod(resultSet.getInt(1));
				directorfromDataBase.setName(resultSet.getString(2));
				listDirector.add(directorfromDataBase);
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listDirector;
	}
	
	public Director filterAllDirector(String name) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Director director = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT DIRECTOR.NAME" + " FROM (((ACTOR"
					+ " INNER JOIN FILMACTOR ON FILMACTOR.CODACTOR = ACTOR.COD)"
					+ " INNER JOIN FILM ON FILM.COD = FILMACTOR.CODFILM)"
					+ " INNER JOIN DIRECTOR ON DIRECTOR.COD = FILM.CODOWNER)" + " WHERE ACTOR.NAME = (?)");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Director directorfromDataBase = new Director();
				directorfromDataBase.setName(resultSet.getString(1));
				director = directorfromDataBase;
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return director;
	}
}