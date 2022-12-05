package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import multa.dao.CondutorDAO;
import multa.dao.MultaDAO;
import multa.dao.VeiculoDAO;
import multa.entity.Condutor;
import multa.entity.Multa;
import multa.entity.Veiculo;

public class Main {

	private static void mainMenu() {
		System.out.println("\t\tEscolha a operacao desejada:");
		System.out.println("\t\t[ 1 ] - Cadastrar Condutor");
		System.out.println("\t\t[ 2 ] - Pesquisar Condutor");
		System.out.println("\t\t[ 3 ] - Listar Condutores");
		System.out.println("\t\t[ 4 ] - Excluir Condutor");
		System.out.println("\t\t[ 5 ] - Cadastrar Veículo");
		System.out.println("\t\t[ 6 ] - Pesquisar Veículo");
		System.out.println("\t\t[ 7 ] - Listar Veículos");
		System.out.println("\t\t[ 8 ] - Vender Veículo");
		System.out.println("\t\t[ 9 ] - Cadastrar Multa");
		System.out.println("\t\t[ 10 ] - Listar Multas");
		System.out.println("\t\t[ 0 ] - Sair");
		System.out.print("\t\t-> ");
	}

	private static void message(String message) {
		System.out.println("\t\t" + message);
	}

	private static Boolean cadastrarCondutor(CondutorDAO condutorDAO, Scanner input) {
		System.out.println("\t\tCADASTRAR CONDUTOR:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da CNH:");
		System.out.print("\t\t-> ");
		String nroCnh = input.nextLine();

		System.out.println("\t\tInforme o Órgão emissor:");
		System.out.print("\t\t-> ");
		String orgaoEmissor = input.nextLine();

		Condutor condutor = new Condutor();
		condutor.setNroCnh(nroCnh);
		condutor.setDataEmissao(LocalDate.now());
		condutor.setOrgaoEmissor(orgaoEmissor);

		return condutorDAO.save(condutor);
	}

	// Veículo null
	private static void pesquisarCondutor(CondutorDAO condutorDAO, Scanner input) {
		System.out.println("\t\tPESQUISAR CONDUTOR:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da CNH:");
		System.out.print("\t\t-> ");
		String nroCnh = input.nextLine();

		Condutor condutor = condutorDAO.findByCnh(nroCnh);

		if (condutor == null) {
			return;
		}

		System.out.println(condutor.toString());
	}

	// Veículo null
	private static void listarCondutores(CondutorDAO condutorDAO) {
		System.out.println("\t\tLISTAR CONDUTORES:");
		System.out.println("\t\t***********************************************");

		List<Condutor> condutores = condutorDAO.findAll();

		if (condutores.size() == 0) {
			return;
		}

		for (Condutor condutor : condutores) {
			System.out.println(condutor.toString());
		}
	}

	private static Boolean excluirCondutor(CondutorDAO condutorDAO, Scanner input) {
		System.out.println("\t\tEXCLUIR CONDUTOR:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da CNH:");
		System.out.print("\t\t-> ");
		String nroCnh = input.nextLine();

		return condutorDAO.removeByCnh(nroCnh);
	}

	private static Boolean cadastrarVeiculo(VeiculoDAO veiculoDAO, Scanner input) {
		System.out.println("\t\tCADASTRAR VEICULO:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da CNH:");
		System.out.print("\t\t-> ");
		String nroCnh = input.nextLine();

		System.out.println("\t\tInforme a Placa:");
		System.out.print("\t\t-> ");
		String placa = input.nextLine();

		System.out.println("\t\tInforme o Ano do veículo:");
		System.out.print("\t\t-> ");
		int ano = input.nextInt();
		input.nextLine();

		System.out.println("\t\tInforme o Modelo do veículo:");
		System.out.print("\t\t-> ");
		String modelo = input.nextLine();

		System.out.println("\t\tInforme a Marca do veículo:");
		System.out.print("\t\t-> ");
		String marca = input.nextLine();

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(placa);
		veiculo.setAno(ano);
		veiculo.setModelo(modelo);
		veiculo.setMarca(marca);

		return veiculoDAO.save(veiculo, nroCnh);
	}

