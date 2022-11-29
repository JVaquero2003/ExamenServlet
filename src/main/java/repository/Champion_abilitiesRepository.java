package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Champion_abilities;
import model.Champions;

public class Champion_abilitiesRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/lolh2initdata.sql'";
	AbstractConnection manager = new H2Connection();
	 

	public void insertChampionAbilities(Champion_abilities champion_abilities) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO champion_abilities (id,champion,champion_name,champion_description,effect,cost,rango) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, champion_abilities.getId());
			preparedStatement.setInt(2, champion_abilities.getChampion());
			preparedStatement.setString(3, champion_abilities.getChampion_name());
			preparedStatement.setString(4, champion_abilities.getChampion_description());
			preparedStatement.setString(5, champion_abilities.getEffect());
			preparedStatement.setString(6, champion_abilities.getCost());
			preparedStatement.setInt(7, champion_abilities.getRango());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	

	
	public List<Champion_abilities> listarHabilidadesCampeon(Champions champion) {
		List<Champion_abilities> habilidades = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM champion_abilities where champion = ?");
			preparedStatement.setInt(1, champion.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Champion_abilities habilidad = new Champion_abilities();
				habilidad.setId(resultSet.getInt("id"));
				habilidad.setChampion(resultSet.getInt("champion"));
				habilidad.setChampion_name(resultSet.getString("champion_name"));
				habilidad.setChampion_description(resultSet.getString("champion_description"));
				habilidad.setEffect(resultSet.getString("effect"));
				habilidad.setCost(resultSet.getString("cost"));
				habilidad.setRango(resultSet.getInt("rango"));
				
				habilidades.add(habilidad);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return habilidades;
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
