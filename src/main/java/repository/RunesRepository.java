package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Champions;
import model.Items;
import model.Runes;

public class RunesRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/lolh2initdata.sql'";
	AbstractConnection manager = new H2Connection();
	 

	public void insert(Runes rune) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		int id = getLastIdRunes();
		id++;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO runes (id,tier,rune_name,rune_description) VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, rune.getId());
			preparedStatement.setInt(2, rune.getTier());
			preparedStatement.setString(3, rune.getRune_name());
			preparedStatement.setString(4, rune.getRune_description());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public int getLastIdRunes() {
		int last_id = 0;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT max(id) as id FROM runes ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				last_id = resultSet.getInt("id");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return last_id;
	}
/*
	public List<Champions> listAll() {
		List<Champions> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM champions ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Champions champion = new Champions();
				champion.setId(resultSet.getInt("id"));
				champion.setChampion_name(resultSet.getString("champion_name"));
				champion.setTitle(resultSet.getString("title"));
				champion.setLore(resultSet.getString("lore"));
				champion.setTags(resultSet.getString("tags"));
				
				lista.add(champion);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return lista;
	}
	public void delete(int id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM Alumno WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
*/
	
}
