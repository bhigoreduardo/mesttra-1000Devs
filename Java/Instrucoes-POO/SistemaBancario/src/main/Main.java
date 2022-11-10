package main;

import java.math.BigDecimal;
import java.util.Scanner;

import domain.models.Gerente;
import domain.models.Pessoa;
import domain.models.PessoaFisica;
import domain.models.PessoaJuridica;

public class Main {

	private static void salutation() {
		System.out.println("\t\tSeja bem vindo ao sistema SMBB");
		System.out.println("\t\tSistema Monetario Bancario Brasileiro");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o nome do Gerente:");
		System.out.print("\t\t-> ");
	}

	private static void mainMenu(String nomeGerente) {
		System.out.printf("\t\tSessão iniciada pelo gerente: %s\n", nomeGerente);
		System.out.println("\t\tEscolha a operacao desejada:");
		System.out.println("\t\t[ 1 ] - Cadastrar Cliente");
		System.out.println("\t\t[ 2 ] - Remover Cliente");
		System.out.println("\t\t[ 3 ] - Consultar Cliente");
		System.out.println("\t\t[ 4 ] - Alterar Limite Cheque Especial do Cliente");
		System.out.println("\t\t[ 5 ] - Realizar Transacao Bancaria");
		System.out.println("\t\t[ 6 ] - Realizar Deposito");
		System.out.println("\t\t[ 7 ] - Visualizar Todos Clientes");
		System.out.println("\t\t[ 0 ] - Sair");
		System.out.print("\t\t-> ");
	}

	private static void insertClientMessage(Pessoa[] clientes) {

		if (clientes[clientes.length - 1] == null) {
			for (int i = 0; i < clientes.length; i++) {
				if (clientes[i] == null) {
					System.out.printf("\t\tCliente Numero Conta: %s Cadastrado com Sucesso!!\n",
							clientes[i - 1].getNumeroConta());

					break;
				}
			}
		} else {
			System.out.printf("\t\tCliente Numero Conta: %s Cadastrado com Sucesso!!\n",
					clientes[clientes.length - 1].getNumeroConta());
		}

	}

	private static Pessoa[] insertClient(Pessoa[] clientes) {
		Scanner input = new Scanner(System.in);

		System.out.println("\t\tCADASTRAR CLIENTE:");
		System.out.println("\t\t***********************************************");
		System.out.println("\t\tInforme o tipo do Cliente:");

		System.out.println("\t\t[ 1 ] - Pessoa Física");
		System.out.println("\t\t[ 2 ] - Pessoa Jurídica");
		System.out.print("\t\t-> ");
		String tipoCliente = input.nextLine().strip();

		if (!(tipoCliente.equals("1") || tipoCliente.equals("2"))) {
			System.out.println("\t\tTipo de Cliente inválido");
			return null;
		}

		System.out.println("\t\tInforme o Numero da Conta:");
		System.out.print("\t\t-> ");
		String numeroConta = input.nextLine();

		System.out.println("\t\tInforme o Numero da Agencia:");
		System.out.print("\t\t-> ");
		String numeroAgencia = input.nextLine();

		System.out.println("\t\tInforme o Numero de Telefone:");
		System.out.print("\t\t-> ");
		String numeroTelefone = input.nextLine();

		System.out.println("\t\tInforme o Saldo de Deposito de Entrada:");
		System.out.print("\t\t-> ");
		BigDecimal saldo = new BigDecimal(input.nextLine());

		System.out.println("\t\tInforme o Limite do Cheque Especial de Entrada:");
		System.out.print("\t\t-> ");
		BigDecimal limiteChequeEspecial = new BigDecimal(input.nextLine());

		Pessoa novoCliente;

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

			novoCliente = new PessoaFisica(numeroConta, numeroAgencia, numeroTelefone, saldo, limiteChequeEspecial,
					nome, cpf, idade);
			break;
		case "2":
			System.out.println("\t\tInforme o CNPJ do Cliente:");
			System.out.print("\t\t-> ");
			String cnpj = input.nextLine();

			System.out.println("\t\tInforme a quantidade de sócios CPF do Cliente:");
			System.out.print("\t\t-> ");
			Integer quantidadeSocios = input.nextInt();
			String socios[] = new String[3];

			for (int i = 0; i < quantidadeSocios; i++) {
				System.out.printf("\t\tInforme o nome do socio da %d posicao:\n", i + 1);
				System.out.print("\t\t-> ");
				socios[i] = input.nextLine();
			}

			System.out.println("\t\tInforme o Nome Fantasia do Cliente:");
			System.out.print("\t\t-> ");
			String nomeFantasia = input.nextLine();

			novoCliente = new PessoaJuridica(numeroConta, numeroAgencia, numeroTelefone, saldo, limiteChequeEspecial,
					cnpj, socios, nomeFantasia);
			break;
		default:
			return null;
		}

		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				if (novoCliente != null) {
					clientes[i] = novoCliente;
				}

