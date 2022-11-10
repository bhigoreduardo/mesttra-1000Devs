package domain.models;

import java.math.BigDecimal;

public class Gerente {

	private String nome;

	public Gerente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	/*
	 * public Pessoa cadastrarPessoaFisica(String numeroConta, String agencia,
	 * String telefone, BigDecimal saldo, BigDecimal limiteChequeEspecial, String
	 * nome, String cpf, Integer idade) { return new PessoaFisica(numeroConta,
	 * agencia, telefone, saldo, limiteChequeEspecial, nome, cpf, idade); }
	 * 
	 * public Pessoa cadastrarPessoaJuridica(String numeroConta, String agencia,
	 * String telefone, BigDecimal saldo, BigDecimal limiteChequeEspecial, String
	 * cnpj, String[] socios, String nomeFantasia) { return new
	 * PessoaJuridica(numeroConta, agencia, telefone, saldo, limiteChequeEspecial,
	 * cnpj, socios, nomeFantasia); }
	 */

	private int pesquisarCliente(String numeroConta, Pessoa[] clientes) {
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i].getNumeroConta() == numeroConta) {
				return i;
			}
		}

		return -1;
	}

	public Pessoa[] removerCliente(String numeroConta, Pessoa[] clientes) {

		int index = pesquisarCliente(numeroConta, clientes);
		System.out.println(index);

		if (index > -1) {
			Pessoa[] clientesRemocao = new Pessoa[clientes.length];

			for (int i = 0, k = 0; i < clientes.length; i++) {
				if (i == index) {
					continue;
				} else if (clientes[i] != null) {
					clientesRemocao[k] = clientes[i];
					k++;
				}
			}

			return clientesRemocao;
		}

		return null;

	}

	public void consultarCliente(String numeroConta, Pessoa[] clientes) {
		int index = pesquisarCliente(numeroConta, clientes);

		if (index >= 0) {
			System.out.println(clientes[index].toString());
		} else {
			System.out.printf("\t\tCliente Numero Conta: %s nao encontrado!\n", numeroConta);
		}
	}

	public Pessoa[] alterarLimiteChequeEspecial(String numeroConta, Pessoa[] clientes, String codicao) {
		int index = pesquisarCliente(numeroConta, clientes);

		if (index >= 0) {
			BigDecimal valorAtual = clientes[index].getLimiteChequeEspecial();
			BigDecimal limite = new BigDecimal("100");

			if (codicao == "Aumentar") {
				valorAtual.add(limite);
			} else {
				valorAtual.subtract(limite);
			}

			clientes[index].setLimiteChequeEspecial(valorAtual);
		}

		return clientes;
	}

	public Pessoa[] tranferirSaldo(String contaOrigem, String contaDestino, BigDecimal valorTransferencia,
			Pessoa[] clientes) {
		int indexOrigem = pesquisarCliente(contaOrigem, clientes);
		int indexDestino = pesquisarCliente(contaDestino, clientes);

		if (indexOrigem > -1 && indexDestino > -1 && indexOrigem != indexDestino) {
			BigDecimal saldoOrigem = clientes[indexOrigem].getSaldo();
			BigDecimal saldoDestino = clientes[indexDestino].getSaldo();

			if (saldoOrigem.compareTo(valorTransferencia) == 1) {
				clientes[indexOrigem].setSaldo(saldoOrigem.subtract(valorTransferencia));
				clientes[indexDestino].setSaldo(saldoDestino.add(valorTransferencia));
			}
		}

		return clientes;
	}

	public Pessoa[] adicionarSaldo(String contaNumero, BigDecimal deposito, Pessoa[] clientes) {
		int index = pesquisarCliente(contaNumero, clientes);

		if (index > -1 && deposito.compareTo(BigDecimal.ZERO) == 1) {
			BigDecimal saldo = clientes[index].getSaldo();
			saldo.add(deposito);

			clientes[index].setSaldo(saldo);
		}

		return clientes;
	}

	public void visualizarClientes(Pessoa[] clientes) {
		for (Pessoa cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}

}
