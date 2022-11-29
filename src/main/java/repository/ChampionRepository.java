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

public class ChampionRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/lolh2initdata.sql'";
	AbstractConnection manager = new H2Connection();
	 

	public void insertChampion(Champions champion) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO CHAMPIONS (id,champion_name,title,lore,tags) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, champion.getId());
			preparedStatement.setString(2, champion.getChampion_name());
			preparedStatement.setString(3, champion.getTitle());
			preparedStatement.setString(4, champion.getLore());
			preparedStatement.setString(5, champion.getTags());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public int getSiguienteId() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		int siguienteId = -1;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT MAX(c.id) as id FROM CHAMPIONS c");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Entro");
				int id = resultSet.getInt("id");
				siguienteId = id + 1;
			}
			return siguienteId;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

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
/*

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
