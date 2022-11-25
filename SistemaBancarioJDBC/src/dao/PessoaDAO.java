package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.models.Pessoa;
import domain.models.PessoaFisica;
import domain.models.PessoaJuridica;
import util.ConnectionFactory;

public class PessoaDAO extends ConnectionFactory {

	private static String query;
	private static Boolean status;

	private void getParameter(ResultSet resultSet, List<Pessoa> pessoas) {
		try {
			while (resultSet.next()) {
				if (resultSet.getString("nome") != null) {
					PessoaFisica pessoaFisica = new PessoaFisica();

					pessoaFisica.setNumeroConta(resultSet.getString("numero_conta"));
					pessoaFisica.setAgencia(resultSet.getString("agencia"));
					pessoaFisica.setTelefone(resultSet.getString("telefone"));
					pessoaFisica.setSaldo(resultSet.getBigDecimal("saldo"));
					pessoaFisica.setLimiteChequeEspecial(resultSet.getBigDecimal("limite_cheque_especial"));
					pessoaFisica.setNome(resultSet.getString("nome"));
					pessoaFisica.setCpf(resultSet.getString("cpf"));
					pessoaFisica.setIdade(resultSet.getInt("idade"));

					pessoas.add(pessoaFisica);
				} else {
					PessoaJuridica pessoaJuridica = new PessoaJuridica();

					pessoaJuridica.setNumeroConta(resultSet.getString("numero_conta"));
					pessoaJuridica.setAgencia(resultSet.getString("agencia"));
					pessoaJuridica.setTelefone(resultSet.getString("telefone"));
					pessoaJuridica.setSaldo(resultSet.getBigDecimal("saldo"));
					pessoaJuridica.setLimiteChequeEspecial(resultSet.getBigDecimal("limite_cheque_especial"));
					pessoaJuridica.setCnpj(resultSet.getString(("cnpj")));
					pessoaJuridica.setNomeFantasia(resultSet.getString("nomefantasia"));

					pessoas.add(pessoaJuridica);
				}
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

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
		} catch (SQLException ex) {
			throw new RuntimeException("Falha na requisição." + ex.getMessage());
		}
	}

	public Boolean savePessoaJuridica(PessoaJuridica pessoaJuridica) {
		status = false;

		query = "INSERT INTO pessoa "
				+ "(numero_conta, agencia, telefone, saldo, limite_cheque_especial, cnpj, nomefantasia) VALUES (?, ?, ?, ?, ?, ?, ?)";

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

	public Boolean deleteByNumeroConta(String numeroConta) {
		status = false;
		query = "DELETE FROM pessoa WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, numeroConta);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha na exclusão do cliente número conta: " + numeroConta + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		ConnectionFactory.closeConnection(connection, statement);
		return status;
	}

	public Pessoa selectByNumeroConta(String numeroConta) {
		query = "SELECT * FROM pessoa WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setString(1, numeroConta);
			resultSet = statement.executeQuery();

			if (resultSet.getString("nome") != null) {
				PessoaFisica pessoaFisica = new PessoaFisica();
				while (resultSet.next()) {
					pessoaFisica.setNumeroConta(resultSet.getString("numero_conta"));
					pessoaFisica.setAgencia(resultSet.getString("agencia"));
					pessoaFisica.setTelefone(resultSet.getString("telefone"));
					pessoaFisica.setSaldo(resultSet.getBigDecimal("saldo"));
					pessoaFisica.setLimiteChequeEspecial(resultSet.getBigDecimal("limite_cheque_especial"));
					pessoaFisica.setNome(resultSet.getString("nome"));
					pessoaFisica.setCpf(resultSet.getString("cpf"));
					pessoaFisica.setIdade(resultSet.getInt("idade"));
				}

				return pessoaFisica;
			} else {
				PessoaJuridica pessoaJuridica = new PessoaJuridica();

				while (resultSet.next()) {
					pessoaJuridica.setNumeroConta(resultSet.getString("numero_conta"));
					pessoaJuridica.setAgencia(resultSet.getString("agencia"));
					pessoaJuridica.setTelefone(resultSet.getString("telefone"));
					pessoaJuridica.setSaldo(resultSet.getBigDecimal("saldo"));
					pessoaJuridica.setLimiteChequeEspecial(resultSet.getBigDecimal("limite_cheque_especial"));
					pessoaJuridica.setCnpj(resultSet.getString(("cnpj")));
					pessoaJuridica.setNomeFantasia(resultSet.getString("nomefantasia"));
				}

				return pessoaJuridica;
			}

		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta do cliente número conta: " + numeroConta + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

	}

	public Boolean updateLimiteByNumeroConta(String numeroConta, BigDecimal novoLimite) {
		status = false;
		query = "UPDATE pessoa SET limite_cheque_especia=? WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setBigDecimal(1, novoLimite);
			statement.setString(2, numeroConta);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar limite do cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		return status;
	}

	public Boolean updateSaldosByNumerosConta(String numeroContaOrigem, String numeroContaDestino,
			BigDecimal valorTransferencia) {
		status = false;
		query = "UPDATE pessoa SET saldo=? WHERE numero_conta=? AND saldo=? WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			BigDecimal saldoDescontado = selectByNumeroConta(numeroContaOrigem).getSaldo().subtract(valorTransferencia);
			BigDecimal saldoAumentado = selectByNumeroConta(numeroContaDestino).getSaldo().subtract(valorTransferencia);

			statement.setBigDecimal(1, saldoDescontado);
			statement.setString(2, numeroContaOrigem);
			statement.setBigDecimal(1, saldoAumentado);
			statement.setString(2, numeroContaDestino);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar saldos dos cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		return status;
	}

	public Boolean updateReduzSaldoByNumeroConta(String numeroConta, BigDecimal valorTransferencia) {
		status = false;
		query = "UPDATE pessoa SET saldo=? WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			BigDecimal novoSaldo = selectByNumeroConta(numeroConta).getSaldo().subtract(valorTransferencia);

			statement.setBigDecimal(1, novoSaldo);
			statement.setString(2, numeroConta);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar saldo do cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		return status;
	}

	public Boolean updateAdicionaSaldoByNumeroConta(String numeroConta, BigDecimal valorTransferencia) {
		status = false;
		query = "UPDATE pessoa SET saldo=? WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			BigDecimal novoSaldo = selectByNumeroConta(numeroConta).getSaldo().add(valorTransferencia);

			statement.setBigDecimal(1, novoSaldo);
			statement.setString(2, numeroConta);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar saldo do cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		return status;
	}

	public Boolean updateSaldoByNumeroConta(String numeroConta, BigDecimal valorTransferencia) {
		status = false;
		query = "UPDATE pessoa SET saldo=? WHERE numero_conta=?";

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			BigDecimal novoSaldo = selectByNumeroConta(numeroConta).getSaldo().add(valorTransferencia);

			statement.setBigDecimal(1, novoSaldo);
			statement.setString(2, numeroConta);
			statement.execute();

			status = true;
		} catch (Exception ex) {
			throw new RuntimeException("Falha ao atualizar saldo do cliente." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

		return status;
	}

	public List<Pessoa> selectAll() {
		query = "SELECT * FROM pessoa";

		List<Pessoa> pessoas = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			getParameter(resultSet, pessoas);
		} catch (Exception ex) {
			throw new RuntimeException("Falha na consulta dos clientes." + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return pessoas;
	}

}
