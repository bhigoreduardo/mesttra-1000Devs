/******************************************************************************
19. Entrar com o dia e o mês de uma data e informar quantos dias se passaram desde o
início do ano. Esqueça a questão dos anos bissextos e considere sempre que um mês
possui 30 dias.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int dia, mes, qtdDias;
		
		System.out.print("Digite o dia: ");
		dia = input.nextInt();
		System.out.print("Digite o mes: ");
		mes = input.nextInt();
		
		qtdDias = (30 * mes) + dia;

		System.out.printf("A quantidade de dias que se passaram foi: %d dias\n", qtdDias);
	}
}