package model;

import java.util.HashMap;
import java.util.Map;

public class Estacionamento {

	private double valorEmCaixa;
	private int capacidadeMaxima;
	private Map<String, Carro> carrosEstacionados = new HashMap<String, Carro>();

	public Estacionamento(double valorEmCaixa, int capacidadeMaxima) {
		this.valorEmCaixa = valorEmCaixa;
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public boolean registrarEntrada(Carro carro) {
		if (this.carrosEstacionados.size() < this.capacidadeMaxima) {
			this.carrosEstacionados.put(carro.getPlaca(), carro);
			return true;
		}

		return false;
	}

	public boolean registrarSaida(String placa, double valorEstadia) {
		if (this.carrosEstacionados.remove(placa) != null) {
			this.valorEmCaixa += valorEstadia;
			return true;
		}

		return false;
	}

	public void imprimirSaldo() {
		System.out.println("Valor em caixa: " + this.valorEmCaixa);
	}

	public void carroPresente(String placa) {
		if (this.carrosEstacionados.get(placa) != null) {
			System.out.printf("Carro Placa: %s Presente.\n", placa);
			return;
		}

		System.out.printf("Carro Placa: %s Nao Encontrado.\n", placa);
	}

	public void mostrarPatio() {
		for (Carro carro : carrosEstacionados.values()) {
			System.out.println(carro.toString());
		}
	}

}
