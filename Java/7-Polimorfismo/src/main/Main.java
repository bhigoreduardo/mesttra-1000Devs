package main;

import model.Administrador;
import model.Fornecedor;
import model.Pessoa;

public class Main {
	
	public void main(String[] args) {
		
		Pessoa administrador = new Administrador("Saitama", "Cidade Z", "123156", 1234, 2165.95, 1354.12, 516.21);
		Pessoa fornecedor = new Fornecedor("Fubuki", "Cidade B", "21648", 1456.21, 12464.54);
		
		System.out.println("Administrador:");
		System.out.println(administrador.toString());
		
		System.out.println("Fornecedor:");
		System.out.println(fornecedor.toString());
		
	}

}
