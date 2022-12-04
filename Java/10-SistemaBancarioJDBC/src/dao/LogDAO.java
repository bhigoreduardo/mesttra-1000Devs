package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import domain.models.Log;
import util.ConnectionFactory;

public class LogDAO extends ConnectionFactory {

	private static String query;
	private static Boolean status;

	private void setParameterPessoaJuridica(PreparedStatement statement, Log log) {
		try {
			statement.setString(1, log.getOperacao());
			statement.setString(2, log.getNumeroContaOrigem());
			if (log.getNumeroContaDestino() != null) {
				statement.setString(3, log.getNumeroContaDestino());
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	private void getParameter(ResultSet resultSet, List<Log> logs) {
		try {
			while (resultSet.next()) {
				Log log = new Log();

				log.setId(resultSet.getInt("id"));
				log.setData(LocalDateTime.ofInstant(Instant.ofEpochMilli((resultSet.getDate("data").getTime())),
						ZoneId.systemDefault()));
				log.setOperacao(resultSet.getString("operacao"));
				log.setNumeroContaOrigem(resultSet.getString("numero_conta_origem"));
				log.setNumeroContaDestino(resultSet.getString("numero_conta_destino"));

				logs.add(log);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	public Boolean save(Log log) {
		status = false;

		query = "INSERT INTO log (operacao, numero_conta_origem) VALUES (?, ?)";

		if (log.getNumeroContaDestino() != null) {
			query = "INSERT INTO log (operacao, numero_conta_origem, numero_conta_destino) VALUES (?, ?, ?)";
		}

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			setParameterPessoaJuridica(statement, log);
			statement.execute();
			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha no cadastro do log." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		return status;
	}

	public List<Log> selectAll() {
		query = "SELECT * FROM log";

		List<Log> logs = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			getParameter(resultSet, logs);
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta dos clientes." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return logs;
	}

}
