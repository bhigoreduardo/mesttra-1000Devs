/******************************************************************************
10. Faça um algoritmo que receba o ano de nascimento de uma pessoa e o ano atual,
calcule e mostre.
a) a idade dessa pessoa em anos;
b) a idade dessa pessoa em meses;
c) a idade dessa pessoa em dias; considere todos os meses com 30 dias
d) a idade dessa pessoa em semanas, considere que todos os messes possuem 4
semanas;
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int anoNascimento, anoAtual, idadeAnos, idadeMeses, idadeDias, idadeSemanas;

	    
		System.out.print("Digite o ano de nascimento: ");
		anoNascimento = input.nextInt();
		System.out.print("Digite o ano atual: ");
		anoAtual = input.nextInt();

        idadeAnos = anoAtual - anoNascimento;
        idadeMeses = idadeAnos * 12;
        idadeDias = idadeMeses * 30;
        idadeSemanas = idadeMeses * 4;
        
        System.out.println("A idade dessa pessoa em:");
        System.out.println("Anos e: " + idadeAnos);
        System.out.println("Meses e: " + idadeMeses);
        System.out.println("Dias e: " + idadeDias);
        System.out.println("Semanas e: " + idadeSemanas);
	}
}