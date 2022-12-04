package main;

import model.Coordenador;
import model.Funcionario;
import model.FuncionarioAdministrativo;
import model.Professor;

public class Main {

	public static void main(String[] args) {
		Funcionario coordenador = new Coordenador("Saitama", "123456", 2136, "Cidade Z", 12315.88);
		Funcionario funcionarioAdm = new FuncionarioAdministrativo("Genos", "164879", 654, "Cidade A", 5468.56, "Heroi", "Classe S");
		Funcionario professor = new Professor("Fubuki", "45648", 4687, "Cidade B", 46879.64, "Doutorado", "Heroismo", 654, 164);
		
		System.out.println("Coordenador:");
		System.out.println(coordenador.toString());
		
		System.out.println("Administrador:");
		System.out.println(funcionarioAdm.toString());
		
		System.out.println("Professor:");
		System.out.println(professor.toString());
	}

}
