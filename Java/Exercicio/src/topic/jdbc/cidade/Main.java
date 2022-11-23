package topic.jdbc.cidade;

import java.util.Scanner;

import topic.jdbc.cidade.dao.CidadeDAO;
import topic.jdbc.cidade.pojo.Cidade;

public class Main {

	private static void helloWorld() {
		System.out.println("\t\tSeja bem vindo ao sistema SCCB");
		System.out.println("\t\tSistema Cadastro de Cidades Brasileiras");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o nome do Gerente:");
		System.out.print("\t\t-> ");
	}

	private static void mainMenu(String nomeGerente) {
		System.out.printf("\t\tSessão iniciada pelo gerente: %s\n", nomeGerente);
		System.out.println("\t\tEscolha a operacao desejada:");
		System.out.println("\t\t[ 1 ] - Cadastrar Cidade");
		System.out.println("\t\t[ 2 ] - Remover Cidade");
		System.out.println("\t\t[ 3 ] - Consultar Cidade");
		System.out.println("\t\t[ 4 ] - Alterar Cidade");
		System.out.println("\t\t[ 5 ] - Visualizar Todas Cidades");
		System.out.println("\t\t[ 0 ] - Sair");
		System.out.print("\t\t-> ");
	}

	private static void userMessage(String message) {
		System.out.println("\t\t" + message);
	}

	private static boolean save(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tCADASTRAR CIDADE:");
		System.out.println("\t\t***********************************************");
		Integer ddd;

		while (true) {
			System.out.println("\t\tInforme o DDD da Cidade:");
			System.out.print("\t\t-> ");
			ddd = input.nextInt();

			if (cidadeDAO.selectByDdd(ddd).getNome() == null) {
				break;
			} else {
				System.out.println("DDD ja cadastrado no Banco.");
			}
		}
		input.nextLine();

		System.out.println("\t\tInforme o nome da Cidade:");
		System.out.print("\t\t-> ");
		String nome = input.nextLine();

		System.out.println("\t\tInforme a quantidade de habitantes:");
		System.out.print("\t\t-> ");
		Integer numeroHabitantes = input.nextInt();

		System.out.println("\t\tInforme a renda per capita:");
		System.out.print("\t\t-> ");
		Double rendaPerCapita = input.nextDouble();
		input.nextLine();

		System.out.println("\t\tInforme o Estado da Cidade:");
		System.out.print("\t\t-> ");
		String estado = input.nextLine();

		System.out.println("\t\tInforme o nome do prefeito:");
		System.out.print("\t\t-> ");
		String prefeito = input.nextLine();

		Cidade cidade = new Cidade(ddd, nome, numeroHabitantes, rendaPerCapita, estado, prefeito);

		System.out.println("\t\tA cidade e capital do estado:");
		System.out.println("\t\t[ 1 ] - SIM");
		System.out.println("\t\t[ 2 ] - NAO");
		System.out.print("\t\t-> ");
		String choice = input.nextLine();

		if (choice.equals("1")) {
			cidade.setCapital(true);
		}

		return cidadeDAO.save(cidade);
	}

	private static boolean deleteByDdd(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tREMOVER CIDADE:");
		System.out.println("\t\t***********************************************");
		Integer ddd;

		while (true) {
			System.out.println("\t\tInforme o DDD da Cidade:");
			System.out.print("\t\t-> ");
			ddd = input.nextInt();

			if (cidadeDAO.selectByDdd(ddd) != null) {
				break;
			} else {
				System.out.println("DDD nao encontrado no Banco.");
			}
		}

		return cidadeDAO.deleteByDdd(ddd);
	}

	private static void selectByDdd(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tCONSULTAR CIDADE:");
		System.out.println("\t\t***********************************************");
		Cidade cidade;
		Integer ddd;

		while (true) {
			System.out.println("\t\tInforme o DDD da Cidade:");
			System.out.print("\t\t-> ");
			ddd = input.nextInt();
			cidade = cidadeDAO.selectByDdd(ddd);

			if (cidade != null) {
				break;
			} else {
				System.out.println("DDD nao encontrado no Banco.");
			}
		}

		System.out.println(cidade.toString());
	}

