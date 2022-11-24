package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static Connection connection;
	public static PreparedStatement statement;
	public static ResultSet resultSet;
	public static CallableStatement callableStatement;

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bancario";
	private static final String USER = "postgres";
	private static final String PASS = "admin";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception ex) {
			throw new RuntimeException("Erro de conexexão com banco de dados." + ex.getMessage());
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException("Falha para a fechar conexexão com o banco de dados." + ex.getMessage());
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException("Falha para a fechar conexexão com o banco de dados." + ex.getMessage());
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException("Falha para a fechar conexexão com o banco de dados." + ex.getMessage());
		}
	}

}
