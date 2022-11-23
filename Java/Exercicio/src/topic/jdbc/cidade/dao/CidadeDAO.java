package topic.jdbc.cidade.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import topic.jdbc.cidade.pojo.Cidade;
import topic.jdbc.cidade.util.ConnectionFactory;

public class CidadeDAO extends ConnectionFactory {

	private static String query;
	private static Boolean status;

	private void setParameter(PreparedStatement statement, Cidade cidade) {
		try {
			statement.setInt(1, cidade.getDdd());
			statement.setString(2, cidade.getNome());
			statement.setInt(3, cidade.getNumeroHabitantes());
			statement.setDouble(4, cidade.getRendaPerCapita());
			statement.setBoolean(5, cidade.getCapital());
			statement.setString(6, cidade.getEstado());
			statement.setString(7, cidade.getPrefeito());
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	private void getParameter(ResultSet resultSet, List<Cidade> cidades) {
		try {
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
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	public boolean save(Cidade cidade) {
		status = false;
		query = "INSERT INTO cidade " + "(ddd, nome, numero_habitantes, renda_per_capita, capital, estado, prefeito) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			setParameter(statement, cidade);
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

			getParameter(resultSet, cidades);
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

			setParameter(statement, cidade);
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

	public boolean deleteByDdd(Integer ddd) {
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

	public List<Cidade> findByNomeStartingWith(String prefix) {
		query = "SELECT * FROM cidade WHERE nome LIKE ?";

		List<Cidade> cidades = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, prefix + "%");
			resultSet = statement.executeQuery();

			getParameter(resultSet, cidades);
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta das cidades." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return cidades;
	}

	public List<Cidade> findByEstado(String estado) {
		query = "SELECT * FROM cidade WHERE nome estado=?";

		List<Cidade> cidades = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, estado);
			resultSet = statement.executeQuery();

			getParameter(resultSet, cidades);
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta das cidades." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return cidades;
	}

	public int countByEstado(String estado) {
		// query = "SELECT count(*) FROM cidade WHERE nome estado=?";
		query = "SELECT count(*) AS quantidade_cidade FROM cidade WHERE nome estado=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, estado);
			resultSet = statement.executeQuery();

			// return resultSet.getInt(0);
			return resultSet.getInt("quantidade_cidade");
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta das cidades." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

	}

	public List<Cidade> findByIsCapital(Boolean capital) {
		query = "SELECT * FROM cidade WHERE capital IS ?";

		List<Cidade> cidades = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setBoolean(1, capital);
			resultSet = statement.executeQuery();

			getParameter(resultSet, cidades);
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta das cidades." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return cidades;
	}
	
}
