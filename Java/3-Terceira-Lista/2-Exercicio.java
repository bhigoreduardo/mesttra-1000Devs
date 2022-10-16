/******************************************************************************
Questão 02: Faça um algoritmo que receba o valor do salário mínimo e o valor do
salário de um funcionário, calcule e mostre a quantidade de salários mínimos que
ganha esse funcionário. Caso o funcionário receba menos que 1 salário mínimo
deverá ser apresentado a mensagem “Funcionário ganha menos que um salário mínimo”.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o valor do salario minimo: ");
		float salarioMinimo = input.nextFloat();
		System.out.print("Informe o valor do salario do funcionario: ");
		float salarioFuncionario = input.nextFloat();
		
		float quantidadeSalarios = salarioFuncionario / salarioMinimo;
		
		if (quantidadeSalarios < 1) {
		    System.out.println("Funcionario ganha menos que um salario minimo");
		} else {
		    System.out.println(String.format("O funcionario recebe %.1f salarios"
		    +" minimos", quantidadeSalarios));
		}
	}
}