				break;
			}
		}

		return clientes;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Pessoa clientes[] = new Pessoa[50];
		String numeroConta;

		salutation();
		Gerente gerente = new Gerente(input.nextLine());

		while (true) {
			mainMenu(gerente.getNome());
			String operation = input.nextLine();

			if (operation.equals("0"))
				break;

			switch (operation) {
			case "1":

				if (clientes[clientes.length - 1] != null) {
					System.out.println("\t\tQuantidade maxima de clientes atingida!");
					break;
				}

				Pessoa[] clientesCadastrado = insertClient(clientes);

				if (clientesCadastrado != null) {
					clientes = clientesCadastrado;
					insertClientMessage(clientes);

					System.out.println(clientes[0].getNumeroConta());
				}

				break;

			case "2":

				if (clientes[0] == null) {
					System.out.println("\t\tNenhum cliente cadastrado!");
					break;
				}

				System.out.println("\t\tInforme o Numero da Conta do Cliente");
				System.out.print("\t\t-> ");
				numeroConta = input.nextLine();

				Pessoa[] clientesRemocao = gerente.removerCliente(numeroConta, clientes);

				if (clientesRemocao != null) {
					clientes = clientesRemocao;
					System.out.printf("\t\tCliente Numero Conta: %s Removido com Sucesso!\n", numeroConta);
				} else {
					System.out.println("\t\tCliente informado nao encontrado!");
				}

				break;

			case "3":

				if (clientes[0] == null) {
					System.out.println("\t\tNenhum cliente cadastrado!");
					break;
				}

				System.out.println("\t\tInforme o Numero da Conta do Cliente");
				System.out.print("\t\t-> ");
				numeroConta = input.nextLine();

				gerente.consultarCliente(numeroConta, clientes);

				break;

			case "4":

				if (clientes[0] == null) {
					System.out.println("\t\tNenhum cliente cadastrado!");
					break;
				}

				System.out.println("\t\tInforme o Numero da Conta do Cliente");
				System.out.print("\t\t-> ");
				numeroConta = input.nextLine();

				System.out.println("\t\tInforme a Acao Desejada:");
				System.out.println("\t\t[ 1 ] - Aumentar Limite em 100");
				System.out.println("\t\t[ 2 ] - Diminuir Limite em 100");
				System.out.print("\t\t-> ");
				String condicao = input.nextLine();

				if (!(condicao.equals("1") || condicao.equals("2"))) {
					System.out.println("\t\tTipo de acao invalido");
					break;
				}

				Pessoa[] clientesLimite = gerente.alterarLimiteChequeEspecial(numeroConta, clientes, condicao);

				if (clientesLimite != null) {
					clientes = clientesLimite;
					System.out.printf("\t\tCliente Numero Conta: %s Limite Alterado com Sucesso!\n", numeroConta);
				} else {
					System.out.println("\t\tCliente informado nao encontrado!");
				}

				break;

			}
		}

	}

	private static void menu() {
		Scanner input = new Scanner(System.in);

		System.out.print("Telefone: ");
		String telefone = input.next();

		System.out.print("Saldo");
		double saldo = input.nextDouble();

		System.out.print("O cliente vai ser PJ ou PF? ");
		String cliente = input.next();

		if (cliente.equals("PF")) {
			System.out.print("Nome do Cliente: ");
			String nome = input.next();

			System.out.print("CPF do cliente? ");
			String CPF = input.next();

			System.out.print("Idade do cliente: ");
			int idade = input.nextInt();
		} else {
			System.out.print("CNPJ do cliente");
			String CNPJ = input.next();

			System.out.print("Número de sócios(até 3):");
			int NSocios = input.nextInt();
			for (int i = 0; i <= NSocios; i++) {
				System.out.print("Nomes dos sócios: ");
				String socios = input.next();
			}
		}

		System.out.print("Limite do cheque especial: ");
		double limite = input.nextDouble();
	}

}