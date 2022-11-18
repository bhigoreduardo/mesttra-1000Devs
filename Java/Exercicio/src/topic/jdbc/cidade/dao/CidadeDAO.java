package topic.jdbc.cidade.dao;

import java.util.ArrayList;
import java.util.List;

import topic.jdbc.cidade.pojo.Cidade;
import topic.jdbc.cidade.util.ConnectionFactory;

public class CidadeDAO extends ConnectionFactory {

	private static String query;
	private static Boolean status;

	public boolean insertInto(final Cidade cidade) {
		status = false;
		query = "INSERT INTO cidade " + "(ddd, nome, numero_habitantes, renda_per_capita, capital, estado, prefeito) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, cidade.getDdd());
			statement.setString(2, cidade.getNome());
			statement.setInt(3, cidade.getNumeroHabitantes());
			statement.setDouble(4, cidade.getRendaPerCapita());
			statement.setBoolean(5, cidade.getCapital());
			statement.setString(6, cidade.getEstado());
			statement.setString(7, cidade.getPrefeito());
			statement.execute();
			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha no cadastro da cidade." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

	public List<Cidade> selectAll() {
		query = "SELECT * FROM cidade";

		List<Cidade> cidades = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Cidade cidade = new Cidade();
				cidade.setDdd(resultSet.getInt("ddd"));
				cidade.setNome(resultSet.getString("nome"));
				cidade.setNumeroHabitantes(resultSet.getInt("numero_habitantes"));
				cidade.setRendaPerCapita(resultSet.getDouble("renda_per_capita"));
				cidade.setCapital(resultSet.getBoolean("capital"));
				cidade.setEstado(resultSet.getString("estado"));
				cidade.setPrefeito(resultSet.getString("prefeito"));

				cidades.add(cidade);
			}
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta das cidades." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		ConnectionFactory.closeConnection(connection, statement, resultSet);
		return cidades;
	}

	public Cidade selectByDdd(Integer ddd) {
		query = "SELECT * FROM cidade WHERE ddd=?";
		Cidade cidade = new Cidade();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, ddd);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				cidade.setDdd(resultSet.getInt("ddd"));
				cidade.setNome(resultSet.getString("nome"));
				cidade.setNumeroHabitantes(resultSet.getInt("numero_habitantes"));
				cidade.setRendaPerCapita(resultSet.getDouble("renda_per_capita"));
				cidade.setCapital(resultSet.getBoolean("capital"));
				cidade.setEstado(resultSet.getString("estado"));
				cidade.setPrefeito(resultSet.getString("prefeito"));
			}
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta da cidade DDD: " + ddd + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		ConnectionFactory.closeConnection(connection, statement, resultSet);
		return cidade;
	}

	public boolean update(Cidade cidade) {
		status = false;
		query = "UPDATE cidade SET nome=?, numero_habitantes=?, renda_per_capita=?, capital=?, estado=?, prefeito=? WHERE ddd=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, cidade.getNome());
			statement.setInt(2, cidade.getNumeroHabitantes());
			statement.setDouble(3, cidade.getRendaPerCapita());
			statement.setBoolean(4, cidade.getCapital());
			statement.setString(5, cidade.getEstado());
			statement.setString(6, cidade.getPrefeito());
			statement.setInt(7, cidade.getDdd());
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar a cidade." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

	public boolean delete(Integer ddd) {
		status = false;
		query = "DELETE FROM cidade WHERE ddd=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, ddd);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha na exclusão da cidade DDD: " + ddd + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

}
