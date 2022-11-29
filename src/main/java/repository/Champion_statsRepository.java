package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Champion_stats;

public class Champion_statsRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/lolh2initdata.sql'";
	AbstractConnection manager = new H2Connection();
	 

	public void insert(Champion_stats champion_stats) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO champions_stats (champion,stat_name,stat_value,modifier_per_level) VALUES (?, ?, ?, ?)");
			
			preparedStatement.setInt(1, champion_stats.getChampion());
			preparedStatement.setString(2, champion_stats.getStat_name());
			preparedStatement.setFloat(3, champion_stats.getStat_value());
			preparedStatement.setFloat(4, champion_stats.getModifier_per_level());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

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
