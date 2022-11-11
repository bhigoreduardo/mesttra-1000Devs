/******************************************************************************
5. Faça um algoritmo que receba dois números inteiros, calcule e mostre a divisão do
primeiro número pelo segundo. Sabe-se que o segundo número não pode ser zero,
portanto não é necessário se preocupar com validações.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o valor 1: ");
		int valor1 = input.nextInt();
		System.out.print("Informe o valor 2: ");
		int valor2 = input.nextInt();
		
		System.out.println(String.format("A divisao de %d por %d e %.2f", valor1, 
		valor2, (valor1/(float) valor2)));
	}
}