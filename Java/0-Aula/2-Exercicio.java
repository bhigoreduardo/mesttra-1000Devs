/******************************************************************************
2. Faça um algoritmo que leia o nome do usuário, a quantidade de homens e mulheres
de uma turma, em seguinte, calcule e mostre o percentual de homens e mulheres da
turma.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String usuario;
		int qtdHomens, qtdMulheres;
		float percentualHomens;
		char percent = '%';
		
		System.out.print("Informe seu nome: ");
		usuario = input.nextLine();
		System.out.print("Informe a quantidade de homens da turma: ");
		qtdHomens = input.nextInt();
		System.out.print("Informe a quantidade de mulheres da turma: ");
		qtdMulheres = input.nextInt();
		
		percentualHomens = (float) (qtdHomens) / (qtdHomens + qtdMulheres) * 100;
		
		System.out.printf("%s o percentual de homens e: %.2f %c\n", usuario,
		percentualHomens, percent);
		System.out.printf("%s o percentual de mulheres e: %.2f %c\n", usuario,
		(100 - percentualHomens), percent);
	}
}