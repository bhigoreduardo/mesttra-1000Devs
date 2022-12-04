package main;

import java.util.Scanner;

import domain.models.Gerente;

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

	private static void message(String message) {
		System.out.println("\t\t" + message);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

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

				if (gerente.cadastrarCliente(input)) {
					message("Cliente cadastrado com sucesso!");
				} else {
					message("Falha no cadastrado do cliente.");
				}

				break;

			case "2": // Remover Cliente

				if (gerente.removerCliente(input)) {
					message("Cliente removido com sucesso!");
				} else {
					message("Falha na exclusão do cliente.");
				}

				break;

			case "3": // Consultar Cliente

				gerente.consultarCliente(input);
				break;

			case "4": // Alterar Limite

				if (gerente.alterarLimiteChequeEspecial(input)) {
					message("Limite atualizado com sucesso!");
				} else {
					message("Falha na atualização do limite.");
				}

				break;

			case "5": // Transferir Saldo

				if (gerente.tranferirSaldo(input)) {
					message("Transferência realizada com sucesso!");
				} else {
					message("Falha na transferência.");
				}

				break;

			case "6": // Adicionar Saldo

				if (gerente.adicionarSaldo(input)) {
					message("Depósito realizado com sucesso!");
				} else {
					message("Falha no depósito.");
				}

				break;

			case "7": // Visualizar Clientes

				gerente.visualizarClientes();
				break;
				
			case "8": // Visualizar Logs
				
				gerente.visualizarLogs();
				break;

			default:
				System.err.println("\t\tOpcao invalida, tente novamente.");
			}
		}

	}

}