package main;

import model.Carro;
import model.Estacionamento;

public class Main {
	
	public static void main(String[] args) {

		Carro gol = new Carro("AHKS-584", "Branco", "VW", "Entrada");
		Carro golf = new Carro("ASUI-879", "Preto", "VW", "Intermediário");
		
		Estacionamento estacionamento = new Estacionamento(0.0f, 100);
		
		estacionamento.registrarEntrada(gol);
		estacionamento.registrarEntrada(golf);
		System.out.println("Carros estacionados:");
		estacionamento.mostrarPatio();
		
		estacionamento.registrarSaida("AHKS-584", 20.90);
		System.out.println("Saldo em caixa:");
		estacionamento.imprimirSaldo();
		System.out.println("Carros estacionados:");
		estacionamento.mostrarPatio();
		
		estacionamento.carroPresente("ASUI-879");
		
	}
	
}