	// Reference Circular
	private static void pesquisarVeiculo(VeiculoDAO veiculoDAO, Scanner input) {
		System.out.println("\t\tPESQUISAR VEICULO:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme a Placa:");
		System.out.print("\t\t-> ");
		String placa = input.nextLine();

		Veiculo veiculo = veiculoDAO.findByPlaca(placa);

		if (veiculo == null) {
			return;
		}

		System.out.println(veiculo.toString());
	}

	// Reference Circular
	private static void listarVeiculos(VeiculoDAO veiculoDAO) {
		System.out.println("\t\tLISTAR VEICULOS:");
		System.out.println("\t\t***********************************************");

		List<Veiculo> veiculos = veiculoDAO.findAll();

		if (veiculos.size() == 0) {
			return;
		}

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.toString());
		}
	}

	private static Boolean venderVeiculo(VeiculoDAO veiculoDAO, Scanner input) {
		System.out.println("\t\tVENDER VEICULO:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme o Numero da CNH do comprador:");
		System.out.print("\t\t-> ");
		String nroCnhComprador = input.nextLine();

		System.out.println("\t\tInforme a Placa:");
		System.out.print("\t\t-> ");
		String placa = input.nextLine();

		return veiculoDAO.addVendaVeiculo(placa, nroCnhComprador);
	}

	private static Boolean cadastrarMulta(MultaDAO multaDAO, Scanner input) {
		System.out.println("\t\tCADASTRAR MULTA:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme a Placa:");
		System.out.print("\t\t-> ");
		String placa = input.nextLine();

		System.out.println("\t\tInforme o Valor:");
		System.out.print("\t\t-> ");
		double valor = input.nextFloat();

		System.out.println("\t\tInforme a Pontuação:");
		System.out.print("\t\t-> ");
		int pontuacao = input.nextInt();

		Multa multa = new Multa();
		multa.setValor(valor);
		multa.setPontuacao(pontuacao);

		return multaDAO.save(multa, placa);
	}

	private static void listarMultas(VeiculoDAO veiculoDAO, Scanner input) {
		System.out.println("\t\tLISTAR MULTAS:");
		System.out.println("\t\t***********************************************");

		System.out.println("\t\tInforme a Placa:");
		System.out.print("\t\t-> ");
		String placa = input.nextLine();

		veiculoDAO.findMultasByPlaca(placa);
	}

	public static void main(String[] args) {

		CondutorDAO condutorDAO = new CondutorDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		MultaDAO multaDAO = new MultaDAO();
		Scanner input = new Scanner(System.in);

		while (true) {
			mainMenu();
			String operation = input.nextLine();

			if (operation.equals("0")) {
				break;
			}

			switch (operation) {
			case "1": // Cadastrar Condutor

				if (cadastrarCondutor(condutorDAO, input)) {
					message("Condutor cadastrado com sucesso!");
				} else {
					message("Falha no cadastrado do condutor.");
				}

				break;

			case "2": // Pesquisar Condutor

				pesquisarCondutor(condutorDAO, input);

				break;

			case "3": // Listar Condutores

				listarCondutores(condutorDAO);

				break;

			case "4": // Excluir Condutor

				if (excluirCondutor(condutorDAO, input)) {
					message("Condutor excluído com sucesso!");
				} else {
					message("Falha na exclusão do condutor.");
				}

				break;

			case "5": // Cadastrar Veículo

				if (cadastrarVeiculo(veiculoDAO, input)) {
					message("Veículo cadastrado com sucesso!");
				} else {
					message("Falha no cadastrado do veículo.");
				}

				break;

			case "6": // Pesquisar Veículo

				pesquisarVeiculo(veiculoDAO, input);

				break;

			case "7": // Listar Veículos

				listarVeiculos(veiculoDAO);

				break;

			case "8": // Vender Veículo

				if (venderVeiculo(veiculoDAO, input)) {
					message("Veículo vendido com sucesso!");
				} else {
					message("Falha na venda do veículo.");
				}

				break;

			case "9": // Cadastrar Multa

				if (cadastrarMulta(multaDAO, input)) {
					message("Multa cadastrada com sucesso!");
				} else {
					message("Falha na condastro da multa.");
				}

				break;

			case "10": // Listar Multas

				listarMultas(veiculoDAO, input);

				break;

			default:
				System.err.println("\t\tOpcao invalida, tente novamente.");

			}
		}

	}

}