	private static boolean update(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tALTERAR CIDADE:");
		System.out.println("\t\t***********************************************");
		Cidade cidade;
		Integer ddd;

		while (true) {
			System.out.println("\t\tInforme o DDD da Cidade:");
			System.out.print("\t\t-> ");
			ddd = input.nextInt();
			cidade = cidadeDAO.selectByDdd(ddd);

			if (cidade != null) {
				break;
			} else {
				System.out.println("DDD nao encontrado no Banco.");
			}
		}

		System.out.println("\t\tInforme o nome da Cidade:");
		System.out.print("\t\t-> ");
		String nome = input.nextLine();
		cidade.setNome(nome);

		System.out.println("\t\tInforme a quantidade de habitantes:");
		System.out.print("\t\t-> ");
		Integer numeroHabitantes = input.nextInt();
		cidade.setNumeroHabitantes(numeroHabitantes);

		System.out.println("\t\tInforme a renda per capita:");
		System.out.print("\t\t-> ");
		Double rendaPerCapita = input.nextDouble();
		cidade.setRendaPerCapita(rendaPerCapita);

		System.out.println("\t\tInforme o Estado da Cidade:");
		System.out.print("\t\t-> ");
		String estado = input.nextLine();
		cidade.setEstado(estado);

		System.out.println("\t\tInforme o nome do prefeito:");
		System.out.print("\t\t-> ");
		String prefeito = input.nextLine();
		cidade.setPrefeito(prefeito);

		System.out.println("\t\tA cidade e capital do estado:");
		System.out.println("\t\t[ 1 ] - SIM");
		System.out.println("\t\t[ 2 ] - NAO");
		System.out.print("\t\t-> ");
		String choice = input.nextLine();

		if (choice.equals("1")) {
			cidade.setCapital(true);
		}

		return cidadeDAO.update(cidade);
	}

	private static void selectAll(CidadeDAO cidadeDAO) {
		System.out.println("\t\tCONSULTAR TODAS CIDADE:");
		System.out.println("\t\t***********************************************");

		System.out.println(
				"\t\tDDD \t\tNome \t\tNumero de Habitantes \t\tRenda Per Capita \t\tisCapital \t\tEstado \t\tPrefeito \n");

		cidadeDAO.selectAll().forEach(cidade -> System.out.println(cidade.toString()));

	}

	private static void findByNomeStartingWith(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tInforme o DDD da Cidade:");
		System.out.print("\t\t-> ");
		String prefix = input.nextLine();
		
		System.out.println("\t\tCONSULTAR TODAS CIDADE INICIA COM: + " + prefix);
		System.out.println("\t\t***********************************************");

		System.out.println(
				"\t\tDDD \t\tNome \t\tNumero de Habitantes \t\tRenda Per Capita \t\tisCapital \t\tEstado \t\tPrefeito \n");

		cidadeDAO.findByNomeStartingWith(prefix).forEach(cidade -> System.out.println(cidade.toString()));
	}
	
	private static void findByEstado(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tInforme o Estado da Cidade:");
		System.out.print("\t\t-> ");
		String estado = input.nextLine();
		
		System.out.println("\t\tCONSULTAR TODAS CIDADE DO ESTADO: + " + estado);
		System.out.println("\t\t***********************************************");

		System.out.println(
				"\t\tDDD \t\tNome \t\tNumero de Habitantes \t\tRenda Per Capita \t\tisCapital \t\tEstado \t\tPrefeito \n");

		cidadeDAO.findByEstado(estado).forEach(cidade -> System.out.println(cidade.toString()));
	}
	
	private static void countByEstado(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tInforme o Estado da Cidade:");
		System.out.print("\t\t-> ");
		String estado = input.nextLine();
		
		System.out.println("\t\tQUANTIDADE DE CIDADE DO ESTADO: + " + estado);
		System.out.println("\t\t***********************************************");

		System.out.println("\t\t-> " + cidadeDAO.countByEstado(estado));
	}
	
