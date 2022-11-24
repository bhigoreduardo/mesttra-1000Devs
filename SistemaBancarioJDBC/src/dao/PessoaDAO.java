package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.models.PessoaFisica;
import domain.models.PessoaJuridica;
import util.ConnectionFactory;

public class PessoaDAO extends ConnectionFactory {

	private static String query;
	private static Boolean status;

	// PF
	private void setParameterPessoaFisica(PreparedStatement statement, PessoaFisica pessoaFisica) {
		try {
			statement.setString(1, pessoaFisica.getNumeroConta());
			statement.setString(2, pessoaFisica.getAgencia());
			statement.setString(3, pessoaFisica.getTelefone());
			statement.setBigDecimal(4, pessoaFisica.getSaldo());
			statement.setBigDecimal(5, pessoaFisica.getLimiteChequeEspecial());
			statement.setString(6, pessoaFisica.getNome());
			statement.setString(7, pessoaFisica.getCpf());
			statement.setInt(8, pessoaFisica.getIdade());
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	public Boolean savePessoaFisica(PessoaFisica pessoaFisica) {
		status = false;
		query = "INSERT INTO pessoa "
				+ "(numero_conta, agencia, telefone, saldo, limite_cheque_especial, nome, cpf, idade) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			setParameterPessoaFisica(statement, pessoaFisica);
			statement.execute();
			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha no cadastro do cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

	// PJ
	private void setParameterPessoaJuridica(PreparedStatement statement, PessoaJuridica pessoaJuridica) {
		try {
			statement.setString(1, pessoaJuridica.getNumeroConta());
			statement.setString(2, pessoaJuridica.getAgencia());
			statement.setString(3, pessoaJuridica.getTelefone());
			statement.setBigDecimal(4, pessoaJuridica.getSaldo());
			statement.setBigDecimal(5, pessoaJuridica.getLimiteChequeEspecial());
			statement.setString(6, pessoaJuridica.getCnpj());
			statement.setString(7, pessoaJuridica.getNomeFantasia());
			/*
			 * for (int i = 0; i < pessoaJuridica.getSocios().length; i++) {
			 * statement.setString(8 + i, pessoaJuridica.getSocios()[i]); }
			 */
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	public Boolean savePessoaJuridica(PessoaJuridica pessoaJuridica) {
		status = false;

		query = "INSERT INTO pessoa "
				+ "(numero_conta, agencia, telefone, saldo, limite_cheque_especial, cnpj, nomefantasia) VALUES (?, ?, ?, ?, ?, ?, ?)";

		/*
		 * for (String socio : pessoaJuridica.getSocios()) { query += ", " + socio; }
		 * query += ") VALUES (?, ?, ?, ?, ?, ?, ?"; for (String socio :
		 * pessoaJuridica.getSocios()) { query += ", ?"; } query += ")";
		 */

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			setParameterPessoaJuridica(statement, pessoaJuridica);
			statement.execute();
			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha no cadastro do cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

}
