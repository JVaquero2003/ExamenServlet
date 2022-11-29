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

public class ItemsRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/lolh2initdata.sql'";
	AbstractConnection manager = new H2Connection();
	 

	public void insert(Items item) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		int id = getLastIdItem();
		id++;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO items (id,item_name,effect) VALUES (?, ?, ?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, item.getItem_name());
			preparedStatement.setString(3, item.getEffect());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public int getLastIdItem() {
		int last_id = 0;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT max(id) as id FROM items ");

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
	
	public void delete(int id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		
		try {

			preparedStatement = conn
					.prepareStatement("DELETE FROM items WHERE id = ?");
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

	public List<Items> listAll() {
		List<Items> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM items ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Items item = new Items();
				item.setId(resultSet.getInt("id"));
				item.setItem_name(resultSet.getString("item_name"));
				item.setEffect(resultSet.getString("effect"));
				
				
				lista.add(item);
			
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
	

	
}
