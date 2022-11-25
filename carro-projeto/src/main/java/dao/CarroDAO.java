package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carro;
import util.ConnectionFactory;

public class CarroDAO extends ConnectionFactory {

	private static String query;
	private static Boolean status;

	private void setParameter(PreparedStatement statement, Carro carro) {
		try {
			statement.setString(1, carro.getCor());
			statement.setString(2, carro.getMarca());
			statement.setString(3, carro.getModelo());
			statement.setString(4, carro.getPlaca());
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	private void getParameter(ResultSet resultSet, List<Carro> carros) {
		try {
			while (resultSet.next()) {
				Carro carro = new Carro();
				carro.setPlaca(resultSet.getString("placa"));
				carro.setCor(resultSet.getString("cor"));
				carro.setMarca(resultSet.getString("marca"));
				carro.setModelo(resultSet.getString("modelo"));

				carros.add(carro);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	public boolean save(Carro carro) {
		status = false;
		query = "INSERT INTO carro " + "(cor, marca, modelo, placa) "
				+ "VALUES (?, ?, ?, ?)";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			setParameter(statement, carro);
			statement.execute();
			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha no cadastro do carro." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

	public List<Carro> selectAll() {
		query = "SELECT * FROM carro";

		List<Carro> carros = new ArrayList();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			getParameter(resultSet, carros);
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta das carros." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		ConnectionFactory.closeConnection(connection, statement, resultSet);
		return carros;
	}

	public Carro selectByPlaca(String placa) {
		query = "SELECT * FROM carro WHERE placa=?";
		Carro carro = new Carro();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, placa);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				carro.setPlaca(resultSet.getString("placa"));
				carro.setCor(resultSet.getString("cor"));
				carro.setMarca(resultSet.getString("marca"));
				carro.setModelo(resultSet.getString("modelo"));
			}
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta do carro placa: " + placa + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		ConnectionFactory.closeConnection(connection, statement, resultSet);
		return carro;
	}

	public boolean update(Carro carro) {
		status = false;
		query = "UPDATE carro SET cor=?, marca=?, modelo=? WHERE placa=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			setParameter(statement, carro);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar o carro." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

	public boolean deleteByPlaca(String placa) {
		status = false;
		query = "DELETE FROM carro WHERE placa=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, placa);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha na exclusão do carro placa: " + placa + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}


}