	private static void findByIsCapital(Scanner input, CidadeDAO cidadeDAO) {
		System.out.println("\t\tA cidade e capital do estado:");
		System.out.println("\t\t[ 1 ] - SIM");
		System.out.println("\t\t[ 2 ] - NAO");
		System.out.print("\t\t-> ");
		Boolean capital = input.nextLine().equals("1") ? true: false;
		
		System.out.println("\t\tCONSULTAR CIDADE:");
		System.out.println("\t\t***********************************************");

		System.out.println(
				"\t\tDDD \t\tNome \t\tNumero de Habitantes \t\tRenda Per Capita \t\tisCapital \t\tEstado \t\tPrefeito \n");

		cidadeDAO.findByIsCapital(capital).forEach(cidade -> System.out.println(cidade.toString()));
	}
	
	public static void main(String[] args) {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Scanner input = new Scanner(System.in);
		helloWorld();
		String nomeGerente = input.nextLine();

		while (true) {

			mainMenu(nomeGerente);
			String operation = input.nextLine();

			if (operation.equals("0")) {
				break;
			}

			switch (operation) {
			case "1": // Cadastrar Cidade
				if (save(input, cidadeDAO)) {
					userMessage("Cidade cadastrada com sucesso!");
				} else {
					userMessage("Falha no cadastrado da cidade!");
				}
				break;

			case "2": // Remover Cidade
				if (deleteByDdd(input, cidadeDAO)) {
					userMessage("Cidade removida com sucesso!");
				} else {
					userMessage("Falha na remocao da cidade!");
				}
				break;

			case "3": // Consultar Cidade
				selectByDdd(input, cidadeDAO);
				break;

			case "4": // Alterar Cidade
				if (update(input, cidadeDAO)) {
					userMessage("Cidade alterada com sucesso!");
				} else {
					userMessage("Falha na atualizacao da cidade!");
				}
				break;

			case "5": // Consultar Todas Cidades
				selectAll(cidadeDAO);
				break;
				
			case "6": // Consultar Cidades com Prefixo
				findByNomeStartingWith(input, cidadeDAO);
				break;
				
			case "7": // Consultar Cidades por Estado
				findByEstado(input, cidadeDAO);
				break;
				
			case "8": // Quantidade Cidade por Estado
				countByEstado(input, cidadeDAO);
				break;
				
			case "9": // Cidade Capital
				findByIsCapital(input, cidadeDAO);
				break;

			default:
				System.out.println("Opcao invalida.");
				break;
			}

		}

		// Criando os objetos
		/*
		 * Cidade saoPaulo = new Cidade(11, "São Paulo", 123456, 12645.00, "São Paulo",
		 * "Bolsonaro"); saoPaulo.setCapital(true);
		 * 
		 * Cidade vitoria = new Cidade(22, "Vitória", 14654, 468798.00,
		 * "Espírito Santo", "Lula"); vitoria.setCapital(true);
		 * 
		 * Cidade cariacica = new Cidade(27, "Cariacica", 68795, 21654.66,
		 * "Espiríto Santo", "Marina"); Cidade pindamaoigaba = new Cidade(12,
		 * "Pindamoigaba", 87956, 5468.66, "São Paulo", "José Sarney");
		 */

		// Inserindo no Banco
		/*
		 * cidadeDAO.insertInto(saoPaulo); cidadeDAO.insertInto(vitoria);
		 * cidadeDAO.insertInto(cariacica); cidadeDAO.insertInto(pindamaoigaba);
		 */

		// Recuperando Todos objetos
		/*
		 * System.out.println("Todas as cidades:"); cidadeDAO.selectAll().forEach(cidade
		 * -> { System.out.println(cidade.toString()); });
		 */

		// Recuperando Único Objeto
		/*
		 * System.out.println("Cidade DDD 22:"); System.out.println(
		 * cidadeDAO.selectByDdd(22).toString() );
		 */

		// Alterando Objeto
		/*
		 * pindamaoigaba.setPrefeito("Jão Frango"); cidadeDAO.update(pindamaoigaba);
		 */

		// Excluindo Objeto
		// cidadeDAO.delete(27);

	}

}
