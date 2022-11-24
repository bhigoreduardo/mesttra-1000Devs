package domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

import dao.PessoaDAO;

public class Gerente {

	private String nome;

	public Gerente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	// Cadastrar Log
	private static void cadastrarLog(Log[] logs, String operacao) {

		for (int i = 0; i < logs.length; i++) {
			if (logs[i] == null) {
				logs[i] = new Log(LocalDateTime.now(), operacao);

				break;
			}
		}

	}

	// Cadastrar Cliente
	private static void cadastroMessage(Pessoa[] clientes) {

		if (clientes[clientes.length - 1] == null) {
			for (int i = 0; i < clientes.length; i++) {
				if (clientes[i] == null) {
					System.out.printf("\t\tCliente Nr. Conta %s cadastrado na base de dados.\n",
							clientes[i - 1].getNumeroConta());

					break;
				}
			}
		} else {
			System.out.printf("\t\tCliente Nr. Conta %s cadastrado na base de dados.\n",
					clientes[clientes.length - 1].getNumeroConta());
		}

	}

	private static PessoaFisica cadastrarPessoaFisica(String numeroConta, String agencia, String telefone,
			BigDecimal saldo, BigDecimal limiteChequeEspecial, String nome, String cpf, Integer idade) {
		return new PessoaFisica(numeroConta, agencia, telefone, saldo, limiteChequeEspecial, nome, cpf, idade);
	}

	private static PessoaJuridica cadastrarPessoaJuridica(String numeroConta, String agencia, String telefone,
			BigDecimal saldo, BigDecimal limiteChequeEspecial, String cnpj, String[] socios, String nomeFantasia) {
		return new PessoaJuridica(numeroConta, agencia, telefone, saldo, limiteChequeEspecial, cnpj, socios,
				nomeFantasia);
	}

	public Boolean cadastrarCliente(Scanner input) {

		PessoaDAO pessoaDAO = new PessoaDAO();
		String tipoCliente;

		System.out.println("\t\tCADASTRAR CLIENTE:");
		System.out.println("\t\t***********************************************");

		while (true) {
			System.out.println("\t\tInforme o tipo do Cliente:");
			System.out.println("\t\t[ 1 ] - Pessoa Física");
			System.out.println("\t\t[ 2 ] - Pessoa Jurídica");
			System.out.print("\t\t-> ");
			tipoCliente = input.nextLine().strip();

			if (tipoCliente.equals("1") || tipoCliente.equals("2")) {
				break;
			}

			System.err.println("\t\tTipo de cliente inválido, tente novamente.");
		}

		System.out.println("\t\tInforme o Numero da Conta:");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		// Check numero_conta

		System.out.println("\t\tInforme o Numero da Agencia:");
		System.out.print("\t\t-> ");
		String agencia = input.nextLine();

		System.out.println("\t\tInforme o Numero de Telefone:");
		System.out.print("\t\t-> ");
		String telefone = input.nextLine();

		System.out.println("\t\tInforme o Saldo de Deposito de Entrada:");
		System.out.print("\t\t-> ");
		BigDecimal saldo = new BigDecimal(input.nextLine());

		System.out.println("\t\tInforme o Limite do Cheque Especial de Entrada:");
		System.out.print("\t\t-> ");
		BigDecimal limiteChequeEspecial = new BigDecimal(input.nextLine());

		switch (tipoCliente) {
		case "1":
			System.out.println("\t\tInforme o Nome do Cliente:");
			System.out.print("\t\t-> ");
			String nome = input.nextLine();

			System.out.println("\t\tInforme o CPF do Cliente:");
			System.out.print("\t\t-> ");
			String cpf = input.nextLine();

			System.out.println("\t\tInforme a Idade do Cliente:");
			System.out.print("\t\t-> ");
			Integer idade = input.nextInt();
			input.nextLine();

			PessoaFisica pessoaFisica = cadastrarPessoaFisica(numeroConta, agencia, telefone, saldo,
					limiteChequeEspecial, nome, cpf, idade);

			return pessoaDAO.savePessoaFisica(pessoaFisica);
		case "2":
			System.out.println("\t\tInforme o CNPJ do Cliente:");
			System.out.print("\t\t-> ");
			String cnpj = input.nextLine();

			System.out.println("\t\tInforme a quantidade de sócios CPF do Cliente:");
			System.out.print("\t\t-> ");
			int quantidadeSocios = input.nextInt();
			String socios[] = new String[3];
			input.nextLine();

			for (int i = 0; i < quantidadeSocios; i++) {
				System.out.printf("\t\tInforme o nome do socio da %d posicao:\n", i + 1);
				System.out.print("\t\t-> ");
				socios[i] = input.nextLine();
			}

			System.out.println("\t\tInforme o Nome Fantasia do Cliente:");
			System.out.print("\t\t-> ");
			String nomeFantasia = input.nextLine();

			PessoaJuridica pessoaJuridica = cadastrarPessoaJuridica(numeroConta, agencia, telefone, saldo,
					limiteChequeEspecial, cnpj, socios, nomeFantasia);

			return pessoaDAO.savePessoaJuridica(pessoaJuridica);
		}

		return false;

	}

