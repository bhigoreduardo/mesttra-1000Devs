/******************************************************************************
3. Faça um algoritmo para ler três notas de um aluno em uma disciplina e imprimir a sua
média ponderada (as notas tem pesos respectivos de 1, 2 e 3).
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe a nota 1: ");
		double nota1 = input.nextDouble();
		System.out.print("Informe a nota 2: ");
		double nota2 = input.nextDouble();
		System.out.print("Informe a nota 3: ");
		double nota3 = input.nextDouble();
		
		double mediaPonderada = (nota1 + (2 * nota2) + (3 * nota3)) / 6;
		
		System.out.println(String.format("A media ponderada das notas %.1f, %.1f," +
		" %.1f e: %.2f", nota1, nota2, nota3, mediaPonderada));
	}
}