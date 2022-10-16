/******************************************************************************
2. Faça um algoritmo que receba o valor do salário mínimo e o valor do salário de um
funcionário, calcule e mostre a quantidade de salários mínimos que ganha esse
funcionário.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o valor do salario minimo: ");
		double salarioMinimo = input.nextDouble();
		System.out.print("Informe o valor do salario do funcionario: ");
		double salarioFuncionario = input.nextDouble();
		
		double quantidadeSalario = salarioFuncionario / salarioMinimo;
		
		System.out.println(String.format("O funcionario recebe %.1f salarios minimo",
		quantidadeSalario));
	}
}