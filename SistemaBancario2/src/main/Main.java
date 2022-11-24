package main;

import java.util.Scanner;

import domain.models.Gerente;
import domain.models.Log;
import domain.models.Pessoa;

public class Main {

	private static void helloWorld() {
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
		System.out.println("\t\t[ 8 ] - Visualizar Todos Logs do dia");
		System.out.println("\t\t[ 0 ] - Sair");
		System.out.print("\t\t-> ");
	}

	private static void showLogs(Log[] logs) {
		for (int i = 0; i < logs.length; i++) {
			if (logs[i] != null) {
				System.out.println(logs[i].toString());
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Pessoa clientes[] = new Pessoa[50];
		Log logs[] = new Log[50];

		helloWorld();
		Gerente gerente = new Gerente(input.nextLine());

		while (true) {

			mainMenu(gerente.getNome());
			String operation = input.nextLine();

			if (operation.equals("0")) {
				break;
			}

			switch (operation) {
			case "1": // Cadastrar Cliente

				Pessoa[] novosClientes = gerente.cadastrarCliente(clientes, input, logs);

				if (novosClientes != null) {
					clientes = novosClientes;
				}

				break;

			case "2": // Remover Cliente

				Pessoa[] clientesRemocao = gerente.removerCliente(clientes, input, logs);

				if (clientesRemocao != null) {
					clientes = clientesRemocao;
				}

				break;

			case "3": // Consultar Cliente

				gerente.consultarCliente(clientes, input);
				break;

			case "4": // Alterar Limite

				Pessoa[] clientesLimite = gerente.alterarLimiteChequeEspecial(clientes, input, logs);

				if (clientesLimite != null) {
					clientes = clientesLimite;
				}

				break;

			case "5": // Transferir Saldo

				Pessoa[] clientesTransferencia = gerente.tranferirSaldo(clientes, input, logs);

				if (clientesTransferencia != null) {
					clientes = clientesTransferencia;
				}

				break;

			case "6": // Adicionar Saldo

				Pessoa[] clientesDeposito = gerente.adicionarSaldo(clientes, input, logs);

				if (clientesDeposito != null) {
					clientes = clientesDeposito;
				}

				break;

			case "7": // Visualizar Clientes

				gerente.visualizarClientes(clientes);
				break;

			case "8": // Visualizar Logs
				
				System.out.println("\t\tVISUALIZAR LOG DO DIA:");
				System.out.println("\t\t***********************************************");

				if (clientes[0] == null) {
					System.err.println("\t\tNenhum cliente cadastrado na base de dados.");
					break;
				}
				
				showLogs(logs);
				break;
				
			default:
				System.err.println("\t\tOpcao invalida, tente novamente.");
			}
		}

	}

}