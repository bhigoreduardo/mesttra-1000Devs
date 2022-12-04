package domain.models;

import java.math.BigDecimal;
import java.util.Scanner;

import dao.LogDAO;
import dao.PessoaDAO;

public class Gerente {

	private String nome;

	public Gerente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
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
		LogDAO logDAO = new LogDAO();
		String tipoCliente;
		Boolean status = false;
		Log log = new Log();

		log.setOperacao("Cadastro conta");

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

			status = pessoaDAO.savePessoaFisica(pessoaFisica);

			if (status) {
				log.setNumeroContaOrigem(numeroConta);
				logDAO.save(log);
			}

			break;
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

			status = pessoaDAO.savePessoaJuridica(pessoaJuridica);

			if (status) {
				log.setNumeroContaOrigem(numeroConta);
				logDAO.save(log);
			}

			break;
		}

		return status;

	}

	public Boolean removerCliente(Scanner input) {

		PessoaDAO pessoaDAO = new PessoaDAO();
		LogDAO logDAO = new LogDAO();

		Boolean status = false;
		Log log = new Log();

		log.setOperacao("Exclusão de conta");

		System.out.println("\t\tREMOVER CLIENTE:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da Conta do Cliente");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		status = pessoaDAO.deleteByNumeroConta(numeroConta);

		if (status) {
			log.setNumeroContaOrigem(numeroConta);
			logDAO.save(log);
		}

		return status;

	}

	public void consultarCliente(Scanner input) {

		System.out.println("\t\tCONSULTAR CLIENTE:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da Conta do Cliente");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		PessoaDAO pessoaDAO = new PessoaDAO();
		System.out.println(pessoaDAO.selectByNumeroConta(numeroConta).toString());

	}

	public Boolean alterarLimiteChequeEspecial(Scanner input) {

		PessoaDAO pessoaDAO = new PessoaDAO();
		LogDAO logDAO = new LogDAO();

		Boolean status = false;
		Log log = new Log();

		log.setOperacao("Alteração de Limite");

		System.out.println("\t\tALTERAR LIMITE CHEQUE CLIENTE:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da Conta do Cliente");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		System.out.println("\t\tInforme Novo Limite:");
		System.out.print("\t\t-> ");
		BigDecimal novoLimite = new BigDecimal(input.nextLine());

		status = pessoaDAO.updateLimiteByNumeroConta(numeroConta, novoLimite);

		if (status) {
			log.setNumeroContaOrigem(numeroConta);
			logDAO.save(log);
		}

		return status;
	}

	public Boolean tranferirSaldo(Scanner input) {

		PessoaDAO pessoaDAO = new PessoaDAO();
		LogDAO logDAO = new LogDAO();

		Boolean status = false;
		Log log = new Log();

		log.setOperacao("Transferência de saldos");

		System.out.println("\t\tTRANSFERIR SALDO CLIENTE:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da Conta do Cliente de Origem");
		System.out.print("\t\t-> ");
		String numeroContaOrigem = input.nextLine();

		System.out.println("\t\tInforme o Numero da Conta do Cliente de Destino");
		System.out.print("\t\t-> ");
		String numeroContaDestino = input.nextLine();

		System.out.println("\t\tInforme o valor da Transferencia");
		System.out.print("\t\t-> ");
		BigDecimal valorTransferencia = new BigDecimal(input.nextLine());

		Pessoa pessoaContaOrigem = pessoaDAO.selectByNumeroConta(numeroContaOrigem);

		if (pessoaContaOrigem.getSaldo().compareTo(valorTransferencia) == 1) {
			BigDecimal novoSaldoOrigem = pessoaDAO.selectByNumeroConta(numeroContaOrigem).getSaldo()
					.subtract(valorTransferencia);
			BigDecimal novoSaldoDestino = pessoaDAO.selectByNumeroConta(numeroContaDestino).getSaldo()
					.add(valorTransferencia);

			status = (pessoaDAO.updateReduzSaldoByNumeroConta(numeroContaOrigem, novoSaldoOrigem)
					&& pessoaDAO.updateAdicionaSaldoByNumeroConta(numeroContaDestino, novoSaldoDestino));
			
			if (status) {
				log.setNumeroContaOrigem(numeroContaOrigem);
				log.setNumeroContaDestino(numeroContaDestino);
				logDAO.save(log);
			}

			return status;
		} else {
			System.err.printf("\t\tSaldo do Cliente Nr. Conta %s insuficiente.\n", numeroContaOrigem);
			return status;
		}

	}

	public Boolean adicionarSaldo(Scanner input) {

		PessoaDAO pessoaDAO = new PessoaDAO();
		LogDAO logDAO = new LogDAO();

		Boolean status = false;
		Log log = new Log();

		log.setOperacao("Depósito");
		
		System.out.println("\t\tADICIONAR SALDO CLIENTE:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da Conta do Cliente:");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		System.out.println("\t\tInforme o Valor do Deposito:");
		System.out.print("\t\t-> ");
		BigDecimal valorDeposito = new BigDecimal(input.nextLine());

		BigDecimal novoSaldo = pessoaDAO.selectByNumeroConta(numeroConta).getSaldo().add(valorDeposito);

		status = pessoaDAO.updateSaldoByNumeroConta(numeroConta, novoSaldo);
		
		if (status) {
			log.setNumeroContaOrigem(numeroConta);
			logDAO.save(log);
		}
		
		return status;
	}

	public void visualizarClientes() {

		System.out.println("\t\tVISUALIZAR CLIENTES:");
		System.out.println("\t\t***********************************************");

		PessoaDAO pessoaDAO = new PessoaDAO();
		System.out.println(pessoaDAO.selectAll().toString());

	}

	public void visualizarLogs() {
		LogDAO logDAO = new LogDAO();
		
		System.out.println("\t\tVISUALIZAR LOGS:");
		System.out.println("\t\t***********************************************");
		
		for(Log log : logDAO.selectAll()) {
			System.out.println(log.toString());
		}
	}
	
}