	// Pesquisar Cliente
	private int pesquisarCliente(String numeroConta, Pessoa[] clientes) {
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				if (clientes[i].getNumeroConta().equals(numeroConta)) {
					return i;
				}
			}
		}

		return -1;
	}

	// Remover Cliente
	public Pessoa[] removerCliente(Pessoa[] clientes, Scanner input, Log[] logs) {

		System.out.println("\t\tREMOVER CLIENTE:");
		System.out.println("\t\t***********************************************");

		if (clientes[0] == null) {
			System.err.println("\t\tNenhum cliente cadastrado na base de dados.");
			return null;
		}

		System.out.println("\t\tInforme o Numero da Conta do Cliente");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		int index = pesquisarCliente(numeroConta, clientes);

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

			System.out.printf("\t\tCliente Nr. Conta %s removido da base de dados.\n", numeroConta);
			cadastrarLog(logs, String.format("Cliente Nr. Conta %s removido da base de dados.", numeroConta));

			return clientesRemocao;
		}

		System.err.printf("\t\tCliente Nr. Conta %s informado nao encontrado na base de dados, tente novamente.\n",
				numeroConta);
		return null;

	}

	// Consultar Cliente
	public void consultarCliente(Pessoa[] clientes, Scanner input) {

		System.out.println("\t\tCONSULTAR CLIENTE:");
		System.out.println("\t\t***********************************************");

		if (clientes[0] == null) {
			System.err.println("\t\tNenhum cliente cadastrado na base de dados.");
		} else {

			System.out.println("\t\tInforme o Numero da Conta do Cliente");
			System.out.print("\t\t-> ");
			String numeroConta = input.nextLine();

			int index = pesquisarCliente(numeroConta, clientes);

			if (index > -1) {
				System.out.println(clientes[index].toString());
			} else {
				System.err.printf(
						"\t\tCliente Nr. Conta %s informado nao encontrado na base de dados, tente novamente.\n",
						numeroConta);
			}

		}

	}

	// Alterar Limite Cheque
	public Pessoa[] alterarLimiteChequeEspecial(Pessoa[] clientes, Scanner input, Log[] logs) {

		System.out.println("\t\tALTERAR LIMITE CHEQUE CLIENTE:");
		System.out.println("\t\t***********************************************");

		if (clientes[0] == null) {
			System.err.println("\t\tNenhum cliente cadastrado na base de dados.");
			return null;
		}

		System.out.println("\t\tInforme o Numero da Conta do Cliente");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		int index = pesquisarCliente(numeroConta, clientes);

		if (index > -1) {

			System.out.println("\t\tInforme a Acao Desejada:");
			System.out.println("\t\t[ 1 ] - Aumentar Limite em 100");
			System.out.println("\t\t[ 2 ] - Diminuir Limite em 100");
			System.out.print("\t\t-> ");
			String condicao = input.nextLine();

			if (!(condicao.equals("1") || condicao.equals("2"))) {
				System.err.println("\t\tTipo de acao invalido, tente novamente.");
				return null;
			}

			condicao = condicao.equals("1") ? "Aumentou" : "Diminuiu";

			BigDecimal valorAtual = clientes[index].getLimiteChequeEspecial();
			BigDecimal limite = new BigDecimal("100");

			if (condicao.equals("Aumentou")) {
				clientes[index].setLimiteChequeEspecial(valorAtual.add(limite));
			} else {
				clientes[index].setLimiteChequeEspecial(valorAtual.subtract(limite));
			}

			System.out.printf("\t\tCliente Nr. Conta %s Limite Cheque Especial %s em R$ %.2f.\n", numeroConta, condicao,
					limite);
			cadastrarLog(logs, String.format("Cliente Nr. Conta %s Limite Cheque Especial %s em R$ %.2f.", numeroConta,
					condicao, limite));
			return clientes;

		}

		System.err.printf("\t\tCliente Nr. Conta %s informado nao encontrado na base de dados, tente novamente.\n",
				numeroConta);
		return null;

	}

	// Transferir Saldo
	public Pessoa[] tranferirSaldo(Pessoa[] clientes, Scanner input, Log[] logs) {

		System.out.println("\t\tTRANSFERIR SALDO CLIENTE:");
		System.out.println("\t\t***********************************************");

		if (clientes[1] == null) {
			System.err.println("\t\tNecessario ao minimo dois clientes cadastrados na base de dados.");
			return null;
		}

		System.out.println("\t\tInforme o Numero da Conta do Cliente de Origem");
		System.out.print("\t\t-> ");
		String numeroContaOrigem = input.nextLine();

		System.out.println("\t\tInforme o Numero da Conta do Cliente de Destino");
		System.out.print("\t\t-> ");
		String numeroContaDestino = input.nextLine();

		int indexOrigem = pesquisarCliente(numeroContaOrigem, clientes);
		int indexDestino = pesquisarCliente(numeroContaDestino, clientes);

		if (indexOrigem > -1 && indexDestino > -1 && indexOrigem != indexDestino) {

			System.out.println("\t\tInforme o valor da Transferencia");
			System.out.print("\t\t-> ");
			BigDecimal valorTransferencia = new BigDecimal(input.nextLine());

			BigDecimal saldoOrigem = clientes[indexOrigem].getSaldo();
			BigDecimal saldoDestino = clientes[indexDestino].getSaldo();

			if (saldoOrigem.compareTo(valorTransferencia) == 1) {
				clientes[indexOrigem].setSaldo(saldoOrigem.subtract(valorTransferencia));
				clientes[indexDestino].setSaldo(saldoDestino.add(valorTransferencia));

				System.out.printf(
						"\t\tTransferencia valor R$ %.2f da Conta Origem Nr. %s para Conta Destino Nr. %s realizada com sucesso.\n",
						valorTransferencia, numeroContaOrigem, numeroContaDestino);
				cadastrarLog(logs, String.format(
						"Transferencia valor R$ %.2f da Conta Origem Nr. %s para Conta Destino Nr. %s realizada com sucesso.",
						valorTransferencia, numeroContaOrigem, numeroContaDestino));
				return clientes;
			}

			System.err.printf("\t\tSaldo do Cliente Nr. Conta %s insuficiente.\n", numeroContaOrigem);
			return null;

		}

		System.err.println("\t\tUma das Contas nao foi encontrada ou são iguais. Tente novamente.");
		return null;
	}

	// Adicionar Saldo
	public Pessoa[] adicionarSaldo(Pessoa[] clientes, Scanner input, Log[] logs) {

		System.out.println("\t\tADICIONAR SALDO CLIENTE:");
		System.out.println("\t\t***********************************************");

		if (clientes[0] == null) {
			System.err.println("\t\tNenhum cliente cadastrado na base de dados.");
			return null;
		}

		System.out.println("\t\tInforme o Numero da Conta do Cliente:");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		int index = pesquisarCliente(numeroConta, clientes);

		if (index > -1) {

			System.out.println("\t\tInforme o Valor do Deposito:");
			System.out.print("\t\t-> ");
			BigDecimal valorDeposito = new BigDecimal(input.nextLine());

			if (valorDeposito.compareTo(BigDecimal.ZERO) == 1) {
				BigDecimal saldo = clientes[index].getSaldo();

				clientes[index].setSaldo(saldo.add(valorDeposito));

				System.out.printf("\t\tDeposito no valor de R$ %.2f realizado na conta Nr. %s.\n", valorDeposito,
						numeroConta);
				cadastrarLog(logs, String.format("Deposito no valor de R$ %.2f realizado na conta Nr. %s.",
						valorDeposito, numeroConta));
				return clientes;
			}

			System.err.println("\t\tValor do deposito deve ser superior a ZERO!");
			return null;

		}

		System.err.println("\t\tNumero da conta do Cliente nao foi encontrada, tente novamente.");
		return null;
	}

	// Visualizar Clientes
	public void visualizarClientes(Pessoa[] clientes) {

		System.out.println("\t\tVISUALIZAR CLIENTES:");
		System.out.println("\t\t***********************************************");

		if (clientes[0] == null) {
			System.err.println("\t\tNenhum cliente cadastrado na base de dados.");
		} else {
			for (Pessoa cliente : clientes) {
				if (cliente != null) {
					System.out.println(cliente.toString());
				}
			}
		}

	}

}
